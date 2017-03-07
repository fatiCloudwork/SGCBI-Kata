package kata.core;

import kata.core.Kebbab;
import kata.core.SellerApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by elamraoui.f on 07/03/2017.
 */
@RestController
public class KebbabController {

    @RequestMapping("/")
    String home() {
        return "Welcome to Kebbab page!";
    }

    @RequestMapping("/{id}")
    public String getKebbabById(@PathVariable int id) {

        List<Kebbab> kebbabs =  SellerApplication.getKebbabsList();
        for(Kebbab k : kebbabs){
            if(k.getId()== id){
                return k.toString();
            }
        }
        return "Pas de kebbab correspondant à cet id";
    }

    @RequestMapping("/{id}/is_vegetarian")
    public String getTypeKebbab(@PathVariable int id) {

        List<Kebbab> kebbabs =  SellerApplication.getKebbabsList();
        for(Kebbab k : kebbabs){
            if(k.getId()== id){
                return k.isVegetarian()? "Je suis végetarien" : "Je ne suis pas végetarien";
            }
        }
        return "Pas de kebbab correspondant à cet id";
    }

    @RequestMapping("/{id}/is_double_cheese")
    public String getDoubleCheeseStatus(@PathVariable int id) {

        List<Kebbab> kebbabs =  SellerApplication.getKebbabsList();
        for(Kebbab k : kebbabs){
            if(k.getId()== id){
                return k.isWithDoubleCheese()? "Option double cheese : yes" : "Option double cheese : no";
            }
        }
        return "Pas de kebbab correspondant à cet id";
    }

    //autre requete récupérer tous les id / nom des kebbabs non végétarien


}
