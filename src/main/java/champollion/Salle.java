/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

/**
 *
 * @author cecil
 */
public class Salle {
    //Déclaration attributs 
    private String intitule ;
    private int capacite;
    
    //Constructeur 
    public Salle(String intitule, int capacite) {
        this.intitule = intitule;
        this.capacite = capacite; 
    }

    public String getIntitule() {
        return intitule;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
}
