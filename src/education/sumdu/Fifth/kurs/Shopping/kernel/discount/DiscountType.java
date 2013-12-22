package education.sumdu.Fifth.kurs.Shopping.kernel.discount;

interface DiscountType {
    int discount(int quantity) throws UnsupportedDiscountException;
}
