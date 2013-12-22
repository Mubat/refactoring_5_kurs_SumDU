package education.sumdu.Fifth.kurs.Shopping.kernel.discount;

import java.util.HashMap;
import java.util.Map;

import education.sumdu.Fifth.kurs.Shopping.kernel.ItemType;

class Builder {
    private static Map<ItemType, Class<? extends DiscountType>> actions;
    static {
        actions = new HashMap<ItemType, Class<? extends DiscountType>>();
        actions.put(ItemType.NEW, New.class);
        actions.put(ItemType.SALE, Sale.class);
        actions.put(ItemType.REGULAR, Regular.class);
        actions.put(ItemType.SECOND_FREE, SecondFree.class);
    }

    static DiscountType build(ItemType type) {
        try {
            return (DiscountType) actions.get(type).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("For action type: " + type
                    + ", builder cannot build handler.");
        }
    }
}

class New implements DiscountType {
    @Override
    public int discount(int quantity) throws UnsupportedDiscountException {
        throw new UnsupportedDiscountException("This type not supports.");
    }
}

class Sale implements DiscountType {
    @Override
    public int discount(int quantity) throws UnsupportedDiscountException {
        return 70;
    }
}

class Regular implements DiscountType {
    @Override
    public int discount(int quantity) throws UnsupportedDiscountException {
        return 0;
    }
}

class SecondFree implements DiscountType {
    @Override
    public int discount(int quantity) throws UnsupportedDiscountException {
        return quantity > 1? 50 : 0;
    }
}
