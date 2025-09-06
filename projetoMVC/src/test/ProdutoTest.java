package test;

import Controller.ProdutoController;
import model.Produto;

import javax.swing.*;

public class ProdutoTest {

    public static void main(String[] args) throws Exception {

        ProdutoController controller = new ProdutoController();

        Produto novoProduto = new Produto();
        novoProduto.setDescricao("Garrafinha de inox");
        novoProduto.setPreco(59.90);
        novoProduto.setStatus(true);

        String mensagemInsert = controller.insert(novoProduto);
        JOptionPane.showMessageDialog(null, mensagemInsert);

    }
}
