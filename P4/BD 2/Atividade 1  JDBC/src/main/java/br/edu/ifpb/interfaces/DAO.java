package br.edu.ifpb.interfaces;

import br.edu.ifpb.entities.Pedido;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    public void save(T obj);
    public void update(T obj);
    public List<T> listAll();
    public void delete(int index);
}
