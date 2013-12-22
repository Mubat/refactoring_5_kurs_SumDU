package education.sumdu.Fifth.kurs.Shopping.kernel;

import java.util.ArrayList;
import java.util.List;

/**
 * Containing items and calculating price.
 */
public class ShoppingCart {
    public void addItem(String title, double price, int quantity, ItemType type) {
        items.add(new Item(title, price, quantity, type));
    }

    public List<Item> getItems() {
        return items;
    }

    /** Container for added items */
    private List<Item> items = new ArrayList<Item>();
}
