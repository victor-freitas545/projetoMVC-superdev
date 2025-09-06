package DAO;

import com.sun.source.tree.TryTree;
import model.Produto;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO implements GenericDAO {

    private Connection conn;

    public ProdutoDAO () throws Exception{
        try {
            this.conn = ConnectionFactory.getConnection();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Boolean insert(Object object) {

        //convertendo o objeto genérico em um objeto do tipo específico
        Produto produto = (Produto) object;

        //instaciando um objeto da classe que formata o comando sql
        PreparedStatement stmt = null;

        //escrevendo a sql para inserir um novo registro na tabela 'produto'
        String sql = "INSERT INTO produto (descricao,preco, status) VALUES (?,?,?)";

        try {
            //transforma a string sql em um comando válido para ser executado no banco
            stmt = this.conn.prepareStatement(sql);

            //inserindo valor em cada ponto de interrogação de forma sequencial
            //onde cada ? refere-se a uma coluna da tabela 'produto'
            //atentando para o tipo de cada coluna com o tipo do valor a ser enviado
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setBoolean(3,produto.isStatus());

            //xecuta a sql no banco
            stmt.execute();
        return true;
        } catch (SQLException e){
            System.out.println("Problemas ao inserir produto. Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn,stmt);
            } catch (Exception ex){
                System.out.println("Problema ao fechar conexão. Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean update(Object object) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
