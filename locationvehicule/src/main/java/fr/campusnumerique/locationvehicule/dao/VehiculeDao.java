package fr.campusnumerique.locationvehicule.dao;

import fr.campusnumerique.locationvehicule.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VehiculeDao extends JpaRepository<Vehicule, Integer> {
    Vehicule findById(int id);
    List<Vehicule> findByPrixGreaterThan(int prixLimit);
    List<Vehicule> findByMarqueLike(String recherche);
}
