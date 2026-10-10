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

    /** Notas das quatro avaliacoes da disciplina. */
    private int[] pesosNotas;

    /**
     * Constroi uma disciplina sem horas de estudo e sem notas cadastradas (com 4 notas por padrao);.
     *
     * @param nomeDisciplina nome da disciplina
     */
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        notas = new double[4];
        this.pesosNotas = new int[4];
        Arrays.fill(this.pesosNotas, 1);
    }

    /**
     * Constroi uma disciplina sem horas de estudo e sem notas cadastradas e com quantidade de notas.
     *
     *  @param nomeDisciplina nome da disciplina
     *  @param quantidadeNotas quantidade de notas da disciplina
     */

    public Disciplina(String nomeDisciplina, int quantidadeNotas){
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[quantidadeNotas];
        this.pesosNotas = new int[quantidadeNotas];
        Arrays.fill(this.pesosNotas, 1);
    }

    /**
     * Constroi uma disciplina sem horas de estudo e sem notas cadastradas, com quantidade de notas e recebendo um array de pesos
     * com o peso para cada uma das notas em uma média ponderada
     *
     *  @param nomeDisciplina nome da disciplina
     *  @param quantidadeNotas quantidade de notas da disciplina
     * @param pesos peso da nota de cada disciplina
     */

    public Disciplina(String nomeDisciplina, int quantidadeNotas, int[] pesos){
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[quantidadeNotas];
        this.pesosNotas = pesos;
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
        if (nota < 1 || nota > this.notas.length) return;
        this.notas[nota-1] = valorNota;
    }

    /**
     * Retorna a soma de todos os pesos, util internamente para classe em caso de calcular média ou outras features.
     *
     * @return soma dos pesos
     */
    private int getSomaPesos() {
        int soma = 0;
        for (int i = 0; i < this.pesosNotas.length; i++) {
            soma += this.pesosNotas[i];
        }
        return soma;
    }

    /**
     * Calcula a media aritmetica das quatro notas.
     *
     * @return media das notas cadastradas
     */
    private double calculaMedia(){
        double total = 0.0;
        for (int i=0; i < this.notas.length; i++){
            total += (this.pesosNotas[i] * notas[i]);
        }
        return total/getSomaPesos();
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
