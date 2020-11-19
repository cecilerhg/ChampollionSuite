/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author cecil
 */
public class Intervention {
    //attributs 
    private Date debut ;
    private int duree ;
    private boolean annulee = false ;
    private TypeIntervention type;
    private Enseignant e;
    private Salle s;
    private UE u;
    
    //Constructeur 
    public Intervention(Salle s, UE u, TypeIntervention type, Enseignant e, Date debut, int duree) {
        this.debut = debut;
        this.duree = duree;
        this.e = e;
        this.type = type;
        this.s = s;
        this.u = u;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }

    public Enseignant getE() {
        return e;
    }

    public void setE(Enseignant e) {
        this.e = e;
    }

    public Salle getS() {
        return s;
    }

    public void setS(Salle s) {
        this.s = s;
    }

    public UE getU() {
        return u;
    }

    public void setU(UE u) {
        this.u = u;
    }
   

   
    
    

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }
    
    
}
