package com.ipiecoles.java.java340.model;

//Pour afficher dans le fichier "source"(dans ce cas manager.java) les cas traités par les tests : clic droit,coverage As, JUnit test.
import org.assertj.core.api.Assertions; //Biblio d'assertions mieux que junit donc à mettre aussi
import org.junit.Test;

public class ManagerTest
{
	@Test
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
}