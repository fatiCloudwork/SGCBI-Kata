package kata.core;

/**
 * Created by elamraoui.f on 01/03/2017.
 */
public class KebbabFactory {

    public static Kebbab makeVegetarianKebbab(IngredientsMenu menu){
        Kebbab vegeKebbab = new Kebbab("Le végétarien");

        Ingredient roquette = new Ingredient("roquette", IngredientTypeEnum.VEGETABLE);
        vegeKebbab.addIngredient(roquette,menu.getPositionIngredient("roquette"),true);

        Ingredient fromageChevre = new Ingredient("fromage chèvre", IngredientTypeEnum.CHEESE);
        vegeKebbab.addIngredient(fromageChevre,menu.getPositionIngredient("fromage chèvre"),true);

        Ingredient tomate = new Ingredient("tomate", IngredientTypeEnum.VEGETABLE);
        vegeKebbab.addIngredient(tomate,menu.getPositionIngredient("tomate"),true);

        return vegeKebbab;
    }

    public static Kebbab makePescetarienKebbab(IngredientsMenu menu){
        Kebbab pescKebbab = new Kebbab("Le Pescetarien");

        Ingredient laitue = new Ingredient("laitue", IngredientTypeEnum.VEGETABLE);
        pescKebbab.addIngredient(laitue,menu.getPositionIngredient("laitue"),true);

        Ingredient fromageChevre = new Ingredient("fromage chèvre", IngredientTypeEnum.CHEESE);
        pescKebbab.addIngredient(fromageChevre,menu.getPositionIngredient("fromage chèvre"),true);

        Ingredient mietteCrabe = new Ingredient("miette de crabe", IngredientTypeEnum.SEAFOOD);
        pescKebbab.addIngredient(mietteCrabe,menu.getPositionIngredient("miette de crabe"),true);

        return pescKebbab;
    }

    public static Kebbab makeClassicKebbab(IngredientsMenu menu){
        Kebbab classicKebbab = new Kebbab("The classic");

        Ingredient laitue = new Ingredient("laitue", IngredientTypeEnum.VEGETABLE);
        classicKebbab.addIngredient(laitue,menu.getPositionIngredient("laitue"),true);

        Ingredient tomate = new Ingredient("tomate", IngredientTypeEnum.VEGETABLE);
        classicKebbab.addIngredient(tomate,menu.getPositionIngredient("tomate"),true);

        Ingredient boeuf = new Ingredient("boeuf", IngredientTypeEnum.MEAT);
        classicKebbab.addIngredient(boeuf,menu.getPositionIngredient("boeuf"),true);

        Ingredient oignons = new Ingredient("oignons", IngredientTypeEnum.VEGETABLE);
        classicKebbab.addIngredient(oignons,menu.getPositionIngredient("oignons"),true);

        Ingredient cheddar = new Ingredient("cheddar", IngredientTypeEnum.CHEESE);
        classicKebbab.addIngredient(cheddar,menu.getPositionIngredient("cheddar"),true);

        return classicKebbab;
    }

    public static Kebbab makeDoubleCheeseKebbab(IngredientsMenu menu){
        Kebbab doubleCheeseKebbab = new Kebbab("Big double cheeeese !!");

        Ingredient laitue = new Ingredient("laitue", IngredientTypeEnum.VEGETABLE);
        doubleCheeseKebbab.addIngredient(laitue,menu.getPositionIngredient("laitue"),true);

        Ingredient tomate = new Ingredient("tomate", IngredientTypeEnum.VEGETABLE);
        doubleCheeseKebbab.addIngredient(tomate,menu.getPositionIngredient("tomate"),true);

        Ingredient boeuf = new Ingredient("boeuf", IngredientTypeEnum.MEAT);
        doubleCheeseKebbab.addIngredient(boeuf,menu.getPositionIngredient("boeuf"),true);

        Ingredient cheddar = new Ingredient("cheddar", IngredientTypeEnum.CHEESE);
        doubleCheeseKebbab.addIngredient(cheddar,menu.getPositionIngredient("cheddar"),true);
        doubleCheeseKebbab.doubleCheese(menu.getPositionIngredient("cheddar"),true);

        return doubleCheeseKebbab;

    }

    public static Kebbab makeOignonLessKebbab(IngredientsMenu menu){
        Kebbab oigonLessKebbab = new Kebbab("Le sans oigons");

        Ingredient laitue = new Ingredient("laitue", IngredientTypeEnum.VEGETABLE);
        oigonLessKebbab.addIngredient(laitue,menu.getPositionIngredient("laitue"),true);

        Ingredient tomate = new Ingredient("tomate", IngredientTypeEnum.VEGETABLE);
        oigonLessKebbab.addIngredient(tomate,menu.getPositionIngredient("tomate"),true);

        Ingredient boeuf = new Ingredient("boeuf", IngredientTypeEnum.MEAT);
        oigonLessKebbab.addIngredient(boeuf,menu.getPositionIngredient("boeuf"),true);

        Ingredient oignons = new Ingredient("oignons", IngredientTypeEnum.VEGETABLE);
        oigonLessKebbab.addIngredient(oignons,menu.getPositionIngredient("oignons"),true);

        Ingredient cheddar = new Ingredient("cheddar", IngredientTypeEnum.CHEESE);
        oigonLessKebbab.addIngredient(cheddar,menu.getPositionIngredient("cheddar"),true);
        oigonLessKebbab.removeOignon(menu.getPositionIngredient("oignons"));

        return oigonLessKebbab;
    }
}
