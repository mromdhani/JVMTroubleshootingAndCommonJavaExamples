package be.businesstraining.repository;

import java.util.List;

import be.businesstraining.domain.Compte;

public interface IComptesDao {
    // CRUD
    void create(Compte compte);
    Compte findById(String id);
    List<Compte> findAll();
    Compte update(Compte compte);
    void delete(String id);
}
