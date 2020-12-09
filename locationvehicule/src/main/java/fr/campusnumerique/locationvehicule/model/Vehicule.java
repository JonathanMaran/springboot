package fr.campusnumerique.locationvehicule.model;

public class Vehicule {
    private int id;
    private String marque;
    private String modele;
    private String color;
    private int prix;

    public Vehicule(int id, String marque, String modele, String color, int prix) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.color = color;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getColor() {
        return color;
    }

    public int getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", color='" + color + '\'' +
                ", prix='" + prix + '}';
    }



}
