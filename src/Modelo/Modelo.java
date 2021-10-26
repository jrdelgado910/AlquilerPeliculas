
package Modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Modelo {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiaPres() {
        return diaPres;
    }

    public void setDiaPres(String diaPres) {
        this.diaPres = diaPres;
    }

    public String getDiaEntre() {
        return diaEntre;
    }

    public void setDiaEntre(String diaEntre) {
        this.diaEntre = diaEntre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Modelo(String nombre, String director, String genero, String diaPres, String diaEntre, int valor) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.diaPres = diaPres;
        this.diaEntre = diaEntre;
        this.valor = valor;
    }

    public Modelo() {
    }
    
    public void guardarPeliculas(Modelo modelo){
        try {
            FileWriter doc = new FileWriter("Peliculas.txt",true);
            BufferedWriter bw = new BufferedWriter(doc);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(modelo.getNombre());
            pw.print(" - "+modelo.getDirector());
            pw.print(" - "+modelo.getGenero());
            pw.print(" - "+modelo.getDiaPres());
            pw.print(" - "+modelo.getDiaEntre());
            pw.print(" - "+modelo.getValor()+"\n");
            pw.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    private String nombre;
    private String director;
    private String genero;
    private String diaPres;
    private String diaEntre;
    private int valor;
    
}
