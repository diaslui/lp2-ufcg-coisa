package lab2;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Representa uma disciplina e o acompanhamento de suas horas de estudo e
 * notas.
 */
public class Disciplina {

    /** Nome da disciplina. */
    private String nomeDisciplina;

    /** Quantidade acumulada de horas de estudo. */
    private int horasEstudo;

    /** Notas das quatro avaliacoes da disciplina. */
    private double[] notas;

    /**
     * Constroi uma disciplina sem horas de estudo e sem notas cadastradas.
     *
     * @param nomeDisciplina nome da disciplina
     */
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        notas = new double[4];
    }

    /**
     * Adiciona horas de estudo ao total da disciplina.
     *
     * @param horas quantidade de horas a adicionar
     */
    public void cadastraHoras(int horas){
        this.horasEstudo += horas;
    }

    /**
     * Cadastra ou substitui uma nota de avaliacao.
     *
     * @param nota numero da avaliacao, entre 1 e 4
     * @param valorNota valor obtido na avaliacao
     */
    public void cadastraNota(int nota, double valorNota){
        if (nota < 1 || nota > 4) return;
        this.notas[nota-1] = valorNota;
    }

    /**
     * Calcula a media aritmetica das quatro notas.
     *
     * @return media das notas cadastradas
     */
    private double calculaMedia(){
        double total = 0.0;
        for (int i=0; i < 4; i++){
            total += notas[i];
        }
        return total/4;
    }

    /**
     * Verifica se a media da disciplina e suficiente para aprovacao.
     *
     * @return {@code true} quando a media e maior ou igual a 7.0
     */
    public boolean aprovado(){
        return this.calculaMedia() >= 7.0;
    }

    /**
     * Retorna a representacao textual da disciplina.
     *
     * @return nome, horas de estudo, media e notas da disciplina
     */
    @Override
    public String toString(){
        return nomeDisciplina + " " +  this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }

}
