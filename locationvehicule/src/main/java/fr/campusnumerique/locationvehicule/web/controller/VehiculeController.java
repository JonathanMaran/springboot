package fr.campusnumerique.locationvehicule.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fr.campusnumerique.locationvehicule.dao.VehiculeDao;
import fr.campusnumerique.locationvehicule.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiculeController {

    @Autowired
    private VehiculeDao vehiculeDao;

    @RequestMapping(value = "/Vehicules", method = RequestMethod.GET)
    public MappingJacksonValue listeVehicules() {

        Iterable<Vehicule> vehicules = vehiculeDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue vehiculesFiltres = new MappingJacksonValue(vehicules);

        vehiculesFiltres.setFilters(listDeNosFiltres);

        return vehiculesFiltres;
    }



    //Récupérer un vehicule par son Id
    @GetMapping(value = "/Vehicules/{id}")
    public Vehicule afficherUnVehicule(@PathVariable int id) {
        return vehiculeDao.findById(id);
    }

    @GetMapping(value = "test/produits/{prixLimit}")
    public List<Vehicule> testeDeRequetes(@PathVariable int prixLimit) {
        return vehiculeDao.findByPrixGreaterThan(prixLimit);
    }
//
//    //ajouter un vehicule
//    @PostMapping(value = "/Vehicules")
//    public void ajouterVehicule(@RequestBody Vehicule vehicule) {
//        vehiculeDao.save(vehicule);
//    }
//
//    //supprimer un vehicule
//    @DeleteMapping(value = "/Vehicules/{id}")
//    public void supprimerVehicule(@PathVariable int id) {
//        vehiculeDao.delete(id);
//    }
//
//    //modifier un vehicule
//    @PutMapping(value = "/Vehicules/{id}")
//    public void modifierVehicule(@PathVariable int id, @RequestBody Vehicule vehicule) { vehiculeDao.put(id, vehicule);}
}
