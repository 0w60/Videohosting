package artem.videohosting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author artem.lysenko
 */
public class Item {

    private byte[] buffer;
    private List<String> commentsList = new ArrayList<>(5);
    private int countOfComments = 0;
    private int countOfLikes = 0;
    private Date dateOfCreation;
    private String description = "";
    private int id = 0;

    public Item() {

    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public List<String> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(String comment) {
        commentsList.add(comment);
        countOfComments++;
    }

    public int getCountOfComments() {
        return countOfComments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    public void addLike() {
        countOfLikes++;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
