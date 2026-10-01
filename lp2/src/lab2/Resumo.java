package lab2;

public class Resumo {

    private String tema;
    private String conteudo;

    public Resumo(String tema, String conteudo){
        this.tema = tema;
        this.conteudo = conteudo;
    }

    public String getTema(){
        return this.tema;
    }

    @Override
    public String toString(){
        return tema + ": " + conteudo;
    }

}
