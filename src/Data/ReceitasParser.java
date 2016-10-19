/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Miguel
 */
public class ReceitasParser {
    
    public void parserFicheiro(String ficheiro,Prato prato) {
        
        List<String> ingredientes = new ArrayList<>();
        List<String> quantidades = new ArrayList<>();
        
        try {
            Scanner sc = new Scanner(new File(ficheiro));

            while (sc.hasNext()) {
                String linha = sc.nextLine();
                String[] texto = linha.split(" ");

                int index = -1;
                a:
                for (int i = 0; i < texto.length; i++) {
                    if (isDivider(texto[i])) {
                        index = i;
                        break a;
                    }
                }

                StringBuilder alimento = new StringBuilder();
                StringBuilder quantidade = new StringBuilder();
                if (index == -1) {
                    for (int i = 0; i < texto.length; i++) {
                        alimento.append(texto[i] + " ");
                    }
                } else {
                    for (int i = 0; i < index; i++) {
                        alimento.append(texto[i] + " ");
                    }
                }
                if (index != -1) {
                    for (int i = index; i < texto.length; i++) {
                        quantidade.append(texto[i] + " ");
                    }
                } else {
                    quantidade.append("");
                }
                ingredientes.add(alimento.toString());
                quantidades.add(quantidade.toString());

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro não encontrado");
        }
        
        prato.setAlimentos(ingredientes);
        prato.setQuantidades(quantidades);
        
    }
    
    private boolean isDivider(String str) {
        if (isNumeric(str)) {
            return true;
        }
        if (str.equalsIgnoreCase("adicionar")) {
            return true;
        }
        if (str.equalsIgnoreCase("usar")) {
            return true;
        }
        if (str.equalsIgnoreCase("uma")) {
            return true;
        }
        if (str.equalsIgnoreCase("um")) {
            return true;
        }
        if (str.equalsIgnoreCase("algumas")) {
            return true;
        }
        if (str.equalsIgnoreCase("q.b.")) {
            return true;
        }

        return false;
    }

    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }
}
