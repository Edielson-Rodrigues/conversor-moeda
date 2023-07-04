package testes;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Component;

public class testeJcomboBox {

    public static void main(String[] args) {
        String[] opcoesConversores = {"Conversor de moeda", "Conversor de temperatura"};

        // Cria um painel personalizado com layout vertical e espaçamento
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //Define alinhamento vertical

        // Adiciona um componente de espaçamento para centralizar verticalmente
        panel.add(Box.createVerticalGlue());

        // Adiciona a primeira mensagem ao painel e a alinha para o centro
        JLabel label = new JLabel("Escolha uma opção");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        // Adiciona espaçamento vertical entre a mensagem e o seletor de opções
        panel.add(Box.createVerticalStrut(10));

        // Cria o seletor de opções
        JComboBox<String> comboBox = new JComboBox<>(opcoesConversores);
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
       

        // Adiciona o seletor de opções ao painel e o alinha para o centro
        panel.add(comboBox);

        // Adiciona um componente de espaçamento para centralizar verticalmente
        panel.add(Box.createVerticalGlue());

        // Exibe o JOptionPane com o painel personalizado e o botão "OK"
        int escolha = JOptionPane.showOptionDialog(
                null,
                panel,
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"OK"},
                "OK");

        if (escolha == JOptionPane.OK_OPTION) {
            Object resposta = comboBox.getSelectedItem();
            if (resposta != null) {
                String opcaoSelecionada = resposta.toString();
                System.out.println("Opção selecionada: " + opcaoSelecionada);
            }
        }
    }
}
