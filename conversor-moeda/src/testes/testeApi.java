package testes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class testeApi {

    public static void main(String[] args) {
        try {
            String currency = "BRL"; // Moeda de destino
            String baseCurrency = "MVR"; // Moeda de origem

            // Faz uma requisição GET para a Exchange Rates API
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Lê a resposta da requisição
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = reader.readLine();
            System.out.println(response);
            reader.close();
          


            // Processa a resposta JSON
            String json = response.toString();
            double exchangeRate = parseExchangeRate(json, currency);

            // Exibe o resultado
            System.out.println("1 " + baseCurrency + " = " + exchangeRate + " " + currency);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para extrair a taxa de câmbio da resposta JSON
    private static double parseExchangeRate(String json, String currency) {
        double exchangeRate = 1.0;
        try {
            // Processa a resposta JSON
            JSONObject jsonObject = new JSONObject(json); // Convertendo o retorno para um objeto json
            // System.out.println(jsonObject);
            JSONObject rates = jsonObject.getJSONObject("rates"); // Pegando o objeto Json que foi convertido e que tem a chave rates, esse json está dentro de outro json raiz
            exchangeRate = rates.getDouble(currency); //Procurando o 
            // System.out.println(rates.get("HKD"));
        } catch (Exception ex) {
           System.out.println("Error " +ex.getMessage());
        }
        return exchangeRate;
    }
}
