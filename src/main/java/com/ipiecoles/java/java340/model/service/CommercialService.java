package com.ipiecoles.java.java340.model.service;

import com.ipiecoles.java.java340.model.model.Commercial;
import com.ipiecoles.java.java340.model.repository.CommercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommercialService {

    @Autowired
    private CommercialRepository commercialRepository;

    public Commercial findById(Long id){
        return commercialRepository.findOne(id);
    }

    public Commercial creerEmploye(Commercial e) {
        return commercialRepository.save(e);
    }

    public Commercial updateEmploye(Long id, Commercial employe) {
        return commercialRepository.save(employe);
    }


}
