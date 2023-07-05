package models;
public class Temperatura implements Conversao{
    
    private String escala;
    private double valor;

    public Temperatura(String escala, double valor) {
        this.escala = escala;
        this.valor = valor;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String converter(Object origem, Object destino) {
        
        Temperatura temperaturaOrigem = (Temperatura) origem;
        Temperatura temperaturaDestino = (Temperatura) destino;

        try{
            if(temperaturaOrigem.getEscala().equals("Celsius") && temperaturaDestino.getEscala().equals("Kelvin")){
                return String.valueOf(temperaturaOrigem.getValor() + 273);
            }else if(temperaturaOrigem.getEscala().equals("Celsius") && temperaturaDestino.getEscala().equals("Fahrenheit")){
                return String.valueOf((1.8 * temperaturaOrigem.getValor()) + 32);
            }else if(temperaturaOrigem.getEscala().equals("Kelvin") && temperaturaDestino.getEscala().equals("Celsius")){
                return String.valueOf(temperaturaOrigem.getValor() - 273);
            }else if(temperaturaOrigem.getEscala().equals("Kelvin") && temperaturaDestino.getEscala().equals("Fahrenheit")){
                return String.valueOf(((temperaturaOrigem.getValor() - 273) * 1.8) + 32);
            }else if(temperaturaOrigem.getEscala().equals("Fahrenheit") && temperaturaDestino.getEscala().equals("Celsius")){
                return String.valueOf((temperaturaOrigem.getValor() - 32) / 1.8);
            }else if(temperaturaOrigem.getEscala().equals("Fahrenheit") && temperaturaDestino.getEscala().equals("Kelvin")){
                return String.valueOf(((temperaturaOrigem.getValor() - 32) * 5/9) + 273);
            }else{
                return String.valueOf(temperaturaOrigem.getValor());
            }

            /*c - k - f = c -> k; c -> f; k -> c; k -> f; f -> c; f -> k
             * 
             * Kelvin (K), Celsius (C) e Fahrenheit (F).
            */
        }catch(Exception ex){
            return "Error " +ex.getMessage();
        }
    }

   

    
}
