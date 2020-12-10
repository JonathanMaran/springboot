package fr.campusnumerique.locationvehicule;

import fr.campusnumerique.locationvehicule.model.Vehicule;
import fr.campusnumerique.locationvehicule.web.controller.VehiculeController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class LocationvehiculeApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testVehicules() {

		// ********** 1) Test pour vérifier si la méthode listeVehicules fonctionne (GET)
		String testListeVehicules = "[{\"id\":1,\"marque\":\"BMW\",\"modele\":\"SERIE 1\",\"color\":\"NOIR\",\"prix\":28000},{\"id\":2,\"marque\":\"MERCEDES\",\"modele\":\"AMG GT\",\"color\":\"NOIR\",\"prix\":125000},{\"id\":3,\"marque\":\"AUDI\",\"modele\":\"RS Q8\",\"color\":\"NOIR\",\"prix\":75000}]";
		String listeVehicules = this.restTemplate.getForObject("/Vehicules", String.class);
		assertEquals(listeVehicules, testListeVehicules);

		// ********** 2) Test pour vérifier si la méthode ajouterVehicule fonctionne (POST)
		String testAjouterVehicule ="[{\"id\":1,\"marque\":\"BMW\",\"modele\":\"SERIE 1\",\"color\":\"NOIR\",\"prix\":28000},{\"id\":2,\"marque\":\"MERCEDES\",\"modele\":\"AMG GT\",\"color\":\"NOIR\",\"prix\":125000},{\"id\":3,\"marque\":\"AUDI\",\"modele\":\"RS Q8\",\"color\":\"NOIR\",\"prix\":75000},{\"id\":9,\"marque\":\"FORD\",\"modele\":\"KUGA\",\"color\":\"NOIR\",\"prix\":22000}]";
		Vehicule nouveauVehicule = new Vehicule(9, "FORD", "KUGA", "NOIR", 22000);
		this.restTemplate.postForObject("/Vehicules", nouveauVehicule, String.class);
		String ajouterVehicule = this.restTemplate.getForObject("/Vehicules", String.class);
		assertEquals(ajouterVehicule, testAjouterVehicule);

		// ********** 3) Test pour vérifier si la méthode afficherUnVehicule fonctionne (GET)
		String testAfficherVehicule ="{\"id\":1,\"marque\":\"BMW\",\"modele\":\"SERIE 1\",\"color\":\"NOIR\",\"prix\":28000}";
		String afficherUnVehicule = this.restTemplate.getForObject("/Vehicules/1", String.class);
		assertEquals(afficherUnVehicule, testAfficherVehicule);

		// ********** 4) Test pour vérifier si la méthode modifierVehicule fonctionne (PUT)
		String testModifierVehicule ="[{\"id\":1,\"marque\":\"BMW\",\"modele\":\"SERIE 1\",\"color\":\"NOIR\",\"prix\":28000},{\"id\":2,\"marque\":\"MERCEDES\",\"modele\":\"AMG GT\",\"color\":\"NOIR\",\"prix\":125000},{\"id\":3,\"marque\":\"AUDI\",\"modele\":\"RS Q8\",\"color\":\"NOIR\",\"prix\":75000},{\"id\":66,\"marque\":\"Ford\",\"modele\":\"Fiesta\",\"color\":\"Jaune\",\"prix\":6000}]";
		Vehicule modificationVehicule = new Vehicule(66, "Ford", "Fiesta", "Jaune", 6000);
		this.restTemplate.put("/Vehicules/9", modificationVehicule , String.class);
		String modifierVehicule = this.restTemplate.getForObject("/Vehicules", String.class);
		assertEquals(modifierVehicule, testModifierVehicule);

		// ********** 5) Test pour vérifier si la méthode supprimerVehicule fonctionne (DELETE)
		String testSupprimerVehicule ="[{\"id\":1,\"marque\":\"BMW\",\"modele\":\"SERIE 1\",\"color\":\"NOIR\",\"prix\":28000},{\"id\":2,\"marque\":\"MERCEDES\",\"modele\":\"AMG GT\",\"color\":\"NOIR\",\"prix\":125000},{\"id\":3,\"marque\":\"AUDI\",\"modele\":\"RS Q8\",\"color\":\"NOIR\",\"prix\":75000}]";
		this.restTemplate.delete("/Vehicules/66", String.class);
		String supprimerVehicule = this.restTemplate.getForObject("/Vehicules", String.class);
		assertEquals(supprimerVehicule, testSupprimerVehicule);
	}
}