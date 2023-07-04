import java.awt.Component;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal {

    public static void main(String[] args){

        // Montando primeiro painel
        String[] conversores = {"Conversor de moeda", "Conversor de temeperatura"};

        Object[] respostaPrimeiroMenu = montarPainel(conversores, "Escolha um conversor");

        if(respostaPrimeiroMenu[0].equals(conversores[0]) && respostaPrimeiroMenu[2].hashCode() != -1){
            String[] conversoesMoeda = {"De Reais a Dólar", "De Reais a Euro", "De Reais a Libras Esterlinas",
                                            "De Reais a Peso argentino", "De Reais a Peso Chileno", "De Dólar a Reais",
                                                "De Euro a Reais", "De Libras Esterlinas a Reais", "De Peso argentino a Reais",
                                                    "De Peso Chileno a Reais"};
            
            ArrayList<String[]> opcoesConversoesMoeda = new ArrayList<>();
            // de reais para x
            opcoesConversoesMoeda.add(new String[]{"BRL", "USD"}); opcoesConversoesMoeda.add(new String[]{"BRL", "EUR"});
            opcoesConversoesMoeda.add(new String[]{"BRL", "GBP"}); opcoesConversoesMoeda.add(new String[]{"BRL", "ARS"});
            opcoesConversoesMoeda.add(new String[]{"BRL", "CLP"});
            // de x para reais
            opcoesConversoesMoeda.add(new String[]{"USD", "BRL"}); opcoesConversoesMoeda.add(new String[]{"EUR", "BRL"});
            opcoesConversoesMoeda.add(new String[]{"GBP", "BRL"}); opcoesConversoesMoeda.add(new String[]{"ARS", "BRL"});
            opcoesConversoesMoeda.add(new String[]{"CLP", "BRL"});
            
            /*reais = BRL;  dólar = USD; euro = EUR; Libras Esterlinas = GBP; Peso argentino = ARS; peso Chileno = CLP*/
            
            Object[] escolhaMoedas = montarPainel(conversoesMoeda, "Escolha a moeda para a qual você deseja girar seu dinheiro");

            if(escolhaMoedas[2].hashCode() != -1){
                String valor = JOptionPane.showInputDialog("Qual é o valor");
                
                if(isNumeric(valor)){
                    double valorNumerico = Double.parseDouble(valor);
                    
                    Moeda moedaOrigem = new Moeda(opcoesConversoesMoeda.get(escolhaMoedas[1].hashCode())[0], valorNumerico);
                    Moeda moedaDestiono = new Moeda(opcoesConversoesMoeda.get(escolhaMoedas[1].hashCode())[1], valorNumerico);

                    //Chamando função para conversão
                    double resultadoConversao = Double.parseDouble(moedaOrigem.converter(moedaOrigem, moedaDestiono));

                    JOptionPane.showMessageDialog(null, 
                                                opcoesConversoesMoeda.get(escolhaMoedas[1].hashCode())[0] +": "+ valorNumerico +"\n"+ opcoesConversoesMoeda.get(escolhaMoedas[1].hashCode())[1] +": "+resultadoConversao, 
                                                "Resultado da conversão", 
                                                JOptionPane.INFORMATION_MESSAGE);

                }else{
                    JOptionPane.showMessageDialog(null, 
                                            "O valor deve conter apenas números", 
                                            "Error", 
                                            JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
        
        else if(respostaPrimeiroMenu[0].equals(conversores[1]) && respostaPrimeiroMenu[2].hashCode() != -1){
            String[] conversoesTemperatura = {"De Celsius a Kelvin", "De Celsius a Fahrenheit", "De Kelvin a Celsius",
                                                        "De Kelvin a Fahrenheit", "De Fahrenheit a Celsius", "De Fahrenheit a Kelvin"};
            
            ArrayList<String[]> opcoesConversoesTemperatura = new ArrayList<>();
            opcoesConversoesTemperatura.add(new String[]{"Celsius", "Kelvin"}); opcoesConversoesTemperatura.add(new String[]{"Celsius", "Fahrenheit"});
            opcoesConversoesTemperatura.add(new String[]{"Kelvin", "Celsius"}); opcoesConversoesTemperatura.add(new String[]{"Kelvin", "Fahrenheit"});
            opcoesConversoesTemperatura.add(new String[]{"Fahrenheit", "Celsius"}); opcoesConversoesTemperatura.add(new String[]{"Fahrenheit", "Kelvin"});
            /*c - k - f = c -> k; c -> f; k -> c; k -> f; f -> c; f -> k
             * 
             * Kelvin (K), Celsius (C) e Fahrenheit (F).
            */

            Object[] escolhaTemperaturas = montarPainel(conversoesTemperatura, "Escolha a escala para a qual você deseja converter a tempetura");

            if(escolhaTemperaturas[2].hashCode() != -1){
                String valor = JOptionPane.showInputDialog("Qual é o valor");

                if(isNumeric(valor)){
                    double valorNumerico = Double.parseDouble(valor);

                    Temperatura temperaturaOrigem = new Temperatura(opcoesConversoesTemperatura.get(escolhaTemperaturas[1].hashCode())[0], valorNumerico);
                    Temperatura temperaturaDestino = new Temperatura(opcoesConversoesTemperatura.get(escolhaTemperaturas[1].hashCode())[1], valorNumerico);
                
                    double resultadoConversao = Double.parseDouble(temperaturaOrigem.converter(temperaturaOrigem, temperaturaDestino));
                
                    JOptionPane.showMessageDialog(null, 
                                                opcoesConversoesTemperatura.get(escolhaTemperaturas[1].hashCode())[0] +": "+ valorNumerico +"\n"+ opcoesConversoesTemperatura.get(escolhaTemperaturas[1].hashCode())[1] +": "+resultadoConversao, 
                                                "Resultado conversão", 
                                                JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, 
                                                "O valor deve conter apenas números", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

    public static Object[] montarPainel(String[] lista, String mensagem){
    
        // Montando painel personalizado
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createHorizontalGlue());

        // Adicionando mensagem
        JLabel label = new JLabel(mensagem);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        panel.add(Box.createVerticalStrut(10));

        // Montando seletor
        JComboBox comboBox = new JComboBox<>(lista);
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(comboBox);

        // Exibindo painel
        Integer acao = JOptionPane.showOptionDialog(
            null, 
            panel, 
            "Menu", 
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            new Object[]{"OK"}, 
            "OK");

        String escolhaItem = comboBox.getSelectedItem().toString();
        Integer escolhaIndex = comboBox.getSelectedIndex();
        
        return new Object[]{escolhaItem, escolhaIndex, acao};
    }

    public static boolean isNumeric(String valor){
        
        try{
            Double.parseDouble(valor);
            return true;
        }catch(Exception ex){
            return false;
        }
    }


}

