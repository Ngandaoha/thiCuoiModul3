package service;

import common.BaseRepository;
import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements IDAO{
    private final BaseRepository baseRepository;

    {
        try {
            baseRepository = new BaseRepository();
            System.out.println("Connected to database");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<MatBang> toList(ResultSet resultSet) throws SQLException {
        List<MatBang> list = new ArrayList<>();
        while (resultSet.next()) {
            String maMB = resultSet.getString("ma_mb");
            int maTT = resultSet.getInt("ma_tt");
            String tenTT = resultSet.getString("ten_tt");
            int dienTich = resultSet.getInt("dien_tich");
            int tang = resultSet.getInt("tang");
            int maLMB = resultSet.getInt("ma_lmb");
            String tenLMB = resultSet.getString("ten_lmb");
            int gia = resultSet.getInt("gia_tien");
            Date ngayBatDau = Date.valueOf(resultSet.getString("ngay_bd"));
            Date ngayKetThuc = Date.valueOf(resultSet.getString("ngay_kt"));
            MatBang matBang = new MatBang(maMB, new TrangThai(maTT, tenTT), dienTich, tang, new LoaiMatBang(maLMB, tenLMB), gia, ngayBatDau, ngayKetThuc);
            list.add(matBang);
        }
        return list;
    }

    @Override
    public List<MatBang> findAll() {
        List<MatBang> list = new ArrayList<>();
        String sql = "CAll findAll()";
        Connection connection = baseRepository.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            list = toList(resultSet);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<LoaiMatBang> findAllLoaiMatBang() {
        List<LoaiMatBang> list = new ArrayList<>();
        String sql = "CAll findAllLoaiMatBang()";
        Connection connection = baseRepository.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int ma_lmb = resultSet.getInt("ma_lmb");
                String ten_lmb = resultSet.getString("ten_lmb");
                list.add(new LoaiMatBang(ma_lmb, ten_lmb));
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<MatBang> Search(int idLoaiTrangThai) {
        List<MatBang> list = new ArrayList<>();
        String sql = "CAll Search(?)";
        Connection connection = baseRepository.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idLoaiTrangThai);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = toList(resultSet);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public MatBang findById(String maMB) {
        return null;
    }

    @Override
    public void save(MatBang matBang) {

    }

    @Override
    public boolean delete(String maMB) {
        return false;
    }

}
