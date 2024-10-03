package model;

import java.sql.Date;

public class MatBang {
    private String maMB;
    private TrangThai trangThai;
    private int dienTich;
    private int tang;
    private LoaiMatBang loai;
    private int gia;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public MatBang() {
    }

    public MatBang(String maMB, TrangThai trangThai, int dienTich, int tang, LoaiMatBang loai, int gia, Date ngayBatDau, Date ngayKetThuc) {
        this.maMB = maMB;
        this.trangThai = trangThai;
        this.dienTich = dienTich;
        this.tang = tang;
        this.loai = loai;
        this.gia = gia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaMB() {
        return maMB;
    }
    public void setMaMB(String maMB) {
        this.maMB = maMB;
    }
    public TrangThai getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }
    public int getDienTich() {
        return dienTich;
    }
    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }
    public int getTang() {
        return tang;
    }
    public void setTang(int tang) {
        this.tang = tang;
    }
    public LoaiMatBang getLoai() {
        return loai;
    }
    public void setLoai(LoaiMatBang loai) {
        this.loai = loai;
    }
    public int getGia() {
        return gia;
    }
    public void setGia(int gia) {
        this.gia = gia;
    }
    public Date getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
