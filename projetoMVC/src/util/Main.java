package util;

import Controller.ProdutoController;
import model.Produto;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();

        StringBuilder = new StringBuilder();
        menu.append("*** Menu do Sistema ***");
        menu.append("\n[1] Cadastrar");
        menu.append("\n[2] Listar");
        menu.append("\n[0] Sair");
        menu.append("\n\n Selecione uma opção: ");

        int opcao = 1;
        while (opcao != 0){
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao){
                case 1:
                    String descricao = JOptionPane.showInputDialog("Descrição do Produto");
                    Double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do produto"));

                    Produto novoProduto = new Produto();
                    novoProduto.setDescricao(descricao);
                    novoProduto.setPreco(preco);
                    novoProduto.setStatus(true);

                    String mensagemInsert = controller.insert(novoProduto);
                    JOptionPane.showMessageDialog(null, mensagemInsert);
                    break;

            }
        }

    }
}
