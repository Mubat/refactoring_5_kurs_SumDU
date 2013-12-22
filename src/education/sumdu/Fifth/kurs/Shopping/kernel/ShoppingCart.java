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

    public int size() {
        return items.size();
    }

    public double total() {
        double total = 0.0;
        for (Item i : items)
            total += i.fullPrice();
        return total;
    }

    /** Container for added items */
    private List<Item> items = new ArrayList<Item>();
}