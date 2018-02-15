package com.ipiecoles.java.java340.model;

//Pour afficher dans le fichier "source"(dans ce cas manager.java) les cas traités par les tests : clic droit,coverage As, JUnit test.
import org.assertj.core.api.Assertions; //Biblio d'assertions mieux que junit donc à mettre aussi
import org.junit.Test;

public class ManagerTest
{
	
	@Test
	//Les test sont tjs en class void
	public void testSetSalaire()
	{
		//TEST : voir si le salaire en sortie est sup au salaire en entrée
		//
		//Given
		Manager manager = new Manager();
		manager.setSalaire(1600d);
		
		//When
		//Double salaireEntree = manager.getSalaire();
		Double salaireSortie = manager.getSalaire();
		//Then
	//	Assertions.assertThat(salaireSortie).isGreaterThan(manager.getSalaire());
	}
	
	public class SetSalaireTest {

		  @Test //dans org.junit.Test
		  public void testSetSalaireSup(){
		      //Given = Initialisation des données d'entrée
			  Manager manager = new Manager();
		      Double salaireSortie;

		      //When = Exécution de la méthode à tester
		       
		    		   manager.setSalaire(1600d);
		    		   salaireSortie =manager.getSalaire();
		      //Then = Vérifications de ce qu'a fait la méthode
		      Assertions.assertThat(salaireSortie).isGreaterThan(1600d);
		}
	}
}
	
	
	/*public void setSalaire(Double salaire) {
		super.setSalaire(salaire * Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size() / 10));
	}*/
	
	
	/*@Test
	//Les test sont tjs en class void
	//On test le cas où l'augmentation est nulle
	public void testAugmenterSalaireNull()
	{
		//Given
		Manager manager = new Manager();
		manager.setSalaire((double) 1600);
		
		//When
		//no suitable method found for augmenterSalaire(no arguments)
		 Double augmentation = manager.augmenterSalaire();
		// Pbl car obliger de rajouter une nouvelle methode augmenterSalaire() dans Manager.java
		//Then
		Assertions.assertThat(augmentation).isEqualTo(1600d);
	}
	
	@Test
	public void testSetSalaire() {
		
	}*/
	