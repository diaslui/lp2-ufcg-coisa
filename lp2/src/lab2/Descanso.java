package lab2;

public class Descanso {

        private int horasDescanso;
        private int numeroSemanas;


        public void Descanso(){
            this.horasDescanso = 0;
            this.numeroSemanas = 0;
        }

        public void defineHorasDescanso(int valor){
            this.horasDescanso = valor;
        }

        public void defineNumeroSemanas(int valor){
            this.numeroSemanas = valor;
        }

        private boolean isDescansado(){
            if (this.numeroSemanas == 0 || this.horasDescanso == 0){
                return false;
            }
            return this.horasDescanso / this.numeroSemanas >= 26;
        }

        public String getStatusGeral(){
            if (this.isDescansado()){
                return (String) "descansado";
            }
            return (String) "cansado";
        }

}
