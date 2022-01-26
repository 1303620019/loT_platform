package com.cloud.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkFile;
import com.cloud.platform.entity.device.DeviceLinkFileSign;
import com.cloud.platform.service.device.IDeviceLinkFileService;
import com.cloud.platform.service.device.IDeviceLinkFileSignService;
import com.cloud.platform.util.FileUploadUtils;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform
 * @author:byl
 * @createTime:2022/1/13 17:44
 * @version:1.0
 */
@Slf4j
@Api(tags = "文件管理")
@Controller
@CrossOrigin //允许跨域
@RequestMapping("/file")
public class FileController {

  @Resource
  private IDeviceLinkFileService fileService;
  @Resource
  private IDeviceLinkFileSignService signService;
  @ApiOperation("文件上传")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "上传成功！"),
          @ApiResponse(code = 500, message = "上传失败！")
  })
 @ApiImplicitParam(name = "file",value = "文件导入",required = true,dataType="MultipartFile",
       allowMultiple = true,paramType = "query")
  @PostMapping(value = "/uploadFile", consumes = "multipart/*", headers = "content-type=multipart/form-data")
 @ResponseBody
  public ResultVo uploadFile (MultipartFile file,Integer dlfType){
    long size = file.getSize();
    JSONObject jsonObject=new JSONObject();
    String filename = file.getOriginalFilename();
    String fileSuffix = filename.substring(filename.indexOf("."));
    Map map = FileUploadUtils.upLoadFileDao(file);
    String result="";
    String md5 ="";
    if (MapUtils.isNotEmpty(map)){
      result=map.get("url").toString();
      md5=map.get("MD5").toString();
    }
   if (dlfType == 0 || dlfType ==1){
     DeviceLinkFile  file1=new DeviceLinkFile();
     if (size>1024){
       file1.setSize(Integer.parseInt(size/ 1024+""));
     }else{
       file1.setSize(Integer.parseInt(size+""));
     }
     file1.setName(filename);
     file1.setMd5(md5);
     file1.setDlfType(dlfType);
     file1.setFiletype(fileSuffix);
     file1.setUrl(result);
     fileService.save(file1);
     jsonObject.put("filename",filename);
     jsonObject.put("fild",file1.getDlfId());
   }else if (dlfType == 2){
      DeviceLinkFileSign sign=new DeviceLinkFileSign();
     sign.setMd5(md5);
     sign.setUrl(result);
     sign.setDlsCreatetime(new Date());
     if (size>1024){
       sign.setSize(Integer.parseInt(size/ 1024+""));
     }else{
       sign.setSize(Integer.parseInt(size+""));
     }
     sign.setName(filename);
     signService.save(sign);
     jsonObject.put("filename",filename);
     jsonObject.put("fild",sign.getDlsId());
   }
    log.info("文件上传结果：{}",result);
    return ResultVo.ok( jsonObject);
  }
  @ApiOperation("文件下载")
  @ApiImplicitParam(name = "filePath",value ="文件路径",required=true )
  @PostMapping ("/downloadFile")
  public void downloadFile (String filePath, HttpServletResponse response, HttpServletRequest request){
    File file=new File(filePath);
    String name = file.getName();
    FileUploadUtils.downloadFileDao(response,name, filePath);
  };
  public String createSign(String md5){
    DeviceLinkFileSign  sign=new DeviceLinkFileSign();
    String fileName = FileUploadUtils.writeSgin(md5);
    sign.setName(fileName);
    sign.setUrl("http://192.168.1.146:8991/static/"+fileName);
    sign.setMd5(md5);
    sign.setDlsCreatetime(new Date());
    signService.save(sign);
    return sign.getDlsId();
  }
}
