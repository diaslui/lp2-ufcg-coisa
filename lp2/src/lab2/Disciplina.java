package lab2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;

    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        notas = new double[4];
    }

    public void cadastraHoras(int horas){
        this.horasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota){
        if (nota < 1 || nota > 4) return;
        this.notas[nota-1] = valorNota;
    }

    private double calculaMedia(){
        double total = 0.0;
        for (int i=0; i < 4; i++){
            total += notas[i];
        }
        return total/4;
    }

    public boolean aprovado(){
        return this.calculaMedia() >= 7.0;
    }

    @Override
    public String toString(){
        return nomeDisciplina + " " +  this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }

}
