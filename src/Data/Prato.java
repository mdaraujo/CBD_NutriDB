/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class Prato {
    
    private int ID;
    private String titulo;
    private List<String> ingredientes = new ArrayList<>();
    private List<String> quantidades = new ArrayList<>();
    private String descricao;
    private String imagem;

    public Prato(String titulo) {
        this.titulo = titulo;
    }
    
    public Prato(int ID, String titulo, String descricao)
    {
        this.ID = ID;
        this.titulo = titulo;
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public List<String> getQuantidades() {
        return ingredientes;
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        
        sb.append("Titulo: ");
        sb.append(titulo);
        sb.append("\n");
        
        return sb.toString();
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes=ingredientes;
    }

    public void setQuantidades(List<String> quantidades) {
        this.quantidades=quantidades;
    }
}
