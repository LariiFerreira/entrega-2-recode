package dao;

import model.Destino;

import java.util.List;
import java.util.Optional;

public interface IDestinoDAO {

    Destino save(Destino destino);
    Destino update(Destino destino);
    void delete(Long id);
    List<Destino> findAll();
    Optional<Destino> findById(Long id);

    Optional<Destino> findById(String id);
}
