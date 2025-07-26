package src.model.principal;

import src.model.Update.Inserindo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("DIGITE A QUANTIDADE DE ITENS DA COMPRA:  ");
        int n = sc.nextInt();

        Inserindo obj = new Inserindo();
        obj.criarTabela();

        for (int i = 0; i < n; i++) {
            System.out.println("DIGITE O NOME DO PRODUTO:  ");
            String nome = sc.nextLine();
            System.out.println("DIGITE O PRECO DO PRODUTO:  ");
            double preco = sc.nextDouble();


            obj.inserirDados(nome, preco);
        }

        }
    }

