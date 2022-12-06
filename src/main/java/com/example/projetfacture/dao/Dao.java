package com.example.projetfacture.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void update(int idParam, String name, String description);

    void delete(T t);
}
