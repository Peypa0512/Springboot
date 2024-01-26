package com.psr.controller;

import com.psr.models.Country;
import com.psr.repository.CountryReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class CountryController {

    @Autowired
    CountryReposity countryReposity;

    @GetMapping("/country")
    public @ResponseBody Iterable<Country> getAll(){
        return countryReposity.findAll();
    }

    @GetMapping("/country/{id}")
    public Country getById(@PathVariable int id){
        return countryReposity.findById(id).get();
    }

    @PostMapping("/country")
    public Country add(@RequestBody Country country){
        return countryReposity.save(country);
    }

    @PutMapping("/country/{id}")
    public Country update(@RequestBody Country country, @PathVariable int id){
        try{
            Country coun = countryReposity.findById(id).get();
            coun.setCountry(country.getCountry());
            return countryReposity.save(coun);

        }catch(Exception e){
            return new Country("Pais no encontrado");
        }
    }

    @DeleteMapping("/country/{id}")
    public void delete(@PathVariable int id){
        countryReposity.deleteById(id);
    }


}
