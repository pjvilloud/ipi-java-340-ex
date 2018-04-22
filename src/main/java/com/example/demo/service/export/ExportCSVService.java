package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;


@Service
public class ExportCSVService {

    public void export(Writer printWriter, List<ClientDTO> clients) throws IOException {
        printWriter.write("Nom;Prénom\n");
        for (int i = 0; i < clients.size(); i++) {
            printWriter.write(replace((clients.get(i).getNom())));
            printWriter.write(";");
            printWriter.write(replace((clients.get(i).getPrenom())));
            printWriter.write("\n");
        }
    }
    public String replace( String value){
        value = value.replace("\"","\"\"");
        if(value.contains(";")){
            value= "\""+value+"\"";
        }
        return value;
    }
}
