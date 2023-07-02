package testes;

import javax.print.DocFlavor.STRING;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class testeJcomboBox {

    public static void main(String[] args) {
        String[] opcoesConversores = {"Conversor de moeda", "Conversor de temperatura"};

        JOptionPane primeiroPane = new JOptionPane();
        primeiroPane.setMessage(primeiroPane);

        // Criado seletor e
        JComboBox<String> comboBox = new JComboBox<>(opcoesConversores);
        primeiroPane.setMessage(comboBox);

        // Permite exibir a "caixa" como um todo
        JDialog dialog = primeiroPane.createDialog(null, "Menu");
        dialog.setVisible(true);

        // Pegando valor do pane
        // Object respostaPane = primeiroPane.getValue();
        // System.out.println(respostaPane.toString());

        // Pegando o valor da opção selecionada
        Object resposta = comboBox.getSelectedItem();
        
        System.out.println(resposta.toString());

        // if (resposta != null) {
        //     if (resposta.toString().equals(opcoesConversores[0])) {
        //         String[] opcoesTemperatura = {"opcao 1", 
        //             "opcao 2", "opcao 3"};

        //         JOptionPane segundoPane = new JOptionPane();
        //         segundoPane.setMessage("Escolha padrões para conversão");
            
        //         JDialog segundoDialog = segundoPane.createDialog(null, "Escolha de temperatua");
        //         segundoDialog.setVisible(true);
            
        //     }
        // }
    }
}
