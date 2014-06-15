package artem.videohosting.controller;

import artem.videohosting.model.Item;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author artem.lysenko
 */
@Named(value = "crudBean")
@RequestScoped
public class CrudBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int itemsCount = 0;
    private Item newItem = new Item();

    @Inject
    Dao dao;
    @Inject
    FileHandlerBean fileHandler;

    public CrudBean() {
    }

    public Item getNewItem() {
        return newItem;
    }

    public void createItem() {
        newItem.setId(++itemsCount);
        newItem.setBuffer(fileHandler.getBuffer());
        newItem.setDateOfCreation(new Date());
        dao.addItem(newItem);
    }

    public void deleteItem(Item itemToDelete) {
        dao.removeItem(itemToDelete);
    }
}
