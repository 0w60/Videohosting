package artem.videohosting.view;

import artem.videohosting.controller.Dao;
import artem.videohosting.controller.FileHandlerBean;
import artem.videohosting.model.Item;
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
@Named(value = "viewMovieBean")
@SessionScoped
public class ViewMovieBean implements Serializable {

    private static final long serialVersionUID = 3L;
    private Item selectedItem;
    private StreamedContent movie;
    private StreamedContent fileToDownload;
    private String comment;

    @Inject
    ViewBean viewBean;
    @Inject
    Dao dao;
    @Inject
    FileHandlerBean fileHandler;

    public ViewMovieBean() {
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public StreamedContent showMovie() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("viewMovieId");
        id = (id == null) ? "1" : id;
        int tmpId = Integer.parseInt(id);
        for (Item item : dao.getItemsList()) {
            if (tmpId == item.getId()) {
                movie = new DefaultStreamedContent(new ByteArrayInputStream(item.getBuffer()));
                fileToDownload = movie;
                return movie;
            }
        }
        return new DefaultStreamedContent(new ByteArrayInputStream(selectedItem.getBuffer()));
    }

    public StreamedContent getFileToDownload() {
        return fileToDownload;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void addCommentToCommentsList() {
        selectedItem.setCommentsList(comment);
    }
}
