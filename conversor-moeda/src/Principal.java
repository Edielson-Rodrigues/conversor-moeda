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
        String[] conversores = {"Conversor de moeda", "Converdor de temeperatura"};

        Object[] respostaPrimeiroMenu = montarPainel(conversores, "Escolha um conversor");
        
        if(respostaPrimeiroMenu[0].equals(conversores[0]) && respostaPrimeiroMenu[1].hashCode() != -1){
            String[] conversoesMoeda = {"De Reais a Dólar", "De Reais a Euro", "De Reais a Libras Esterlinas",
                                            "De Reais a Peso argentino", "De Reais a Peso Chileno", "De Dólar a Reais",
                                                "De Euro a Reais", "De Libras Esterlinas a Reais", "De Peso argentino a Reais",
                                                    "De Peso Chileno a Reais"};
            
            ArrayList<String[]> opcoesConvesoes = new ArrayList<>();
            // de reais para x
            opcoesConvesoes.add(new String[]{"BRL", "USD"}); opcoesConvesoes.add(new String[]{"BRL", "EUR"});
            opcoesConvesoes.add(new String[]{"BRL", "GBP"}); opcoesConvesoes.add(new String[]{"BRL", "ARS"});
            opcoesConvesoes.add(new String[]{"BRL", "CLP"});
            // de x para reais
            opcoesConvesoes.add(new String[]{"USD", "BRL"}); opcoesConvesoes.add(new String[]{"EUR", "BRL"});
            opcoesConvesoes.add(new String[]{"GBP", "BRL"}); opcoesConvesoes.add(new String[]{"ARS", "BRL"});
            opcoesConvesoes.add(new String[]{"CLP", "BRL"});
            
            System.out.println(opcoesConvesoes.get(4)[0] + " " + opcoesConvesoes.get(4)[1]);
            /*reais = BRL;  dólar = USD; euro = EUR; Libras Esterlinas = GBP; Peso argentino = ARS; peso Chileno = CLP*/
        
            Object[] escolhaMoedas = montarPainel(conversoesMoeda, "Escolha a moeda para a qual você deseja girar seu dinheiro");

            if(escolhaMoedas[1].hashCode() != -1){
                String valor = JOptionPane.showInputDialog("Qual é o valor");

                if(isNumeric(valor)){
                    //Criando....
                }

            
            }
        }
        
        else if(respostaPrimeiroMenu[0].equals(conversores[1]) && respostaPrimeiroMenu[1].hashCode() != -1){
            System.out.println("na minha");
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

        String escolha = comboBox.getSelectedItem().toString();
        
        return new Object[]{escolha, acao};

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

