package com.example.nhanvienapp.Model;

public class Categories {

    private Integer maLoaiSanPham;
    private String tenLoaiSanPham;

    public Categories() {
    }

    public Categories(Integer maLoaiSanPham, String tenLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public Integer getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }
}
