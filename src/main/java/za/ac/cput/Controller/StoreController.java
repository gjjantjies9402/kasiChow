package za.ac.cput.Controller;
/*
 * Author: GAYNOR JANTJIES 213069555
 * POJO StoreController.java
 *  Store Controller file to be implemented
 * Created: 21/08/2022
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Store;
import za.ac.cput.Service.Interface.StoreService;

import java.util.Set;


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

