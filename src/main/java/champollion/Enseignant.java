package champollion;

import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Enseignant extends Personne {

    List<ServicePrevu> listeServP = new ArrayList<>();
    List<Intervention> interventions = new LinkedList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    public void ajouteIntervention(Intervention e) {
        interventions.add(e);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures
     * équivalent TD" Pour le calcul : 1 heure de cours magistral vaut 1,5 h
     * "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut
     * 0,75h "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {

        int equivalentTD = 0;

        for (ServicePrevu service : listeServP) {
            //il faut tout convertir en heures TD
            equivalentTD += 1.5 * service.getVolumeCM();
            equivalentTD += service.getVolumeTD();
            equivalentTD += 0.75 * service.getVolumeTP();

            round(equivalentTD);
        }

        return equivalentTD;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE
     * spécifiée en "heures équivalent TD" Pour le calcul : 1 heure de cours
     * magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent
     * TD" 1 heure de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int equivalentTD = 0;

        for (ServicePrevu service : listeServP) {
            //Si le l'UE est celle de l'enseignant 
            if (service.getUe() == ue) {
                //il faut tout convertir en heures TD
                equivalentTD += 1.5 * service.getVolumeCM();
                equivalentTD += service.getVolumeTD();
                equivalentTD += 0.75 * service.getVolumeTP();

                round(equivalentTD);
            }
        }

        return equivalentTD;
    }

    public int heuresPlanifiées() {
        int heuresPlanif = 0;

        for (int i = 0; i < interventions.size(); i++) {
            switch (interventions.get(i).getType()) {
                case CM:
                    heuresPlanif += interventions.get(i).getDuree() * 1.5;
                    break;
                case TD:
                    heuresPlanif += interventions.get(i).getDuree();
                    break;
                case TP:
                    heuresPlanif += interventions.get(i).getDuree() * 0.75;
                    break;
                default:
                    break;

            }
        }
        return round(heuresPlanif);
    }

    public boolean enSousService() {
        if (this.heuresPrevues() >= 192) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {

        ServicePrevu e = new ServicePrevu(this, ue, volumeCM, volumeTD, volumeTP);
        listeServP.add(e);

    }

}
