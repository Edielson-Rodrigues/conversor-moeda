package testes;
import org.json.JSONException;
import org.json.JSONObject;

public class testeJson{
    public static void main(String[] args) throws JSONException {
        
        JSONObject json = new JSONObject();
        int[] values = {10, -90};
        // values[0] = 10;
        // values[1] = -90;

        json.put("s", 1);
        json.put("32", values);
        
        System.out.println(json);

        String teste = "{\"edielson\": \"Homem\", \"idade\": 20}";

        JSONObject converterString = new JSONObject(teste);

        System.out.println(converterString);

        String x = "10";
        double y = Double.parseDouble(x);
        System.out.println(y);

        double x1 = 10;
        String x2 = String.valueOf(x1);
        System.out.println(x2 + 10);


    }
}
