package kata.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by elamraoui.f on 28/02/2017.
 */
public class IngredientsMenu {

    private Map<String, Integer> menu;

    public IngredientsMenu() {
        initializeMenu();
    }

    private void initializeMenu(){
        menu =new HashMap<String, Integer>();

        menu.put("laitue",0);
        menu.put("roquette",1);
        menu.put("tomate",2);
        menu.put("agneau",3);
        menu.put("boeuf",4);
        menu.put("miette de crabe",5);
        menu.put("cheddar",6);
        menu.put("fromage chèvre",7);
        menu.put("oignons",8);

    }

    public void enrichMenu(String ing , int pos){
        menu.put(ing,pos);
    }

    public int getPositionIngredient(String ing){
        return menu.get(ing);
    }
}
