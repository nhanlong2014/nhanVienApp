package com.example.nhanvienapp.Model;

import java.util.Date;

public class Invoice {

    private Integer maHoaDon;
    private String tenSanPham;
    private String tenKhachHang;
    private Integer soLuong;
    private Double giaTien;
    private String ngayMua;
    private String trangThai;
    //    private Date ngayMua;

    public Invoice() {
    }

    public Invoice(Integer maHoaDon, String tenSanPham, String tenKhachHang, Integer soLuong, Double giaTien, String ngayMua) {
        this.maHoaDon = maHoaDon;
        this.tenSanPham = tenSanPham;
        this.tenKhachHang = tenKhachHang;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.ngayMua = ngayMua;
    }

    public Invoice(Integer maHoaDon, String tenSanPham, String tenKhachHang, Integer soLuong, Double giaTien, String ngayMua, String trangThai) {
        this.maHoaDon = maHoaDon;
        this.tenSanPham = tenSanPham;
        this.tenKhachHang = tenKhachHang;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.ngayMua = ngayMua;
        this.trangThai = trangThai;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getTrangThai() {
        return trangThai;
    }
}
