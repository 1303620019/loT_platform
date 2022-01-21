package com.cloud.platform.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;


public class FileUploadUtils {


    private static Logger logger = LoggerFactory.getLogger(FileUploadUtils.class);
    /**
     * @Author: byl
     * @Description:
     * @Date: 2022-01-13
     * @Param: file:文件 rootDir：上传跟路径
     * @Return:
     */
    public static String upLoadFileDao(MultipartFile file) {

        if (Objects.isNull(file) || file.isEmpty()) {
            logger.info("文件为空");
            return "文件为空，请重新上传";
        }
        try {

            // 获取文件的名称
            String originalFilename = file.getOriginalFilename();
            // 文件后缀 例如：.png
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // uuid 生成文件名
            String uuid = String.valueOf(UUID.randomUUID());
           String basePath = ResourceUtils.getURL("classpath:").getPath() + "static/upload/";
           basePath=basePath.substring(1);
            //      String basePath="D:/fileUpload/";
            byte[] bytes = file.getBytes();
            String fileName=uuid+fileSuffix;
            Path path = Paths.get(basePath+fileName);
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(basePath));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            logger.debug("文件写入成功...");
            return "http://" + InetAddress.getLocalHost().getHostAddress() + ":8991/static/upload/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }
    /**
     * @Author: byl
     * @Description: 文件下载，输入文件名和文件路径
     * @Date: 2022-01-13
     * @Param:
     * @Return:
     */
    public static void downloadFileDao(HttpServletResponse response, String fileName, String path){
        if (fileName != null) {
            //设置文件路径
            File file = new File(path);
            if (file.exists()) {
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                try {
                    response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static String writeSgin(String text) {
        File file = null;
        FileWriter fw = null;
        try {
            // uuid 生成文件名
        String uuid = String.valueOf(UUID.randomUUID());
        String fileNmae=uuid+".txt";
        String basePath = ResourceUtils.getURL("classpath:").getPath() + "static/"+fileNmae;
        basePath=basePath.substring(1);
        file = new File(basePath);
        if (!file.exists()) {
            file.createNewFile();
        }
         fw=new FileWriter(file);
          fw.write(text);        //加上换行
        return fileNmae;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}