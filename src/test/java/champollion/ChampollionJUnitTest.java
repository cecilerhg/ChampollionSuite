package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test 
        public void testHeuresPrevues() {
            //Ajouter 1h TD, 1h TP, 1h CM dans les UE uml et java 
            untel.ajouteEnseignement(uml, 1, 1, 1);
            untel.ajouteEnseignement(java, 1, 1, 1);
            
            //On doit obtenir 4h en tout car ça arrondit en dessous
            assertEquals(4, untel.heuresPrevues(), "L'enseignant doit réaliser 4h");
        }
        
        @Test 
        public void testHeuresPlanifiees() {
            Salle s = new Salle("Salle 1", 40);
            Intervention e1 = new Intervention(s, uml, TypeIntervention.TD, untel, new Date(), 2 );
            Intervention e2 = new Intervention(s, uml, TypeIntervention.CM, untel, new Date(), 2 );
            Intervention e3 = new Intervention(s, uml, TypeIntervention.TP, untel, new Date(), 2 );
            //Ajouter les interventions
            untel.ajouteIntervention(e1);
            untel.ajouteIntervention(e2);
            untel.ajouteIntervention(e3);
            
            //On doit obtenir 6h en tout
            assertEquals(6, untel.heuresPlanifiées(), "L'enseignant doit réaliser 6h");
        }
        
        @Test 
        public void testEnSousService() {
            //Ajouter 1h TD, 1h TP, 1h CM dans les UE uml et java 
            untel.ajouteEnseignement(uml, 1, 1, 1);           
            //Doit retourner true heures équivalent TD < 192
            assertEquals(true, untel.enSousService(), "L'enseignant doit réaliser être en sous service");
            
            untel.ajouteEnseignement(uml, 140, 30, 70);
            assertEquals(false, untel.enSousService(), "L'enseignant ne doit pas etre en sous service ");
        }
	
}
