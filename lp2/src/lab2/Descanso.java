package lab2;

/**
 * Representa a rotina semanal de descanso do aluno.
 * O aluno e considerado descansado quando possui pelo menos 26 horas de
 * descanso por semana.
 */
public class Descanso {

        /** quant total de horas de descanso registradas. */
        private int horasDescanso;

        /** quant de semanas consideradas no registro. */
        private int numeroSemanas;

        /**
         * Constroi um registro de descanso sem horas e semanas definidas.
         */
        public Descanso(){
            this.horasDescanso = 0;
            this.numeroSemanas = 0;
        }

        /**
         * Define a quant de horas de descanso.
         *
         * @param valor quant de horas de descanso
         */
        public void defineHorasDescanso(int valor){
            this.horasDescanso = valor;
        }

        /**
         * Define a quant de semanas consideradas.
         *
         * @param valor quant de semanas
         */
        public void defineNumeroSemanas(int valor){
            this.numeroSemanas = valor;
        }

        /**
         * Verifica se a media de descanso alcanca 26 horas por semana.
         *
         * @return {@code true} se o aluno estiver descansado
         */
        private boolean isDescansado(){
            if (this.numeroSemanas == 0 || this.horasDescanso == 0){
                return false;
            }
            return this.horasDescanso / this.numeroSemanas >= 26;
        }

        /**
         * Retorna o estado geral da rotina de descanso.
         *
         * @return {@code "descansado"} ou {@code "cansado"}
         */
        public String getStatusGeral(){
            if (this.isDescansado()){
                return (String) "descansado";
            }
            return (String) "cansado";
        }

}
