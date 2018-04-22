package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.entity.LigneFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class InitData {

    @Autowired
    private EntityManager em;

    public void insertTestData() {

        Client client  = new Client();
        client.setNom("PETRILLO");
        client.setPrenom("Alexandre");


        em.persist(client);

        Client client2 = new Client();
        client2.setNom("Lorenzo");
        client2.setPrenom("llopis");

        em.persist(client2);

        Client client3 = new Client();
        client3.setNom("Hen;ri");
        client3.setPrenom("Bern;ard");

        em.persist(client3);

        Article article = new Article();
        article.setLibelle("Carte mère ASROCK 2345");
        article.setPrix(79.90);
        em.persist(article);


        Article article12 = new Article();
        article12.setLibelle("Alimentation");
        article12.setPrix(100.1);
        em.persist(article12);


        Article article13 = new Article();
        article13.setLibelle("Carte graphique Nvidia2345");
        article13.setPrix(540.5);
        em.persist(article13);

        Article article2 = new Article();
        article2.setLibelle("RAM");
        article2.setPrix(26.90);
        em.persist(article2);

        Facture facture = new Facture();
        facture.setClient(client);
        em.persist(facture);

        Facture facture3 = new Facture();
        facture3.setClient(client2);
        em.persist(facture3);

        LigneFacture ligneFacture7 = new LigneFacture();
        ligneFacture7.setFacture(facture3);
        ligneFacture7.setArticle(article);
        em.persist(ligneFacture7);
        ligneFacture7.setQuantite(13);

        LigneFacture ligneFacture9 = new LigneFacture();
        ligneFacture9.setFacture(facture3);
        ligneFacture9.setArticle(article2);
        em.persist(ligneFacture9);
        ligneFacture9.setQuantite(49);


        LigneFacture ligneFacture1 = new LigneFacture();
        ligneFacture1.setFacture(facture);
        ligneFacture1.setArticle(article);
        em.persist(ligneFacture1);
        ligneFacture1.setQuantite(1);

        LigneFacture ligneFacture2 = new LigneFacture();
        ligneFacture2.setFacture(facture);
        ligneFacture2.setArticle(article2);
        em.persist(ligneFacture2);
        ligneFacture2.setQuantite(28);


        Facture facture2 = new Facture();
        facture2.setClient(client);
        em.persist(facture2);

        LigneFacture ligneFacture12 = new LigneFacture();
        ligneFacture12.setFacture(facture2);
        ligneFacture12.setArticle(article12);
        em.persist(ligneFacture12);
        ligneFacture12.setQuantite(15);

        LigneFacture ligneFacture13 = new LigneFacture();
        ligneFacture13.setFacture(facture2);
        ligneFacture13.setArticle(article13);
        em.persist(ligneFacture2);
        ligneFacture2.setQuantite(156);
    }
}
