package artem.videohosting.controller;

import artem.videohosting.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author artem.lysenko
 */
@Named(value = "dao")
@ApplicationScoped
public class Dao {

    private List<Item> itemsList = new ArrayList<>(5);

    public Dao() { 
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void addItem(Item newItem) {
        itemsList.add(newItem);
    }

    public void removeItem(Item uselessItem) {
        itemsList.remove(uselessItem);
    }
}
