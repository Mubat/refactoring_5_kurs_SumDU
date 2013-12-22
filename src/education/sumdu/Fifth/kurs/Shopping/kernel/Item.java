package education.sumdu.Fifth.kurs.Shopping.kernel;

import education.sumdu.Fifth.kurs.Shopping.kernel.discount.Discount;

public class Item {
    private String title;
    private double price;
    private int quantity;
    private ItemType type;

    public Item() {
        setTitle("");
    }

    public Item(String title, double price, int quantity, ItemType type) {
        super();
        setTitle(title);
        setPrice(price);
        setQuantity(quantity);
        setType(type);
    }

    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            - item title 1 to 32 symbols
     */
    public void setTitle(String title) {
        if (title == null || title.length() == 0 || title.length() > 32)
            throw new IllegalArgumentException("Illegal title");
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    /**
     * @param price
     *            - item price in USD, > 0
     */
    public void setPrice(double price) {
        if (price < 0.01)
            throw new IllegalArgumentException("Illegal price");
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            - item quantity, from 1
     */
    public void setQuantity(int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Illegal quantity");
        this.quantity = quantity;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
    

    public int discount(){
            return Discount.calculate(getType(), getQuantity());
    }
    
    /**
     * Returns the price per item based on the quantity with discount on this product. 
     * */
    public double fullPrice(){
            return getPrice() * getQuantity() * (100.00 - discount()) / 100.00;
    }
}
