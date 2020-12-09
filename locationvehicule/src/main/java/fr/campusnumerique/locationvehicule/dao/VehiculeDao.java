package fr.campusnumerique.locationvehicule.dao;

import fr.campusnumerique.locationvehicule.model.Vehicule;

import java.util.List;

public interface VehiculeDao {

    public List<Vehicule> findAll();
    public Vehicule findById(int id);
    void save(Vehicule vehicule);
    void delete(int id);
    void put(int id, Vehicule nouveauVehicule);


}
