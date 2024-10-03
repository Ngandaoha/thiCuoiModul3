package service;

import model.MatBang;

import java.util.List;

public interface IDAO {
    List<MatBang> findAll();
    MatBang findById(String maMB);
    void save(MatBang matBang);
    boolean delete(String maMB);
}
