package education.sumdu.Fifth.kurs.Shopping.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import education.sumdu.Fifth.kurs.Shopping.test.kernel.TestDiscountCalculating;
import education.sumdu.Fifth.kurs.Shopping.test.kernel.TestItem;
import education.sumdu.Fifth.kurs.Shopping.test.kernel.TestShoppingCart;
import education.sumdu.Fifth.kurs.Shopping.test.utils.TestFormatter;

@RunWith(Suite.class)
@SuiteClasses({ TestDiscountCalculating.class, TestItem.class,
        TestShoppingCart.class, TestFormatter.class })
public class TestSuite {

}
