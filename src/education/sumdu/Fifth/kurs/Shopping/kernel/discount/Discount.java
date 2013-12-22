package education.sumdu.Fifth.kurs.Shopping.kernel.discount;

import education.sumdu.Fifth.kurs.Shopping.kernel.ItemType;

public class Discount {
    /**
     * Calculates item's discount. For NEW item discount is 0%; For SECOND_FREE
     * item discount is 50% if quantity > 1 For SALE item discount is 70% For
     * each full 10 not NEW items item gets additional 1% discount, but not more
     * than 80% total
     */
    public static int calculate(ItemType item, int quantity) {
        try {
            DiscountType type = Builder.build(item);
            int discount = type.discount(quantity);

            if (discount < 80) {
                discount += quantity / 10;
                if (discount > 80)
                    discount = 80;
            }
            return discount;

        } catch (UnsupportedDiscountException e) {
            return 0;
        }
    }
}