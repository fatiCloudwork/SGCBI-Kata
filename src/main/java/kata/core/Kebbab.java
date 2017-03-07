package kata.core;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by elamraoui.f on 28/02/2017.
 */
public class Kebbab {

    private String name;
    private int id;
    private Map<Integer, Ingredient> ingredients ;
    private boolean withoutOignon;
    private boolean withDoubleCheese;

    public Kebbab(String name, int id) {
        this.name=name;
        this.id = id;
        //liste des ingrédients dans l'ordre (tree map pour trier)
        this.ingredients = new TreeMap<Integer, Ingredient>();
        withoutOignon=true;
        withDoubleCheese=false;
    }

    /**
     * ajouter un ingredient dans le kebbab
     */
    public void addIngredient(Ingredient ing, int pos, boolean inStock){

        //la gestion de stock doit être gérée indépendemment du kebbab dans un autre module :
        // ici c'est le vendeur qui décide si l'ingrédient est en stock
        ing.setInStock(inStock);
        if(inStock){
            ing.setPosition(pos);
            ingredients.put(pos, ing);
            //mettre à jour le stock de l'ingrédient (fonctionnalité non demandée)
        }
        if (ing.getName().equals("oignons")) {
            withoutOignon = false;
        }
    }

    public boolean isVegetarian(){
        boolean result = true ;

        for (Map.Entry<Integer, Ingredient> entry : ingredients.entrySet()){
            if (entry.getValue().isAllMeat()){
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isPescetarian(){
        boolean result = true ;

        for (Map.Entry<Integer, Ingredient> entry : ingredients.entrySet()){
            if (entry.getValue().isMeatNotSEAFOOD()){
                result = false;
                break;
            }
        }
        return result;
    }

    public void doubleCheese(int pos, boolean inStock){
        if (inStock){
            Ingredient cheese = ingredients.get(pos);
            cheese.inscreaseQuantity(2);
            withDoubleCheese=true;
        }

        updateKebbab();
    }

    public void removeOignon(int pos){
        Ingredient oigon = ingredients.get(pos);
        oigon.remove();
        withoutOignon=true;
        updateKebbab();
    }

    public String toString(){
        StringBuilder result = new StringBuilder() ;
        result.append(name+" : \n");
        for (Map.Entry<Integer, Ingredient> entry : ingredients.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue()!=null ? entry.getValue().getName(): " " ;
            result.append(key + " : " + value + "\n");
        }

        //ingredients.forEach((k,v)->result.append(k + " : " + v!= null ? v.getName() : " " + "\n"));

        String cheeseOption = withDoubleCheese==true? " yes, " : "no, ";
        String oignonOption = withoutOignon==true? " yes, " : "no, ";
        result.append("Option double fromage :"+ cheeseOption);
        result.append("Option sans oignon : "+ oignonOption + "\n \n");


        return result.toString();
    }

    public void updateKebbab() {
        List<Integer> ingredientsToRemove = new ArrayList<>();
        //si un ingrédient est à 0 quantité le supprimer
        for (Map.Entry<Integer, Ingredient> entry : ingredients.entrySet()) {
            Ingredient ingredientValue = entry.getValue();
            Integer ingredientKey = entry.getKey();
            if (ingredientValue.getQuantity() == 0) {
                ingredientsToRemove.add(ingredientKey);
            }
        }
        for(int key : ingredientsToRemove){
            ingredients.remove(key);
        }
    }

    public boolean containsIngredient(String ingredientName){
        List<String> ingredientsNames = ingredients.values().stream().map(s -> s.getName()).collect(Collectors.toList());
        return ingredientsNames.contains(ingredientName);
    }

    public int getId() {
        return id;
    }

    public Map<Integer, Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Integer, Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWithDoubleCheese() {
        return withDoubleCheese;
    }

    public void setWithDoubleCheese(boolean withDoubleCheese) {
        this.withDoubleCheese = withDoubleCheese;
    }

    public boolean isWithoutOignon() {
        return withoutOignon;
    }

    public void setWithoutOignon(boolean withoutOignon) {
        this.withoutOignon = withoutOignon;
    }
}
