package Bean;


import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
 
import org.apache.commons.io.FilenameUtils;
 
@ManagedBean(name="jsfFileUploadBean")
@RequestScoped
 
public class FileUploadBean implements Serializable{
 
/**
     *
     */
    private static final long serialVersionUID = 1L;
 
    private String name;
    private Part file;
    private String projectPath = System.getProperty("user.dir");
    public Part getFile() {
        return file;
    }
 
    public void setFile(Part file) {
        this.file = file;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }
    
 
//Processing of  file uploading.
 
    public void processFileUpload() {
 
        Part uploadedFile=getFile();
//        FilenameUtils.getName(getSubmittedFileName(uploadedFile))
         final Path destination = Paths.get(projectPath+"/images/"+getName()+".jpg" );
         System.out.println("FileUploadBean.processFileUpload()"+destination.toString());
         //When using servlet 3.1
          //final Path destination = Paths.get("c:/temp/"+ FilenameUtils.getName(uploadedFile.getSubmittedFileName()));
 
         InputStream bytes=null;
 
            if (null!=uploadedFile) {
 
            try {
                bytes = uploadedFile.getInputStream();  //
                
                //Copies bytes to destination.
                Files.copy(bytes, destination);
            } catch (IOException ex) {
                Logger.getLogger(FileUploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
// 
//        return "Ack";
    }
 
    //code to get the submitted file name from the file part header. 
 
    public static String getSubmittedFileName(Part filePart)
    {
        String header = filePart.getHeader("content-disposition");
        if(header == null)
            return null;
        for(String headerPart : header.split(";"))
        {
            if(headerPart.trim().startsWith("filename"))
            {
                return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}