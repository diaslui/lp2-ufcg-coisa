package lab2;

public class RegistroResumos {

    private Resumo[] resumos;
    private int numeroDeResumos;
    private int ultimoResumo;

    public RegistroResumos(int numeroDeResumos){
         this.resumos = new Resumo[numeroDeResumos];
         this.numeroDeResumos = 0;
         this.ultimoResumo = -1;
    }

    public void adiciona(String tema, String conteudo){
        if (this.temResumo(tema)) return;

        this.ultimoResumo++;
        if (this.ultimoResumo >= resumos.length) ultimoResumo = 0;
        if (this.numeroDeResumos != resumos.length) this.numeroDeResumos = Math.min(this.ultimoResumo+1, resumos.length);

        int idx = ultimoResumo;
        resumos[idx] = new Resumo(tema, conteudo);
    }

    boolean temResumo(String tema){
        for (int i=0; i < numeroDeResumos; i++){
            if (resumos[i].getTema().equals(tema)){
                return true;
            }
        }

        return false;
    }

    public int conta(){
        return this.numeroDeResumos;
    }

    public String[] pegaResumos(){
        String[] listaResumos = new String[this.numeroDeResumos];
        for (int i=0; i < numeroDeResumos; i++){
            listaResumos[i] = resumos[i].toString();
        }
        return  listaResumos;
    }

    private StringBuffer tiposResumos(){
        StringBuffer sb = new StringBuffer();

        for (int i=0; i < numeroDeResumos; i++){
            sb.append(resumos[i].getTema());
            if (i < numeroDeResumos -1){
                sb.append(" | ");
            }
        }

        return sb;
    }

    public String imprimeResumos(){
        return "- " + this.numeroDeResumos + " resumo(s) cadastrado(s)\n" + "- " +  this.tiposResumos();
    }

}
