package education.sumdu.Fifth.kurs.Shopping;

import education.sumdu.Fifth.kurs.Shopping.kernel.ItemType;
import education.sumdu.Fifth.kurs.Shopping.kernel.ShoppingCart;

public class Main {

        public static void main(String[] args) {
                ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 0.99, 5, ItemType.NEW);
        cart.addItem("Banana", 20.00, 4, ItemType.SECOND_FREE);
        cart.addItem("A long piece of toilet paper", 17.20, 1, ItemType.SALE);
        cart.addItem("Nails", 2.00, 500, ItemType.REGULAR);
        
        Formatter f = new Formatter();
        
        /* Цепочка вызовов. Могут возникнуть исключения */
        print(f.formatTicket(cart.getItems()));
        }
        
        static void print(Object ...objects){
                for(Object o : objects)
                        System.out.print(o + " ");
                System.out.println();
        }
}
