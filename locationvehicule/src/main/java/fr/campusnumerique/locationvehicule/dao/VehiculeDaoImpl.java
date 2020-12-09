package fr.campusnumerique.locationvehicule.dao;

import fr.campusnumerique.locationvehicule.model.Vehicule;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehiculeDaoImpl implements VehiculeDao {

    public static List<Vehicule> vehicules = new ArrayList<>();

    static {
        vehicules.add(new Vehicule(1, "BMW", "SERIE 1", "NOIR", 28000));
        vehicules.add(new Vehicule(2, "MERCEDES", "AMG GT", "NOIR", 125000));
        vehicules.add(new Vehicule(3, "AUDI", "RS Q8", "NOIR", 75000));
    }

    @Override
    public List<Vehicule> findAll() {
        return vehicules;
    }

    @Override
    public Vehicule findById(int id) {
        for(Vehicule vehicule: vehicules) {
            if(vehicule.getId() == id){
                return vehicule;
            }
        }
        return null;
    }

    @Override
    public Vehicule save(Vehicule vehicule) {
        vehicules.add(vehicule);
        return vehicule;
    }

    @Override
    public void delete(int id) {
        vehicules.remove(id-1);
    }

}
