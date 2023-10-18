package dao;

import infra.ConnectionFactory;
import model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO implements IUsuarioDAO{
    @Override
    public Usuario save(Usuario usuario) {
        try(Connection connection = ConnectionFactory.getConnection()) {

            String SQL = "INSERT INTO Usuario (nome, sobrenome, email, senha, celular, genero, cpf) VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setString(5, usuario.getCelular());
            preparedStatement.setString(6, usuario.getGenero());
            preparedStatement.setString(7, usuario.getCpf());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int generatedId = resultSet.getInt(1);
            usuario.setId(generatedId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    @Override
    public Usuario update(Usuario usuario) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String SQL = "UPDATE usuario SET nome = ?, sobrenome = ?, email = ?, senha = ?, celular = ?, genero = ?, cpf = ? WHERE id_usuario = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setString(5, usuario.getCelular());
            preparedStatement.setString(6, usuario.getGenero());
            preparedStatement.setString(7, usuario.getCpf());
            preparedStatement.setInt(8, usuario.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return usuario;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String SQL = "DELETE FROM Usuario WHERE id_Usuario = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Usuario> findAll() {

        String SQL = "SELECT id_Usuario, nome, sobrenome, email, senha, celular, genero FROM Usuario";

        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String celular = rs.getString("celular");
                String genero = rs.getString("genero");
                String cpf = rs.getString("cpf");



                Usuario usuario = new Usuario(id, nome, sobrenome, email, senha, celular, genero, cpf);
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return usuarios;
    }

    @Override
    public Optional<Usuario> findById(int id_Usuario) {
        String SQL = "SELECT id_usuario, nome, sobrenome, email, senha, celular, genero, cpf FROM Usuario WHERE id_usuario = ?";
        Usuario usuario = null;
        try (Connection connection = ConnectionFactory.getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, id_Usuario);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int pKey = rs.getInt("id_usuario");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String celular = rs.getString("celular");
                String genero = rs.getString("genero");
                String cpf = rs.getString("cpf");

                usuario = new Usuario(pKey, nome, sobrenome, email, senha, celular, genero, cpf);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(usuario);
    }
}
