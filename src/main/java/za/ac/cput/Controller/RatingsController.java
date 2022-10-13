package za.ac.cput.Controller;

import za.ac.cput.Entity.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Factory.RatingsFactory;
import za.ac.cput.Service.impl.RatingsService;

import java.util.Set;

@Controller
@RequestMapping("/Ratings")
public class RatingsController {
    @Autowired
    private RatingsService ratingsService;


    @PostMapping("/Create")
    public Ratings create(@RequestBody Ratings ratings) {
        Ratings ratings1 = RatingsFactory.createRatings(ratings.getRateID(), ratings.getOrderID(), ratings.getRateScale(), ratings.getRateReview());
        return ratingsService.create(ratings1);
    }

    @GetMapping("/read/{id}")
    public Ratings read(@PathVariable String id)
    {
        return ratingsService.read(id);
    }

    @PostMapping("/update")
    public Ratings update(@RequestBody Ratings ratings)
    {
        return ratingsService.update(ratings);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id)
    {
        return ratingsService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Ratings> getAll()
    {
        return ratingsService.getAll();
    }

}
