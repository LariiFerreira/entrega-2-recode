package dao;

import model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDAO {

    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(int id);
    List<Usuario> findAll();
    Optional<Usuario> findById(int id);


}