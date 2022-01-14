package com.cloud.platform.controller;

import com.cloud.platform.util.FileUploadUtils;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

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

  @ApiOperation("文件上传")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "上传成功！"),
          @ApiResponse(code = 500, message = "上传失败！")
  })
 @ApiImplicitParam(name = "file",value = "文件导入",required = true,dataType="MultipartFile",
       allowMultiple = true,paramType = "query")
  @PostMapping(value = "/uploadFile", consumes = "multipart/*", headers = "content-type=multipart/form-data")
 @ResponseBody
  public String  uploadFile (MultipartFile file){
    String dir="D:\\fileUpload\\";
    String result = FileUploadUtils.upLoadFileDao(file, dir);
    log.info("文件上传结果：{}",result);
    return result;
  }
  @ApiOperation("文件下载")
  @ApiImplicitParam(name = "filePath",value ="文件路径",required=true )
  @PostMapping ("/downloadFile")
  public void downloadFile (String filePath, HttpServletResponse response, HttpServletRequest request){
    File file=new File(filePath);
    String name = file.getName();
    FileUploadUtils.downloadFileDao(response,name, filePath);
  };
//  @Bean
//  public CommonsMultipartResolver multipartResolver() {
//    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//    multipartResolver.setDefaultEncoding("UTF-8");
//    multipartResolver.setMaxUploadSize(104857600);
//    return multipartResolver;
//  }
}
