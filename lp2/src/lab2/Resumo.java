package lab2;

/**
 * Representa um resumo de estudo com tema e conteudo.
 * 
 * @author Pedro Luis da Silva Rocha Dias
 */
public class Resumo {

    /** Tema do resumo. */
    private String tema;

    /** Conteudo textual do resumo. */
    private String conteudo;

    /**
     * Constroi um resumo de estudo.
     *
     * @param tema     tema abordado no resumo
     * @param conteudo texto do resumo
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo.
     *
     * @return tema do resumo
     */
    public String getTema() {
        return this.tema;
    }

    /**
     *  Retorna se um texto faz parte do conteudo do resumo.
     *
     * @param conteudo o texto que deseja comparar com o conteudo do atual resumo
     *
     * @return boolean se faz parte ou nao
     */
    public boolean isSimilar(String conteudo){
        conteudo = conteudo.toLowerCase();
        return this.conteudo.toLowerCase().contains(conteudo);
    }

    /**
     * Retorna a representacao textual do resumo.
     *
     * @return tema seguido do conteudo
     */
    @Override
    public String toString() {
        return tema + ": " + conteudo;
    }

}
