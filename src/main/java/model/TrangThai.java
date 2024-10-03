package model;

public class TrangThai {
    private int maTT;
    private String tenTT;

    public TrangThai() {
    }

    public TrangThai(int maTT, String tenTT) {
        this.maTT = maTT;
        this.tenTT = tenTT;
    }

    public int getMaTT() {
        return maTT;
    }
    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }
    public String getTenTT() {
        return tenTT;
    }
    public void setTenTT(String tenTT) {
        this.tenTT = tenTT;
    }
}
