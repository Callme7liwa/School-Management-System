package org.sid.services.files;

import java.io.IOException;

import org.sid.DTO.UtilsClass.FileUtil;

import jakarta.servlet.http.Part;

public interface FileService {
    
    public String uploadImage(Part part , String path , Integer user_id) throws IOException;

    public FileUtil uploadFile(Part part  , String path , String whichFolder , String file_name ) throws IOException ; 

    public FileUtil uploadFileEvent(Part part , String path  ) throws IOException;
    
}
