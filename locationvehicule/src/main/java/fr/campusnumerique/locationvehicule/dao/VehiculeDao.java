package fr.campusnumerique.locationvehicule.dao;

import fr.campusnumerique.locationvehicule.model.Vehicule;

import java.util.List;

public interface VehiculeDao {

    public List<Vehicule> findAll();
    public Vehicule findById(int id);
    public Vehicule save(Vehicule vehicule);
    void delete(int id);

}
