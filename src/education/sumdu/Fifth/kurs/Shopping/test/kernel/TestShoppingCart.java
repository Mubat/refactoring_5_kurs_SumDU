package education.sumdu.Fifth.kurs.Shopping.test.kernel;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import education.sumdu.Fifth.kurs.Shopping.format.Line;
import education.sumdu.Fifth.kurs.Shopping.kernel.Item;
import education.sumdu.Fifth.kurs.Shopping.kernel.ItemType;
import education.sumdu.Fifth.kurs.Shopping.kernel.ShoppingCart;

/**
 * Containing items and calculating price.
 */
public class TestShoppingCart {
    
    private ShoppingCart testCart;

    @Before
    public void setUp() {
        testCart = new ShoppingCart();
    }
    
    @Test
    public void testShoppingCartInitialize() {
        Assert.assertEquals(0, testCart.size());
        
        Assert.assertTrue(new ArrayList<Item>().equals(testCart.getItems()));
    }
    
    @Test
    public void testAdd() {
        List<Item> expectedList = new ArrayList<Item>();
        Item testItem = new Item("TestItem1", 2.0, 1, ItemType.NEW);
        testCart.add(testItem);
        expectedList.add(testItem);
        
        Assert.assertTrue(expectedList.equals(testCart.getItems()));
        
        testItem = new Item("TestItem2", 2.0, 1, ItemType.NEW);
        testCart.add(testItem);
        expectedList.add(testItem);
        testItem = new Item("TestItem3", 1.0, 1, ItemType.REGULAR);
        testCart.add(testItem);
        expectedList.add(testItem);
        
        Assert.assertTrue(expectedList.equals(testCart.getItems()));
    }
    
    @Test
    public void testTotal() {
        Assert.assertEquals(0.0, testCart.total(), 0.000001);
        testCart.add(new Item("TestItem2", 20.05, 1, ItemType.NEW));
        Assert.assertEquals(20.05, testCart.total(), 0.000001);
        testCart.add(new Item("TestItem3", 20.05, 1000, ItemType.REGULAR));
        Assert.assertEquals(4030.05, testCart.total(), 0.000001);
        testCart.add(new Item("TestItem3", 20.05, 310, ItemType.SECOND_FREE));
        Assert.assertEquals(5273.15, testCart.total(), 0.000001);
    }
    
    @Test
    public void testRemove() {
        List<Item> expectedList = new ArrayList<Item>();
        Item testItem = new Item("TestItem1", 2.0, 1, ItemType.NEW);
        testCart.add(testItem);
        expectedList.add(testItem);
        expectedList.remove(testItem);
        testCart.remove(testItem);
        
        Assert.assertTrue(expectedList.equals(testCart.getItems()));
        
        Item testItem2 = new Item("TestItem2", 2.0, 1, ItemType.NEW);
        testCart.add(testItem2);
        expectedList.add(testItem2);
        Item testItem3 = new Item("TestItem3", 1.0, 1, ItemType.REGULAR);
        testCart.add(testItem3);
        expectedList.add(testItem3);
        
        expectedList.remove(testItem2);
        expectedList.remove(testItem3);
        testCart.remove(testItem2);
        testCart.remove(testItem3);
        Assert.assertTrue(expectedList.equals(testCart.getItems()));
    }
    
    @Test(expected=NullPointerException.class)
    public void testNullPointerExceptionRemove() throws NullPointerException {
        List<Item> expectedList = new ArrayList<Item>();
        Item testItem = new Item("TestItem1", 2.0, 1, ItemType.NEW);
        expectedList.add(testItem);
        expectedList.remove(null);
        Assert.fail("Expected NullPointerException not returned " +
                "after removing same Item twice from Cart.");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionRemove() throws IllegalArgumentException {
        List<Item> expectedList = new ArrayList<Item>();
        Item testItem = new Item("TestItem1", 2.0, 1, ItemType.NEW);
        expectedList.add(testItem);
        expectedList.remove(testItem);
        expectedList.remove(testItem);
        Assert.fail("Expected IllegalArgumentException not returned " +
        		"after removing same Item twice from Cart.");
    }
    
}