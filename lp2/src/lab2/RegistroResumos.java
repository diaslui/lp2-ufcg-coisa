package lab2;

/**
 * Mantem um conjunto limitado de resumos de estudo.
 * Quando o limite e atingido, novos resumos substituem os mais antigos em
 * ordem circular.
 * 
 * @author Pedro Luis da Silva Rocha Dias
 */
public class RegistroResumos {

    /** Resumos armazenados no registro. */
    private Resumo[] resumos;

    /** Quantidade atual de resumos armazenados. */
    private int numeroDeResumos;

    /** Indice do ultimo resumo inserido. */
    private int ultimoResumo;

    /**
     * Constroi um registro com capacidade limitada de armazenamento.
     *
     * @param numeroDeResumos quantidade maxima de resumos
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.numeroDeResumos = 0;
        this.ultimoResumo = -1;
    }

    /**
     * Adiciona um resumo, desde que seu tema ainda nao esteja registrado.
     *
     * @param tema     tema do resumo
     * @param conteudo conteudo do resumo
     */
    public void adiciona(String tema, String conteudo) {
        if (this.temResumo(tema))
            return;

        this.ultimoResumo++;
        /**
         * Verifica se existe resumo cadastrado com o tema informado.
         *
         * @param tema tema procurado
         * @return {@code true} quando o tema esta registrado
         */
        if (this.ultimoResumo >= resumos.length)
            ultimoResumo = 0;
        if (this.numeroDeResumos != resumos.length)
            this.numeroDeResumos = Math.min(this.ultimoResumo + 1, resumos.length);

        int idx = ultimoResumo;
        resumos[idx] = new Resumo(tema, conteudo);
    }

    /**
     * Verifica se existe resumo cadastrado com o tema informado.
     *
     * @param tema tema procurado
     * @return {@code true} quando o tema esta registrado
     */
    boolean temResumo(String tema) {
        for (int i = 0; i < numeroDeResumos; i++) {
            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Retorna a quantidade atual de resumos.
     *
     * @return numero de resumos armazenados
     */
    public int conta() {
        return this.numeroDeResumos;
    }

    /**
     * Retorna os resumos armazenados em formato textual.
     *
     * @return vetor com a representacao textual de cada resumo
     */
    public String[] pegaResumos() {
        String[] listaResumos = new String[this.numeroDeResumos];
        for (int i = 0; i < numeroDeResumos; i++) {
            listaResumos[i] = resumos[i].toString();
        }
        return listaResumos;
    }

    /**
     * Monta a lista dos temas armazenados.
     *
     * @return temas separados por {@code " | "}
     */
    private StringBuffer tiposResumos() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < numeroDeResumos; i++) {
            sb.append(resumos[i].getTema());
            if (i < numeroDeResumos - 1) {
                sb.append(" | ");
            }
        }

        return sb;
    }

    /**
     * Busca por conteúdo
     *
     * @return temas onde a palavra buscada faz parte do conteúdo
     */

    public String[] busca(String chaveDeBusca){
        int quantidadeSimilar = 0;
        for (int i=0; i < numeroDeResumos; i++){
            if (resumos[i].isSimilar(chaveDeBusca)){
                quantidadeSimilar++;
            }
        }

        String[] buscados = new String[quantidadeSimilar];
        int idx = 0;

        if (quantidadeSimilar > 0){
        for (int i=0; i < numeroDeResumos; i++){
            if (resumos[i].isSimilar(chaveDeBusca)){
                buscados[idx] = resumos[i].getTema();
                idx++;
            }
        }
        }

        return buscados;
    }

    /**
     * Retorna um resumo textual do registro.
     *
     * @return quantidade de resumos e seus respectivos temas
     */
    public String imprimeResumos() {
        return "- " + this.numeroDeResumos + " resumo(s) cadastrado(s)\n" + "- " + this.tiposResumos();
    }

}
