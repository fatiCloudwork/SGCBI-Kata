package kata.core;

/**
 * Created by elamraoui.f on 28/02/2017.
 */
public class Ingredient {

    private String name;
    private IngredientTypeEnum type;
    private int quantity;
    private boolean inStock;
    private int position;

    public Ingredient(String name, IngredientTypeEnum type) {
        this.name = name;
        this.type = type;
        this.quantity=1;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientTypeEnum getType() {
        return type;
    }

    public void setType(IngredientTypeEnum type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return true si l'ingrédient est de la viande
     */
    public boolean isAllMeat(){
        return this.type.equals(IngredientTypeEnum.MEAT)|| this.type.equals(IngredientTypeEnum.FISH)? true : false ;
    }

    /**
     *
     * @return true si l'ingrédient est de la viande hors poisson
     */
    public boolean isMeatNotFish(){
        return this.type.equals(IngredientTypeEnum.MEAT)? true : false ;
    }

    /**
     *
     * @param i la quantité désirée de l'ingrédient
     */
    public void inscreaseQuantity(int i){
        quantity = i ;
    }

    public void remove(){
        quantity=0;
    }
}
