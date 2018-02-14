Manager => setSalaire TEST (ou getprimeanuelle ou augmentersalaire)
		=> IDEM TESTS PARAMETRES

		=>findEmployePlusRiches a faire en spring avec BDD Memoire
		
		
		
		
SONARQUBE
	757ef58737087c726bb8c671e61825672a6806e9

	mvn sonar:sonar \
	-Dsonar.organization=remifoyard-github \
	-Dsonar.host.url=https://sonarcloud.io \
	-Dsonar.login=757ef58737087c726bb8c671e61825672a6806e9

=>MOCK ManagerService addTechnicien : 

	package com.ipiecoles.java.java340.service;

	import com.ipiecoles.java.java340.model.Manager;
	import com.ipiecoles.java.java340.model.Technicien;
	import com.ipiecoles.java.java340.repository.ManagerRepository;
	import com.ipiecoles.java.java340.repository.TechnicienRepository;
	import org.assertj.core.api.Assertions;
	import org.joda.time.LocalDate;
	import org.junit.Before;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;

	import java.util.Arrays;
	import java.util.HashSet;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class ManagerServiceTest {

		@Autowired
		public ManagerService managerService;

		@Autowired
		public TechnicienRepository technicienRepository;

		@Autowired
		public ManagerRepository managerRepository;

		@Before
		public void setUp(){
			technicienRepository.deleteAll();
			managerRepository.deleteAll();
		}

		@Test
		public void testAddTechniciens(){
			//Given
			Technicien technicien = new Technicien("Durand", "Jean", "T12345", new LocalDate(), 1500d, 3);
			technicien = technicienRepository.save(technicien);

			Manager manager = new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2500d, new HashSet<>());
			manager = managerRepository.save(manager);

			//When
			managerService.addTechniciens(manager.getId(), "T12345");

			//Then
			technicien = technicienRepository.findOne(technicien.getId());
			manager = managerRepository.findOneWithEquipeById(manager.getId());
			Assertions.assertThat(manager.getEquipe()).hasSize(1);
			Assertions.assertThat(manager.getEquipe().iterator().next()).isEqualTo(technicien);
			Assertions.assertThat(technicien.getManager()).isEqualTo(manager);
		}
	}