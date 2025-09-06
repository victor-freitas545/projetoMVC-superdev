package Controller;

import DAO.GenericDAO;
import DAO.ProdutoDAO;
import model.Produto;

public class ProdutoController {

    private ProdutoDAO dao;

    public String insert(Produto produto) throws Exception {
        GenericDAO dao = new ProdutoDAO();
        boolean isCadastrado = dao.insert(produto);
        if (isCadastrado){
            return "Cadastro realizado com sucesso!";
        } else {
        return "erro ao cadastrar produto";
        }
    }
}
