package fr.campusnumerique.locationvehicule.web.controller;

import fr.campusnumerique.locationvehicule.dao.VehiculeDao;
import fr.campusnumerique.locationvehicule.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiculeController {

    @Autowired
    private VehiculeDao vehiculeDao;

    @RequestMapping(value = "/Vehicules", method = RequestMethod.GET)
    public List<Vehicule> listeVehicules() {
        return vehiculeDao.findAll();
    }

    //Récupérer un produit par son Id
    @GetMapping(value = "/Vehicules/{id}")
    public Vehicule afficherUnVehicule(@PathVariable int id) {
        return vehiculeDao.findById(id);
    }

    //ajouter un produit
    @PostMapping(value = "/Vehicules")
    public void ajouterVehicule(@RequestBody Vehicule vehicule) {
        vehiculeDao.save(vehicule);
    }

    //supprimer un produit
    @DeleteMapping(value = "/Vehicules/{id}")
    public void supprimerVehicule(@PathVariable int id) {
        vehiculeDao.delete(id);
    }
}
