package exam.engagepoint.videohosting.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author artem.lysenko
 */
@Named(value = "fileHandleBean")
@RequestScoped
public class FileHandlerBean {

    private UploadedFile file;
    private byte[] buffer;

    public FileHandlerBean() {
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void makeBuffer() {
        try {
            int bufferSize = file.getInputstream().available();
            buffer = new byte[bufferSize];
            file.getInputstream().read(buffer);
        } catch (IOException ex) {
            Logger.getLogger(FileHandlerBean.class.getName()).log(Level.SEVERE, 
                    "Could not read from Input stream into the buffer ", ex);
        }
    }

    public UploadedFile getFile() {
        return file;
    }
}
