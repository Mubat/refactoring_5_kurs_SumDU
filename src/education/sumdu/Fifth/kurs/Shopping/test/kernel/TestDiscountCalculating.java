package education.sumdu.Fifth.kurs.Shopping.test.kernel;

import org.junit.Assert;
import org.junit.Test;

import education.sumdu.Fifth.kurs.Shopping.kernel.DiscountCalculating;
import education.sumdu.Fifth.kurs.Shopping.kernel.ItemType;

public class TestDiscountCalculating {

    @Test
    public void testDiscount_NEW() {
        check(ItemType.NEW, 1, 0);
        check(ItemType.NEW, 10, 0);
        check(ItemType.NEW, 1000, 0);
    }
    
    @Test
    public void testDiscount_REGULAR() {
        check(ItemType.REGULAR, 1, 0);
        check(ItemType.REGULAR, 9, 0);
        check(ItemType.REGULAR, 10, 1);
        check(ItemType.REGULAR, 790, 79);
        check(ItemType.REGULAR, 800, 80);
        check(ItemType.REGULAR, 810, 80);
        check(ItemType.REGULAR, 1000, 80);
    }
    
    @Test
    public void testDiscount_SECOND_FREE() {
        check(ItemType.SECOND_FREE, 1, 0);
        check(ItemType.SECOND_FREE, 2, 50);
        check(ItemType.SECOND_FREE, 10, 51);
        check(ItemType.SECOND_FREE, 110, 61);
        check(ItemType.SECOND_FREE, 300, 80);
        check(ItemType.SECOND_FREE, 310, 80);
        check(ItemType.SECOND_FREE, 500, 80);
    }
    
    @Test
    public void testDiscount_SALE() {
        check(ItemType.SALE, 1, 70);
        check(ItemType.SALE, 9, 70);
        check(ItemType.SALE, 10, 71);
        check(ItemType.SALE, 100, 80);
        check(ItemType.SALE, 110, 80);
        check(ItemType.SALE, 310, 80);
    }
    
    private void check(ItemType type, int quantity, int expectedResult) {
        int result = DiscountCalculating.calculateDiscount(type, quantity);
        Assert.assertEquals("Checking of calculating discount FAILURE for" +
        		" type=" + type + " and quantity=" + quantity + 
        		"[ER] " + expectedResult +
        		"; [AR] " + result, expectedResult, result);
    }
}