package kata.core;

import kata.core.*;

import java.util.Scanner;

/**
 * Created by elamraoui.f on 28/02/2017.
 */
public class SellerMain {

    public static void main (String args[]){

        //exposer les ingrédients
        IngredientsMenu menu = new IngredientsMenu();
        KebbabFactory kebbabFactory = new KebbabFactory();
        //traiter une commande de kebabb

        //un kebbab végétarien : roquette fromage chèvre tomate
        Kebbab vegeKebbab = kebbabFactory.makeVegetarianKebbab(menu);
        System.out.println("Suis je végétarien ? : "+ vegeKebbab.isVegetarian());
        System.out.println(vegeKebbab.toString());

        //un kebbab pescétarien : laitue miette de crabe fromage chèvre
        Kebbab pescKebbab = kebbabFactory.makePescetarienKebbab(menu);
        System.out.println("Suis je pescétarien ? : "+ pescKebbab.isPescetarian());
        System.out.println(pescKebbab.toString());

        //un kebbab classique (complet) avec viande : laitue tomate boeuf oigons cheddar
        Kebbab classicKebbab = kebbabFactory.makeClassicKebbab(menu);
        System.out.println("Suis je végétarien ? : "+ classicKebbab.isVegetarian());
        System.out.println(classicKebbab.toString());

        //un kebbab avec double cheese : laitue tomate boeuf oigons double cheddar
        Kebbab doubleCheeseKebbab = kebbabFactory.makeDoubleCheeseKebbab(menu);
        System.out.println("Suis je végétarien ? : "+ doubleCheeseKebbab.isVegetarian());
        System.out.println(doubleCheeseKebbab.toString());

        //un kebbab sans oigons : laitue tomate boeuf cheddar
        Kebbab OigonLessKebbab = kebbabFactory.makeOignonLessKebbab(menu);
        System.out.println("Suis je végétarien ? : "+ OigonLessKebbab.isVegetarian());
        System.out.println(OigonLessKebbab.toString());


    }



    /**
     * commander en saisissant ses ingrédients
     */
    public void interactiveOrder(){

        boolean commandeEnCours = true ;
        while(commandeEnCours){
            Scanner sc = new Scanner(System.in);

            System.out.println("saisir le nom de votre Kebbab ");

            String kebbabName = sc.nextLine();

            Kebbab myKebbab = new Kebbab(kebbabName);

            System.out.println("saisir un ingrédient ");

            //sc.nextLine();
            String ingName = sc.nextLine();

            if(ingName.equals("fin")){
                commandeEnCours = false;
            }else{

                Ingredient ingredient = new Ingredient(ingName, IngredientTypeEnum.OTHER);
                myKebbab.addIngredient(ingredient,0,true);
            }
        }
    }

}
