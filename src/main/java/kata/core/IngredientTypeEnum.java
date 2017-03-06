package kata.core;

/**
 * Created by elamraoui.f on 28/02/2017.
 */
public enum IngredientTypeEnum {

    VEGETABLE ("Vegetable", 0),
    MEAT ("Meat", 1),
    CHEESE ("Cheese",2),
    SEAFOOD ("SeaFood",3),
    OTHER ("Other",4);

    private String Label;
    private int id;



    IngredientTypeEnum(String Label, int id) {
        this.Label=Label;
        this.id=id;
    }


    public String getLabel(){
        return Label;
    }

    public int getId(){
        return id;
    }

}
