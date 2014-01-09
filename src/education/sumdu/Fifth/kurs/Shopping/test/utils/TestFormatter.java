package education.sumdu.Fifth.kurs.Shopping.test.utils;

import java.util.regex.Pattern;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import education.sumdu.Fifth.kurs.Shopping.kernel.Item;
import education.sumdu.Fifth.kurs.Shopping.kernel.ItemType;
import education.sumdu.Fifth.kurs.Shopping.kernel.ShoppingCart;
import education.sumdu.Fifth.kurs.Shopping.utils.Formatter;

public class TestFormatter {
    private ShoppingCart cart;
    
    @Before
    public void testCreateItems() {
        cart = new ShoppingCart();
        cart.add(new Item("One", 1, 2, ItemType.NEW));
        cart.add(new Item("Two Two", 22.00, 4, ItemType.SECOND_FREE));
    }

    @Test
    public void testFormatNullTicket() {
        Assert.assertEquals(Formatter.getInstance().formatTicket(null), "No items.");
    }

    @Test
    public void testFormatNotNullTicket() {
        String result = Formatter.getInstance().formatTicket(cart);
        Matcher<String> matcher = new TicketMatcher<String>();        
        Assume.assumeThat(result, matcher);
    }
    
    
    public class TicketMatcher<T> implements Matcher<T> {

        @Override
        public boolean matches(Object arg0) {
            Assert.assertTrue("Returned object type must be String", 
                    arg0.getClass().equals(String.class));
            Pattern patternHeader = Pattern.compile("^\\s*# Item[\\c|\\s]* Price[\\c|\\s]* Quan\\.[\\c|\\s]* Discount[\\c|\\s]* Total\\n-{1,}\\n");
            Pattern patternFooter = Pattern.compile("\\n-{1,}\\n\\d+[\\c|\\s]*\\$\\d+\\.\\d{1,2}[\\c|\\s]*$");
            java.util.regex.Matcher matcherHeader = patternHeader.matcher((String) arg0);
            java.util.regex.Matcher matcherFooter = patternFooter.matcher((String) arg0);
            return matcherHeader.find() && matcherFooter.find();
        }

        @Override
        public void describeTo(Description arg0) {
            arg0.appendText("Cart must contains Header and Footer. Footer returns items count and total amount.");
        }

        @Override
        public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {}
        
    }
}
