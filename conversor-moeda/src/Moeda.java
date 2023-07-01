import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Moeda implements Conversao{
    
    private String nome;
    private double quantia;

    public Moeda(String nome, double quantia) {
        this.nome = nome;
        this.quantia = quantia;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getQuantia() {
        return quantia;
    }

    public void setQuantia(double quantia) {
        this.quantia = quantia;
    }

    // Buscanco cotação da moeda
    public String consultarCotacao(Moeda moedaOrigem, Moeda modeaDestino){

        try{
            // Fazendo requisição
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" +moedaOrigem.getNome());
            HttpURLConnection conexao =  (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            
            // Recebendo resposta
            BufferedReader lendo = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream())).readLine();
            lendo.close();

            // Verificando valores
            // System.out.println(resposta);

            return manipulacaoJson(resposta, modeaDestino); 

        }catch(Exception ex){
            return "Erro "+ex.getMessage();
        }
    }

    public String manipulacaoJson(String resposta, Moeda moedaDestino){ 

        try{
            // Convertendo resposta para Json
            JSONObject respostaJson = new JSONObject(resposta).getJSONObject("rates"); 
            return String.valueOf(respostaJson.getDouble(moedaDestino.getNome()));
        }catch(Exception ex){
            return "Error " +ex.getMessage();
        }
    }

    @Override
    public String converter(Moeda moedaOrigem, Moeda moedaDestino) {
   
        try{
            // Realizando conversão
            double resultadoConversao = Double.parseDouble(consultarCotacao(moedaOrigem, moedaDestino)) * moedaOrigem.getQuantia();
            return String.valueOf(resultadoConversao);
        }catch(Exception ex){
            return "Error " +ex.getMessage();
        }
    
    }

}
