package lab2;

/**
 * Registra o tempo investido pelo aluno em uma disciplina.
 * 
 * @author Pedro Luis da Silva Rocha Dias
 */
public class RegistroTempoOnline {

        /** Nome da disciplina associada ao registro. */
        private String nomeDisciplina;

        /** Quantidade de horas online ja investidas. */
        private int tempoInvestidoOnline;

        /** Quantidade de horas online esperadas para a disciplina. */
        private int tempoEsperado;

        /**
         * Constroi um registro com a meta padrao de 120 horas online.
         *
         * @param nomeDisciplina nome da disciplina
         */
        public RegistroTempoOnline(String nomeDisciplina) {
                this.nomeDisciplina = nomeDisciplina;
                this.tempoEsperado = 120;
                this.tempoInvestidoOnline = 0;
        }

        /**
         * Constroi um registro com uma meta de horas definida pelo usuario.
         *
         * @param nomeDisciplina nome da disciplina
         * @param tempoEsperado  quantidade de horas online esperadas
         */
        public RegistroTempoOnline(String nomeDisciplina, int tempoEsperado) {
                this.nomeDisciplina = nomeDisciplina;
                this.tempoEsperado = tempoEsperado;
                this.tempoInvestidoOnline = 0;
        }

        /**
         * Adiciona horas ao tempo online investido.
         *
         * @param tempo quantidade de horas a adicionar
         */
        void adicionaTempoOnline(int tempo) {
                this.tempoInvestidoOnline += tempo;
        }

        /**
         * Verifica se o tempo online investido alcancou a meta registrada.
         *
         * @return {@code true} quando a meta foi atingida
         */
        public boolean atingiuMetaTempoOnline() {
                return tempoInvestidoOnline * 2 >= tempoEsperado;
        }

        /**
         * Retorna a representacao textual do registro.
         *
         * @return nome da disciplina, tempo investido e tempo esperado
         */
        @Override
        public String toString() {
                return this.nomeDisciplina + " " + this.tempoInvestidoOnline + " / " + this.tempoEsperado;
        }

}
