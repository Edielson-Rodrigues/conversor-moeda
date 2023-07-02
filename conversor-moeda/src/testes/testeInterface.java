package testes;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class testeInterface {
    public static void main(String[] args) throws Exception {
     
        // Mensagem
    // JOptionPane.showMessageDialog(null,
    // "Os ovos não devem ser verdes.",
    // "Erro inane",
    // JOptionPane.ERROR_MESSAGE);
    
    // Input
    // String leitura = JOptionPane.showInputDialog("Qual é o seu nome?");
    // System.out.println(leitura);

    //Options
    // int resposta = JOptionPane.showConfirmDialog(null, "Você é casado?");
    // System.out.println(resposta);

     // Exibe uma mensagem com o título e ícone personalizados
        // JOptionPane.showMessageDialog(null, "Olá, bem-vindo ao JOptionPane!",
        //         "Mensagem de Boas-vindas", JOptionPane.INFORMATION_MESSAGE);

        // // Exibe uma caixa de diálogo de entrada para solicitar o nome do usuário
        // String nome = JOptionPane.showInputDialog(null, "Digite seu nome:");

        // // // Exibe uma caixa de diálogo de confirmação com botões Yes/No
        // int resposta = JOptionPane.showConfirmDialog(null, "Você gostaria de continuar, " + nome + "?",
        //         "Confirmação", JOptionPane.YES_NO_OPTION);

        // // // Verifica a resposta do usuário
        // if (resposta == JOptionPane.YES_OPTION) {
        //     // Exibe uma caixa de diálogo de mensagem com um botão OK
        //     JOptionPane.showMessageDialog(null, "Ótimo, " + nome + "! Aproveite o seu dia.",
        //             "Mensagem de Confirmação", JOptionPane.INFORMATION_MESSAGE);
        // } else {
        //     // Exibe uma caixa de diálogo de mensagem com um botão OK
        //     JOptionPane.showMessageDialog(null, "Tudo bem, " + nome + ". Até mais!",
        //             "Mensagem de Confirmação", JOptionPane.INFORMATION_MESSAGE);
        // }
    
        // Cria um array com as opções para o JComboBox
        String[] opcoes = { "Opção 1", "Opção 2", "Opção 3" };

        // // // Cria um painel personalizado com componentes
        JOptionPane pane = new JOptionPane();
        pane.setMessage("Selecione uma opção:");
        pane.setMessageType(JOptionPane.QUESTION_MESSAGE);
        pane.setOptions(opcoes);

        // // Posiciona os elementos na caixa de diálogo
        pane.setInitialValue(opcoes[1]); // Define a opção inicialmente selecionada

        // Exibe a caixa de diálogo e captura a resposta do usuário
        JDialog dialog = pane.createDialog(null, "Posicionamento de Elementos");
        // dialog.setLocation(300, 200); // Define a posição da caixa de diálogo na tela,
        dialog.setVisible(true);
     
        try{
            Object resposta = pane.getValue(); 
            System.out.println(resposta.toString());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        // // Obtém a resposta selecionada pelo usuário
        // Object resposta = pane.getValue();

        // // Verifica a resposta
        // // if (resposta != null) {
        // //     int index = pane.getOptions().indexOf(resposta);
        // //     if (index >= 0) {
        // //         String opcaoSelecionada = opcoes[index];
        // //         JOptionPane.showMessageDialog(null, "Opção selecionada: " + opcaoSelecionada);
        // //     }
        // // }

         // Cria um painel personalizado com os componentes desejados
        // JPanel panel = new JPanel();
        // JLabel nameLabel = new JLabel("Nome:");
        // JTextField nameField = new JTextField(10);
        // JLabel ageLabel = new JLabel("Idade:");
        // JTextField ageField = new JTextField(10);
        // panel.add(nameLabel);
        // panel.add(nameField);
        // panel.add(ageLabel);
        // panel.add(ageField);

        // // Exibe a caixa de diálogo com o painel personalizado
        // int option = JOptionPane.showOptionDialog(null, panel, "Informações Pessoais",
        //         JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);

        // // Verifica se o usuário pressionou o botão OK
        // if (option == JOptionPane.OK_OPTION) {
        //     String nome = nameField.getText();
        //     String idade = ageField.getText();
        //     JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nIdade: " + idade);
        // }



        
    }
}
