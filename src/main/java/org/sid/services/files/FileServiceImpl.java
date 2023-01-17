package org.sid.services.files;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.sid.DTO.UtilsClass.FileUtil;
import org.sid.enums.EnumFile;
import org.sid.utils.FunctionUtils;
import org.sid.utils.KeyUtils;
import jakarta.servlet.http.Part;

public class FileServiceImpl implements FileService{

    @Override
    public String uploadImage(Part part, String path , Integer user_id) throws IOException {
        // Check if the file is an image
        String contentType = part.getContentType();
        System.out.println("the content type is  => " + contentType);
        if (!contentType.startsWith("image/")) {
            // The file is not an image
            return null;
        }

        String filePath = KeyUtils.UPLOAD_PATH;

        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File dir2 = new File(filePath + path);
        if (!dir2.exists()) {
            dir2.mkdir();
        }

        Optional<String> extension = FunctionUtils.getExtensionByStringHandling(part.getSubmittedFileName());
        // Generate a unique file name
        // String fileName = "UUID.randomUUID().toString()";
        String fileName = "user_"+user_id+"."+extension.get() ; 
        File file = new File(filePath + "/" + path+ File.separator +  fileName);
        System.out.println("the absolute path is => " + file.getAbsolutePath());
        part.write(file.getAbsolutePath());

        return path+ File.separator +  fileName;
    }
    
    @Override
    public FileUtil uploadFile(Part part , String path , String whichFolder , String file_name) throws IOException {

          // Check if the file is an image
          String contentType = part.getContentType();
          System.out.println("the content type is  => " + contentType);
          
          String upload_path = KeyUtils.UPLOAD_PATH;
          // Tester l'existance du dossier /upload
          File dirInit = new File(upload_path);
          if (!dirInit.exists()) {
              dirInit.mkdir();
            }
          // Tester l'existance du dossier / groups 
          String upload_to_folder = KeyUtils.UPLOAD_PATH + "/" + path;
          File dir = new File(upload_to_folder);
          if (!dir.exists()) {
              dir.mkdir();
          }
          // Uploads / groups / group1 /  
          String specifique_folder =   upload_to_folder + "/" + whichFolder ; 
          File dir2 = new File(specifique_folder);
          if (!dir2.exists()) {
              dir2.mkdir();
          }
          //
          Optional<String> extension = FunctionUtils.getExtensionByStringHandling(part.getSubmittedFileName());
          // Generate a unique file name
          String fileName = UUID.randomUUID().toString() + "." + extension.get(); 
          File file = new File(specifique_folder+ File.separator +  fileName);
          System.out.println("the absolute path is => " + file.getAbsolutePath());
          part.write(file.getAbsolutePath());

          FileUtil fileUtil = new FileUtil() ; 

          fileUtil.setFile_extension(extension.get());
          fileUtil.setFile_path(path+whichFolder+File.separator+fileName);
          
          return fileUtil;
    }

    @Override
    public FileUtil uploadFileEvent(Part part, String path) throws IOException {
        // Check if the file is an image
        String contentType = part.getContentType();

        if (!contentType.startsWith("image/")) {
            // The file is not an image
            return null;
        }
    
        String filePath = KeyUtils.UPLOAD_PATH;
    
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String filePath_toSave = KeyUtils.UPLOAD_PATH + "/" + KeyUtils.UPLOAD_EVENTS_PATH;

        File dir2 = new File(filePath_toSave);
        if (!dir2.exists()) {
            dir2.mkdir();
        }
        Optional<String> extension = FunctionUtils.getExtensionByStringHandling(part.getSubmittedFileName());
        // Generate a unique file name
        // String fileName = "UUID.randomUUID().toString()";
        FileUtil fileUtil = new FileUtil() ; 
        String fileName = null ;
        if(extension.get().contains("jfif"))
        {
             fileName = UUID.randomUUID().toString()+"."+"jpg"; 
             fileUtil.setFile_extension("jpg");
        }
        else
        {
            fileName = UUID.randomUUID().toString()+"."+extension.get(); 
            fileUtil.setFile_extension(extension.get());
        }
        File file = new File(filePath + "/" + path+ File.separator +  fileName);
        part.write(file.getAbsolutePath());
        fileUtil.setFile_path(fileName);
        return   fileUtil;
    }

    
    
}
