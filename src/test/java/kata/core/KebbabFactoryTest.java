package kata.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by elamraoui.f on 01/03/2017.
 */
public class KebbabFactoryTest {

    private KebbabFactory kebbabFactory ;
    IngredientsMenu menu ;


    @Before
    public void setUp(){
        kebbabFactory = new KebbabFactory();
        menu = new IngredientsMenu();
    }

    @Test
    public void vegetarianKebbabTest(){

        Kebbab vegetarianKebbab = kebbabFactory.makeVegetarianKebbab(menu);

        Assert.assertTrue(vegetarianKebbab.isVegetarian());
        Assert.assertFalse(vegetarianKebbab.isWithDoubleCheese());
        Assert.assertTrue(vegetarianKebbab.isWithoutOignon());
        Assert.assertTrue(vegetarianKebbab.containsIngredient("roquette"));
        Assert.assertFalse(vegetarianKebbab.containsIngredient("laitue"));

    }

    @Test
    public void pescetarienKebbabTest(){

        Kebbab pescKebbab = kebbabFactory.makePescetarienKebbab(menu);

        Assert.assertFalse(pescKebbab.isVegetarian());
        Assert.assertTrue(pescKebbab.isPescetarian());
        Assert.assertFalse(pescKebbab.isWithDoubleCheese());
        Assert.assertTrue(pescKebbab.isWithoutOignon());
        Assert.assertTrue(pescKebbab.containsIngredient("miette de crabe"));
        Assert.assertFalse(pescKebbab.containsIngredient("oigons"));

    }

    @Test
    public void classicKebbabTest(){

        Kebbab classicKebbab = kebbabFactory.makeClassicKebbab(menu);

        Assert.assertFalse(classicKebbab.isVegetarian());
        Assert.assertFalse(classicKebbab.isPescetarian());
        Assert.assertFalse(classicKebbab.isWithDoubleCheese());
        Assert.assertFalse(classicKebbab.isWithoutOignon());
        Assert.assertTrue(classicKebbab.containsIngredient("boeuf"));
        Assert.assertTrue(classicKebbab.containsIngredient("oignons"));
        Assert.assertFalse(classicKebbab.containsIngredient("roquette"));

    }

    @Test
    public void doubleCheeseKebbabTest(){

        Kebbab doubleCheeseKebbab = kebbabFactory.makeDoubleCheeseKebbab(menu);

        Assert.assertFalse(doubleCheeseKebbab.isVegetarian());
        Assert.assertFalse(doubleCheeseKebbab.isPescetarian());
        Assert.assertTrue(doubleCheeseKebbab.isWithDoubleCheese());
        Assert.assertTrue(doubleCheeseKebbab.isWithoutOignon());
        Assert.assertTrue(doubleCheeseKebbab.containsIngredient("boeuf"));
        Assert.assertFalse(doubleCheeseKebbab.containsIngredient("oignons"));

    }


    @Test
    public void oigonLessKebbabTest(){

        Kebbab oignonLessKebbab = kebbabFactory.makeOignonLessKebbab(menu);

        Assert.assertFalse(oignonLessKebbab.isVegetarian());
        Assert.assertFalse(oignonLessKebbab.isPescetarian());
        Assert.assertFalse(oignonLessKebbab.isWithDoubleCheese());
        Assert.assertTrue(oignonLessKebbab.isWithoutOignon());
        Assert.assertTrue(oignonLessKebbab.containsIngredient("boeuf"));
        Assert.assertFalse(oignonLessKebbab.containsIngredient("oignons"));

    }

}
