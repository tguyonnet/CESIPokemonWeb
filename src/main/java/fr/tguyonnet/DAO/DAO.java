package fr.tguyonnet.DAO;

import fr.tguyonnet.DB;

import java.sql.Connection;
import java.util.List;

public interface DAO<T> {
    Connection connect = DB.getConnection();

    T get(int i);

    List<T> getAll();

    void update(T t);

    void delete(int i);

    T add(T t);
}
