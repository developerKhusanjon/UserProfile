package com.example.demo.controllers;

import com.example.demo.models.Location;
import com.example.demo.models.User;
import com.example.demo.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List<Location> getAllLocations(){
        return locationService.findAll();
    }

    @GetMapping("/locations/{id}")
    public Optional<Location> getLocationById(@PathVariable Integer id){
        return locationService.findById(id);
    }

    @GetMapping("/location/{id}/users")
    public List<User> getUsersByLocation(@PathVariable Integer id){
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()){
            Location newLocation = location.get();
            return newLocation.getUsers();
        }
        return null;
    }

    @PostMapping("/locations/addNew")
    public void AddLocation(@RequestBody Location location){
        locationService.AddLocation(location);
    }

    @PutMapping("/locations/{id}/update")
    public void UpdateLocation(@RequestBody Location location){
        locationService.updateLocation(location);
    }

    @DeleteMapping("/location/{id}/delete")
    public  void deleteLocation(@PathVariable Integer id){
        locationService.deleteLocation(id);
    }
}
