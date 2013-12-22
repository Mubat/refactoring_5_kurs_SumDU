package education.sumdu.Fifth.kurs.Shopping;

import education.sumdu.Fifth.kurs.Shopping.kernel.Item;
import education.sumdu.Fifth.kurs.Shopping.kernel.ItemType;
import education.sumdu.Fifth.kurs.Shopping.kernel.ShoppingCart;
import education.sumdu.Fifth.kurs.Shopping.utils.Formatter;

public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = init(); // Получаем зависимость, а не создаем

        /* Цепочка вызовов. Могут возникнуть исключения */
        print(cart);
    }

    static ShoppingCart init() {
        return new ShoppingCart() {
            {
                add(new Item("Apple", 0.99, 5, ItemType.NEW));
                add(new Item("Banana", 20.00, 4, ItemType.SECOND_FREE));
                add(new Item("A long piece of toilet paper", 17.20, 1,
                        ItemType.SALE));
                add(new Item("Nails", 2.00, 500, ItemType.REGULAR));
            }
        };
    }

    static void print(ShoppingCart cart) {
        System.out.println(Formatter.getInstance().formatTicket(cart));
    }
}
