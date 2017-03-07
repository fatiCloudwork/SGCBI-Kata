package kata.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by elamraoui.f on 28/02/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@Configuration
//@ComponentScan
public class SellerApplication {

    public static List<Kebbab> kebbabsList =new ArrayList<>();

    public static void main (String args[]){

        SpringApplication.run(SellerApplication.class,args);
        //exposer les ingrédients
        IngredientsMenu ingredientsMenu = new IngredientsMenu();
        KebbabFactory kebbabFactory = new KebbabFactory();
        //traiter une commande de kebabb

        //un kebbab végétarien : roquette fromage chèvre tomate
        Kebbab vegeKebbab = kebbabFactory.makeVegetarianKebbab(ingredientsMenu);
        System.out.println("Suis je végétarien ? : "+ vegeKebbab.isVegetarian());
        System.out.println(vegeKebbab.toString());
        kebbabsList.add(vegeKebbab);

        //un kebbab pescétarien : laitue miette de crabe fromage chèvre
        Kebbab pescKebbab = kebbabFactory.makePescetarienKebbab(ingredientsMenu);
        System.out.println("Suis je pescétarien ? : "+ pescKebbab.isPescetarian());
        System.out.println(pescKebbab.toString());
        kebbabsList.add(pescKebbab);

        //un kebbab classique (complet) avec viande : laitue tomate boeuf oigons cheddar
        Kebbab classicKebbab = kebbabFactory.makeClassicKebbab(ingredientsMenu);
        System.out.println("Suis je végétarien ? : "+ classicKebbab.isVegetarian());
        System.out.println(classicKebbab.toString());
        kebbabsList.add(classicKebbab);

        //un kebbab avec double cheese : laitue tomate boeuf oigons double cheddar
        Kebbab doubleCheeseKebbab = kebbabFactory.makeDoubleCheeseKebbab(ingredientsMenu);
        System.out.println("Suis je végétarien ? : "+ doubleCheeseKebbab.isVegetarian());
        System.out.println(doubleCheeseKebbab.toString());
        kebbabsList.add(doubleCheeseKebbab);

        //un kebbab sans oigons : laitue tomate boeuf cheddar
        Kebbab OigonLessKebbab = kebbabFactory.makeOignonLessKebbab(ingredientsMenu);
        System.out.println("Suis je végétarien ? : "+ OigonLessKebbab.isVegetarian());
        System.out.println(OigonLessKebbab.toString());
        kebbabsList.add(OigonLessKebbab);

    }

    public static List<Kebbab> getKebbabsList() {
        return kebbabsList;
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

            Kebbab myKebbab = new Kebbab(kebbabName, 1);

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
