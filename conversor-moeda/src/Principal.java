import java.util.Scanner;

public class Principal {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String moedaBase = "USD";
        String moedaDestino = "BRL";

        Moeda moeda1 = new Moeda(moedaBase, 2.45);    
        Moeda moeda2 = new Moeda(moedaDestino, moeda1.getQuantia());

        System.out.println(moeda1.converter(moeda1, moeda2)); // -> Retornando String

        System.out.println("res");
    }
}
