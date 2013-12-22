package education.sumdu.Fifth.kurs.Shopping;

import education.sumdu.Fifth.kurs.Shopping.kernel.Item;
import education.sumdu.Fifth.kurs.Shopping.kernel.ItemType;
import education.sumdu.Fifth.kurs.Shopping.kernel.ShoppingCart;
import education.sumdu.Fifth.kurs.Shopping.utils.Formatter;

public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Item("Apple", 0.99, 5, ItemType.NEW));
        cart.add(new Item("Banana", 20.00, 4, ItemType.SECOND_FREE));
        cart.add(new Item("A long piece of toilet paper", 
                          17.20, 1, ItemType.SALE));
        cart.add(new Item("Nails", 2.00, 500, ItemType.REGULAR));

        Formatter f = new Formatter();

        /* Цепочка вызовов. Могут возникнуть исключения */
        print(f.formatTicket(cart.getItems()));
    }

    static void print(Object... objects) {
        for (Object o : objects)
            System.out.print(o + " ");
        System.out.println();
    }
}
