package DAO;

import model.Funcionario;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

    public class FuncionarioDAO implements GenericDAO{

        private Connection conn;

        public FuncionarioDAO() throws Exception {
            try {
                this.conn = ConnectionFactory.getConnection();
            } catch (Exception e) {
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
            Funcionario funcionario = (Funcionario) object;

            PreparedStatement stmt = null;

            String sql = "INSERT INTO funcionario (id,nome,cargo,salario) VALUES (?,?,?,?)";

            try{
                stmt = this.conn.prepareStatement(sql);

                stmt.setString(1, funcionario.getNome());
                stmt.setString(2,funcionario.getCargo());
                stmt.setDouble(3,funcionario.getSalario());

                stmt.execute();
                return true;
        } catch (SQLException e) {
                System.out.println("Problemas ao inserir funcionário. Erro: " + e.getMessage());
                e.printStackTrace();
                return false;
            } finally {

            }

            @Override
        public Boolean update(Object object) {
            return null;
        }

        @Override
        public void delete(int id) {

        }
    }
}
