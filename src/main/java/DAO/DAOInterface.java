package DAO;

import Exceptions.DaoException;

import java.util.List;

public interface DAOInterface<T>  {
    List<T> getList() throws DaoException;
    T getByID(int id) throws DaoException;
    void add(T model) throws DaoException;
    void deleteByID(int id) throws DaoException;
    double getTotal() throws DaoException;
}
