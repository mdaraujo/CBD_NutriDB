/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author Andreia Machado
 */
public class CreateDocumentXML {
    private String nome;
    private String conteudo;
    
    public CreateDocumentXML(String nome) {
        this.nome = nome;
        this.conteudo = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
    }
    
    public void createDocument(int id, String preparacao, String cozinha, String dificuldade, String tempo, String dose) throws IOException {
        putTagPrato("inicio");
        putTagID(id);
        putTagPreparacao(preparacao);
        putTagCozinha(cozinha);
        putTagDificuldade(dificuldade);
        putTagTempo(tempo);
        putTagDose(dose);
        putTagPrato("fim");
        createFile();
    }

    private void putTagPrato(String tag) {
        if (tag.equals("inicio"))
            conteudo +="<prato>\n";
        else
            conteudo +="</prato>\n"; 
    }

    private void putTagID(int id) {
        conteudo+="\t<id>"+id+"</id>\n";
    }

    private void putTagPreparacao(String preparacao) {
        conteudo+="\t<preparacao>"+preparacao+"</preparacao>\n";
    }

    private void putTagCozinha(String cozinha) {
        conteudo+="\t<Cozinha>"+cozinha+"</Cozinha>\n";
    }

    private void putTagDificuldade(String dificuldade) {
        conteudo+="\t<Dificuldade>"+dificuldade+"</Dificuldade>\n";
    }

    private void putTagTempo(String tempo) {
        conteudo+="\t<Tempo>"+tempo+"</Tempo>\n";
    }

    private void putTagDose(String dose) {
        conteudo+="\t<Doses>"+dose+"</Doses>\n";
    }  

    private void createFile() throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("res\\doc\\" + nome + ".xml"), "utf-8"))) {
            writer.write(conteudo);
        }
    }
    
}
