package za.ac.cput.Controller;
/*
 * Author: GAYNOR JANTJIES 213069555
 * POJO StoreController.java
 *  Store Controller file to be implemented
 * Created: 21/08/2022
 * */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/store")
public class StoreController {

    @RequestMapping({"/home"})
    public String home() {
        System.out.println("Store Page");
        return "store";
    }
//    @RequestMapping({"/restaurant"})
//    public String restaurant() {
//        System.out.println("Restaurant Page");
//        return "restaurant";
//    }
//
//    @RequestMapping("/supermarket")
//    public String supermarket() {
//        System.out.println("Supermarket Page");
//        return "supermarket";
//    }
}

