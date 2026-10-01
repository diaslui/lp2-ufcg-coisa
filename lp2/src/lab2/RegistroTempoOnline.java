package lab2;

public class RegistroTempoOnline {
        private String nomeDisciplina;
        private int tempoInvestidoOnline;
        private int tempoEsperado;

        public RegistroTempoOnline(String nomeDisciplina){
                this.nomeDisciplina = nomeDisciplina;
                this.tempoEsperado = 120;
                this.tempoInvestidoOnline = 0;
        }

        public RegistroTempoOnline(String nomeDisciplina, int tempoEsperado){
                this.nomeDisciplina = nomeDisciplina;
                this.tempoEsperado = tempoEsperado;
                this.tempoInvestidoOnline = 0;
        }

        void adicionaTempoOnline(int tempo){
                this.tempoInvestidoOnline += tempo;
        }

        boolean atingiuMetaTempoOnline(){
            return tempoInvestidoOnline * 2 >= tempoEsperado;
        }

        @Override
        public String toString(){
                return this.nomeDisciplina + " " + this.tempoInvestidoOnline + " / " + this.tempoEsperado;
        }

}
