package education.sumdu.Fifth.kurs.Shopping.kernel;

import java.util.ArrayList;
import java.util.List;

/**
 * Containing items and calculating price.
 */
public class ShoppingCart {

    public void add(Item i) {
        items.add(i);
    }

    public void remove(Item i) {
        items.remove(i);
    }

    public List<Item> getItems() {
        return items;
    }

    /** Container for added items */
    private List<Item> items = new ArrayList<Item>();
}
