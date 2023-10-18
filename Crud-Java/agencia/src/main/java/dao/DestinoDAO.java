package dao;

import infra.ConnectionFactory;
import model.Destino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DestinoDAO implements IDestinoDAO {
    @Override
    public Destino save(Destino destino) {
        try (Connection connection = ConnectionFactory.getConnection()) {

            String SQL = "INSERT INTO Destinos (nomeDestino, valorPadrao, valorPromocional) VALUES(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, destino.getNomeDestino());
            preparedStatement.setString(2, destino.getValorPadrao());
            preparedStatement.setString(3, destino.getvalorPromocional());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int generatedId = resultSet.getInt(1);
            destino.setId(generatedId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return destino;
    }

    @Override
    public Destino update(Destino destino) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String SQL = "UPDATE Destinos SET nome = ?, valor = ? WHERE id_Destinos = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, destino.getNomeDestino());
            preparedStatement.setString(2, destino.getValorPadrao());
            preparedStatement.setString(2, destino.getvalorPromocional());
            preparedStatement.setInt(4, destino.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return destino;
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String SQL = "DELETE FROM  Destinos  WHERE id_Destinos = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Destino> findAll() {

        String SQL = "SELECT id_Destinos, nomeDestino, valorPadrao, valorPromocional FROM Destinos";

        List<Destino> destinos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomeDestino = rs.getString("nomeDestino");
                String valorPadrao = rs.getString("valorPadrao");
                String valorPromocional = rs.getString("valorPromocional");

                Destino destino = new Destino(id, nomeDestino, valorPadrao, valorPromocional);
                destinos.add(destino);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return destinos;
    }

    @Override
    public Optional<Destino> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Destino> findById(String id) {
        String SQL = "SELECT id_Destinos,nomeDestino, valorPadrao, valorPromocional FROM Destinos WHERE id_Destinos = ?";
        Destino destino = null;
        try (Connection connection = ConnectionFactory.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, Long.parseLong(id));
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int pKey = rs.getInt("id_destinos");
                String nomeDestino = rs.getString("nomeDestino");
                String valorPadrao = rs.getString("valorPadrao");
                String valorPromocional = rs.getString("valorPromocional");

                destino = new Destino(pKey, nomeDestino, valorPadrao, valorPromocional);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(destino);
    }
}