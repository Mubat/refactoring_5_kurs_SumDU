package education.sumdu.Fifth.kurs.Shopping;

public class DiscountCalculating {

    /**
     * Calculates item's discount. For NEW item discount is 0%; For SECOND_FREE
     * item discount is 50% if quantity > 1 For SALE item discount is 70% For
     * each full 10 not NEW items item gets additional 1% discount, but not more
     * than 80% total
     */
    public static int calculateDiscount(ItemType type, int quantity) {
        int discount = 0;
        switch (type) {
        case NEW:
            return 0;

        case REGULAR:
            discount = 0;
            break;

        case SECOND_FREE:
            if (quantity > 1)
                discount = 50;
            break;

        case SALE:
            discount = 70;
            break;
        }
        if (discount < 80) {
            discount += quantity / 10;
            if (discount > 80)
                discount = 80;
        }

        return discount;
    }

}
