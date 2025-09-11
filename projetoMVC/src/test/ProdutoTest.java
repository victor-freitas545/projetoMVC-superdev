package test;

import Controller.ProdutoController;
import model.Produto;

import javax.swing.*;
import java.util.List;

public class ProdutoTest {

    public static void main(String[] args) throws Exception {

        ProdutoController controller = new ProdutoController();

        Produto novoProduto = new Produto();
        novoProduto.setDescricao("Garrafinha de inox");
        novoProduto.setPreco(59.90);
        novoProduto.setStatus(true);

        String mensagemInsert = controller.insert(novoProduto);
        JOptionPane.showMessageDialog(null, mensagemInsert);

        // Obter a lista do tipo Produto
        List<Produto> produtoList = controller.getAll();

        // Crio uma variável para construir a mensagem de saída de dados
        StringBuilder listaImprimir = new StringBuilder();

        // Para cada elemento encontrado na lista de produtos, montar o texto
        // que será apresentado no painel com os atributos do objeto
        for (Produto produto : produtoList) {
            listaImprimir.append(produto.getDescricao());
            listaImprimir.append(" - ");
            listaImprimir.append(produto.getPreco());
            listaImprimir.append("\n");
        }

        // Imprimir na tela a lista de produtos
        JOptionPane.showMessageDialog(
                null,
                listaImprimir.toString());

    }
}
