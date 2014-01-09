package education.sumdu.Fifth.kurs.Shopping.test.kernel;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import education.sumdu.Fifth.kurs.Shopping.kernel.Item;
import education.sumdu.Fifth.kurs.Shopping.kernel.ItemType;

public class TestItem{
    
    private static final double errorDelta = 0.000001;
    private Item testItem;

    @Before
    public void setUp() {
        testItem = new Item("TestItem", 2.0, 1, ItemType.NEW);
    }
    
    @Test
    public void testItem() {
        Assert.assertEquals("Price of new item not equal", testItem.getPrice(), 2, errorDelta);
        Assert.assertEquals("Count of new item not equal", testItem.getQuantity(), 1);
        Assert.assertEquals("ItemType of new item not equal", testItem.getType(), ItemType.NEW);
    }
    
    @Test
    public void testExceptionItem() {
        try {
            new Item();
            TestCase.fail("Class Item not generate expected exception after setting illegal title value." +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal title", e.getMessage());
        }
    }

    @Test
    public void testExceptionItemQuantity() {
        try {
            testItem.setQuantity(-1);
            TestCase.fail("Class Item not generate expected exception after setting illegal quantity value." +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal quantity", e.getMessage());
        }

        try {
            testItem.setQuantity(Integer.MIN_VALUE);
            TestCase.fail("Class Item not generate expected exception after setting illegal quantity value." +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal quantity", e.getMessage());
        }

        try {
            testItem.setQuantity(0);
            TestCase.fail("Class Item not generate expected exception after setting illegal quantity value." +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal quantity", e.getMessage());
        }
    }

    @Test
    public void testExceptionItemPrice() {
        try { 
            testItem.setPrice(-errorDelta);
            TestCase.fail("Class Item not generate expected exception after setting illegal price value. " +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal price", e.getMessage());
        }

        try { 
            testItem.setPrice(-10);
            TestCase.fail("Class Item not generate expected exception after setting illegal price value. " +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal price", e.getMessage());
        }

        try { 
            testItem.setPrice(-10);
            TestCase.fail("Class Item not generate expected exception after setting illegal price value. " +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal price", e.getMessage());
        }
    }
    
    @Test
    public void testExceptionItemTitle() {
        try { 
            testItem.setTitle(null);
            TestCase.fail("Class Item not generate expected exception after setting illegal title value. " +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal title", e.getMessage());
        }

        try { 
            testItem.setTitle("");
            TestCase.fail("Class Item not generate expected exception after setting illegal title value. " +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal title", e.getMessage());
        }

        try { 
            testItem.setTitle("AbraKadabraTestItemWithLengthMoreThenThirtyTwo");
            TestCase.fail("Class Item not generate expected exception after setting illegal title value. " +
                    "[ER] IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Illegal title", e.getMessage());
        }
    }
    
    @Test
    public void testFullPrice_NEW() {
        testItem.setPrice(20.05);
        check(ItemType.NEW, 1, 20.05);
        check(ItemType.NEW, 1000, 20050);

        check(ItemType.REGULAR, 1, 20.05);
        check(ItemType.REGULAR, 10, 198.495);
        check(ItemType.REGULAR, 1000, 4010);

        check(ItemType.SECOND_FREE, 1, 20.05);
        check(ItemType.SECOND_FREE, 9, 90.225);
        check(ItemType.SECOND_FREE, 110, 860.145);
        check(ItemType.SECOND_FREE, 310, 1243.1);

        check(ItemType.SALE, 1, 6.015);
        check(ItemType.SALE, 10, 58.145);
        check(ItemType.SALE, 110, 441.1);
    }
    
    private void check(ItemType type, int quantity, double expectedResult) {
        testItem.setType(type);
        testItem.setQuantity(quantity);
        double result = testItem.fullPrice();
        Assert.assertEquals("Checking of calculating discount FAILURE for" +
                " type=" + type + " and quantity=" + quantity,
                expectedResult, result, errorDelta);
    }
}