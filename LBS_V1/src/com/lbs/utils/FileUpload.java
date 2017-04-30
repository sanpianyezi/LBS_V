package com.lbs.utils;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by shhao.
 * Date: 14-9-1
 * Time:下午4:12
 */
public class FileUpload {

    public static   String FILE_PATH = "../images/";
    public static final   String FILE_PATH1 = "D:/upload/";

    //文件上传
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        
        
        
        //再存一边保存
//        File tempFile1 = new File(FILE_PATH1, String.valueOf(fileName));
//        if (!tempFile1.getParentFile().exists()) {
//            tempFile1.getParentFile().mkdir();
//        }
//        if (!tempFile1.exists()) {
//            tempFile1.createNewFile();
//        }
//        file.transferTo(tempFile1);
        
        
        
        FILE_PATH = request.getServletContext().getRealPath("/")+"WEB-INF/images/upload/" ;
        File tempFile = new File(FILE_PATH,  String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        
        
        //再存一边保存
        FileUpload.copyFile(FILE_PATH+String.valueOf(fileName),FILE_PATH1+String.valueOf(fileName));
        
//        return "/download?fileName=" + tempFile.getName();
        return FILE_PATH1 + tempFile.getName();
    }

    public static File getFile(String fileName) {
        return new File(FILE_PATH, fileName);
    }
    
    
    
    
    /** 
     * 复制单个文件 
     * @param oldPath String 原文件路径 如：c:/fqf.txt 
     * @param newPath String 复制后路径 如：f:/fqf.txt 
     * @return boolean 
     */ 
   public static void copyFile(String oldPath, String newPath) { 
       try { 
           int bytesum = 0; 
           int byteread = 0; 
           File oldfile = new File(oldPath); 
           if (oldfile.exists()) { //文件存在时 
               InputStream inStream = new FileInputStream(oldPath); //读入原文件 
               FileOutputStream fs = new FileOutputStream(newPath); 
               byte[] buffer = new byte[1444]; 
               int length; 
               while ( (byteread = inStream.read(buffer)) != -1) { 
                   bytesum += byteread; //字节数 文件大小 
//                   System.out.println(bytesum); 
                   fs.write(buffer, 0, byteread); 
               } 
               fs.flush();
               inStream.close(); 
               fs.close();
           } 
       } 
       catch (Exception e) { 
           System.out.println("复制单个文件操作出错"); 
           e.printStackTrace(); 

       }

   } 
   
   //文件上传
   public static String uploadFileApi(MultipartFile file, HttpServletRequest request) throws IOException {
       String fileName = file.getOriginalFilename();
       
       
       
       //再存一边保存
//       File tempFile1 = new File(FILE_PATH1, String.valueOf(fileName));
//       if (!tempFile1.getParentFile().exists()) {
//           tempFile1.getParentFile().mkdir();
//       }
//       if (!tempFile1.exists()) {
//           tempFile1.createNewFile();
//       }
//       file.transferTo(tempFile1);
       
       
       
       FILE_PATH = request.getServletContext().getRealPath("/")+"WEB-INF/images/upload/" ;
       File tempFile = new File(FILE_PATH,  String.valueOf(fileName));
       if (!tempFile.getParentFile().exists()) {
           tempFile.getParentFile().mkdir();
       }
       if (!tempFile.exists()) {
           tempFile.createNewFile();
       }
       file.transferTo(tempFile);
       
       
       //再存一边保存
       FileUpload.copyFile(FILE_PATH+String.valueOf(fileName),FILE_PATH1+String.valueOf(fileName));
       
//       return "/download?fileName=" + tempFile.getName();
       return tempFile.getName();
   }
   
   
   //文件上传
   public static String uploadImages(MultipartFile file,String siteId ,String imagesType, HttpServletRequest request) throws IOException {
       String fileName = file.getOriginalFilename();
       String suff= fileName.substring(fileName.indexOf("."), fileName.length());
       fileName = siteId+imagesType+suff;
       
       
       FILE_PATH = request.getServletContext().getRealPath("/")+"WEB-INF/images/upload/" ;
       File tempFile = new File(FILE_PATH,  String.valueOf(fileName));
       if (!tempFile.getParentFile().exists()) {
           tempFile.getParentFile().mkdir();
       }
       if (!tempFile.exists()) {
           tempFile.createNewFile();
       }else{
    	   tempFile.delete();
       }
       file.transferTo(tempFile);
       
       
       //再存一边保存
       FileUpload.copyFile(FILE_PATH+String.valueOf(fileName),FILE_PATH1+String.valueOf(fileName));
       
//       return "/download?fileName=" + tempFile.getName();
       return tempFile.getName();
   }
   
   //文件删除
   public static void deleteImages(String fileName ,  HttpServletRequest request) throws IOException {
       
       FILE_PATH = request.getServletContext().getRealPath("/")+"WEB-INF/images/upload/" ;
       File tempFile = new File(FILE_PATH,  String.valueOf(fileName));
       if (tempFile.exists()) {
           tempFile.delete();
       }
       
       
       //再删除一遍
       File tempFile1 = new File(FILE_PATH1,  String.valueOf(fileName));
       if (tempFile1.exists()) {
    	   tempFile1.delete();
       }
   }
}