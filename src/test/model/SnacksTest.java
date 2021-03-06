package model;

import model.Food;
import model.Snacks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnacksTest {

    private Food snacks;
    private Singleton singleton;
    private Snacks chickenStripe = new ChickenStripe();

    @BeforeEach
    public void runBefore(){
        snacks = new Snacks("Chicken Wings",18.99);
        singleton = new Singleton("Mike");
        SingletonHolder singletonHolder = new SingletonHolder();
    }

    @Test
    void testConstructor() {
        assertEquals(snacks.getPrice(),18.99);
        assertEquals(snacks.getName(),"Chicken Wings");
    }

    @Test
    public void testPrintPrice1() {
        assertEquals("Price: $5.99",snacks.printPrice1());
    }

//    @Test
//    public void testPrintPrice2() {
//        assertEquals("Price: $8.99",snacks.printPrice2);
//    }

    @Test
    public void testPrintIngredient1() {
        assertEquals("Ingredient: High-quality Chicken Tenders, Salt, Plant Oil",
                snacks.printIngredient1());
        SingletonHolder.getInstance();
    }

//    @Test
//    public void testPrintIngredient2() {
//        assertEquals("Ingredient: Fresh Chicken Wings, Salt, Pepper",
//                "Ingredient: Fresh Chicken Wings, Salt, Pepper");
//    }

    @Test
    public void testPrintPopularity1() {
        assertEquals("Star: ***", snacks.printPopularity1());
    }

    @Test
    void testChickenStripeConstructor() {
        assertEquals(chickenStripe.getName(),"Chicken Stripe");
        assertEquals(chickenStripe.getPrice(),9.99);
    }

//    @Test
//    public void testPrintPopularity2() {
//        assertEquals("Star: *****", "Star: *****");
//    }

//    @Test
//    public void testPrintOrder() {
//        assertEquals("Star: ***", snacks.printOrder());
//    }
}
