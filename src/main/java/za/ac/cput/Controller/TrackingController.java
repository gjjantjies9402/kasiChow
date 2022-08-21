package za.ac.cput.Controller;

import za.ac.cput.Entity.Tracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Factory.TrackingFactory;
import za.ac.cput.Service.impl.TrackingService;

import java.util.Set;

@Controller
@RequestMapping("/Tracking")
public class TrackingController {
    @Autowired
    private TrackingService trackingService;


    @PostMapping("/Create")
    @ResponseBody
    public Tracking create(@RequestBody Tracking tracking) {
        Tracking tracking1 = TrackingFactory.createTracking(tracking.getOrderNr(), tracking.getTrackETA(),tracking.isTrackStatus());
        return trackingService.create(tracking1);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Tracking read(@PathVariable String id)
    {
        return trackingService.read(id);
    }

    @PostMapping("/update")
    public Tracking update(@RequestBody Tracking tracking)
    {
        return trackingService.update(tracking);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id)
    {
        return trackingService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Tracking> getAll()
    {
        return trackingService.getAll();
    }

}
