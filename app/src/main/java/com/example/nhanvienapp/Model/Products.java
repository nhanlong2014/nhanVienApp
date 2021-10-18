package com.example.nhanvienapp.Model;

public class Products {

    private Integer maSanPham;
    private String tenSanPham;
    private String hinhSanPham;
    private Integer soLuong;
    private Double giaTien;

    public Products() {
    }

    public Products(Integer maSanPham, String tenSanPham, String hinhSanPham, Integer soLuong, Double giaTien) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.hinhSanPham = hinhSanPham;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getHinhSanPham() {
        return hinhSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public Double getGiaTien() {
        return giaTien;
    }

}
