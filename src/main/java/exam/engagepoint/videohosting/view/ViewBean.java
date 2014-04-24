package exam.engagepoint.videohosting.view;

import exam.engagepoint.videohosting.controller.Dao;
import exam.engagepoint.videohosting.controller.FileHandlerBean;
import exam.engagepoint.videohosting.model.Item;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author artem.lysenko
 */
@Named(value = "viewBean")
@SessionScoped
public class ViewBean implements Serializable {

    private static final long serialVersionUID = 2L;

    @Inject
    Dao dao;
    @Inject
    FileHandlerBean fileHandler;
    StreamedContent movie;
    StreamedContent fileForDownload;

    public ViewBean() {
    }

    public Dao getDao() {
        return dao;
    }

    public StreamedContent getMovie() {
        return movie;
    }

    public StreamedContent showMovie() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("movieId");
        id = (id == null) ? "1" : id;
        int tmpId = Integer.parseInt(id);
        for (Item item : dao.getItemsList()) {
            if (tmpId == item.getId()) {
                movie = new DefaultStreamedContent(new ByteArrayInputStream(item.getBuffer()));
                fileForDownload = movie;
                return movie;
            }
        }
        return new DefaultStreamedContent(new ByteArrayInputStream(fileHandler.getBuffer()));
    }
}
