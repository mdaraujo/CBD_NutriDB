/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbd_nutribd;

import DB.LigacaoDB;
import Data.*;

/**
 *
 * @author Miguel
 */
public class InsertIngPratos {
    
    public static void main(String[] args) {
        
        String titulo = "Pizza";
        Prato prato = new Prato(titulo);
        
        //
        String ficheiro = "C:\\Users\\Miguel\\Documents\\NetBeansProjects\\CDB\\receita";

        ReceitasParser parser = new ReceitasParser();
        parser.parserFicheiro(ficheiro,prato);
        //
        
        System.out.println(prato);
        System.out.println("\nA estabelecer ligação");
        
        LigacaoDB ligacao = new LigacaoDB("NutriDB_Graphs","sa","qwer");
        ligacao.addPratoGrafosDB(prato);
    }

}
