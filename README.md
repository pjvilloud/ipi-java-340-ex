# ipi-java-340-ex [![Build Status](https://travis-ci.org/dylanben/ipi-java-340-ex.svg?branch=master)](https://travis-ci.org/dylanben/ipi-java-340-ex) [![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.ipi.java.340%3Amaster%3Amaster&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.ipi.java.340%3Amaster%3Amaster) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.ipi.java.340%3Amaster%3Amaster&metric=coverage)](https://sonarcloud.io/dashboard?id=com.ipi.java.340%3Amaster%3Amaster) [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=com.ipi.java.340%3Amaster%3Amaster&metric=bugs)](https://sonarcloud.io/dashboard?id=com.ipi.java.340%3Amaster%3Amaster) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=com.ipi.java.340%3Amaster%3Amaster&metric=code_smells)](https://sonarcloud.io/dashboard?id=com.ipi.java.340%3Amaster%3Amaster) [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=com.ipi.java.340%3Amaster%3Amaster&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=com.ipi.java.340%3Amaster%3Amaster)
 Exercices de Java, module 340 pour l'IPI. Il est nécessaire de forker ce repository pour pouvoir faire tout le TP !! Après chaque question, pusher vos modifications sur votre repository.

- Intégration continue

   - Rajouter la configuration nécessaire pour Travis dans le projet.
   - Vous connecter à Travis https://travis-ci.org avec votre compte Github.
   - Configurer le projet et vérifier que le premier build se passe correctement. Après chaque exercice, vérifier que le build passe toujours...
 
- Evaluation de la qualité
   - Connectez-vous à SonarQube https://about.sonarcloud.io/ avec votre compte Github
   - Ajouter votre projet dans Sonar
   - Modifier votre configuration Travis pour lancer une analyse après chaque build
   - Vérifier que tout est ok
   - Analyser le premier rapport de Sonar

- Tests unitaires
   - Créer la classe `CommercialTest` dans le bon package pour tester quelques méthodes de la classe `Commercial`.
   - Tester le plus complètement possible la méthode permettant de récupérer la prime annuelle
   - Créer la classe `CommercialParameterizedTest` dans le même package et tester complètement et de manière paramétrée la méthode `equivalenceNote`.
   - Ajouter le fichier `application.properties` de test pour utiliser une base de données mémoire H2
   - Créer la classe `EmployeRepositoryTest` et tester la méthode `findByNomOrPrenomAllIgnoreCase` le plus complètement possible.
   - Ajouter une méthode `before` supprimant le contenu des tables manipulées dans les tests.
   - Créer la classe `EmployeServiceTest` et tester la méthode `findByMatricule` en mockant l'utilisation de la base de données.
   - Créer la classe `TechnicienServiceTest` et tester la méthode `addManager` en vérifiant les paramètres passés aux méthodes save des repository pour s'assurer que le manager a été ajouté au technicien et inversement.
- Tests d'intégration
   - Créer la classe `ManagerServiceTest` et tester de manière intégrée la méthode `addTechniciens`

- Tests d'acceptation
   - A faire ensemble...
