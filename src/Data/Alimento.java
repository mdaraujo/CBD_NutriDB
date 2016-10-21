/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Miguel
 */
public class Alimento {

    private int ID;
    private String nome;
    private float humidade;
    private int energia;
    private float proteina;
    private float lipidos;
    private int colestrol;
    private float hidratos;
    private float fibra;

    public Alimento(int ID, String nome, float humidade, int energia, float proteina, float lipidos, int colestrol, float hidratos, float fibra) {
        this.ID = ID;
        this.nome = nome;
        this.humidade = humidade;
        this.energia = energia;
        this.proteina = proteina;
        this.lipidos = lipidos;
        this.colestrol = colestrol;
        this.hidratos = hidratos;
        this.fibra = fibra;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-70s %-8.2f %-6d %-8.2f %-7.2f %-9d %-8.2f %-7.2f", ID, nome, humidade, energia, proteina, lipidos, colestrol, hidratos, fibra);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getHumidade() {
        return humidade;
    }

    public void setHumidade(float humidade) {
        this.humidade = humidade;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public float getProteina() {
        return proteina;
    }

    public void setProteina(float proteina) {
        this.proteina = proteina;
    }

    public float getLipidos() {
        return lipidos;
    }

    public void setLipidos(float lipidos) {
        this.lipidos = lipidos;
    }

    public int getColestrol() {
        return colestrol;
    }

    public void setColestrol(int colestrol) {
        this.colestrol = colestrol;
    }

    public float getHidratos() {
        return hidratos;
    }

    public void setHidratos(float hidratos) {
        this.hidratos = hidratos;
    }

    public float getFibra() {
        return fibra;
    }

    public void setFibra(float fibra) {
        this.fibra = fibra;
    }

}
