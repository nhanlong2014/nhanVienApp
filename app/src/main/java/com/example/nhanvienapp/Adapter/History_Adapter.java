package com.example.nhanvienapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhanvienapp.Model.Invoice;
import com.example.nhanvienapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class History_Adapter extends RecyclerView.Adapter<History_Adapter.ViewHolder> {

    private ArrayList<Invoice> data;

    public History_Adapter(ArrayList<Invoice> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public History_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new History_Adapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, null));
    }

    @Override
    public void onBindViewHolder(@NonNull History_Adapter.ViewHolder holder, int position) {
        holder.tenSanPham.setText(data.get(position).getTenSanPham());
        holder.tenKhachHang.setText(data.get(position).getTenKhachHang());
        holder.maHoaDon.setText(data.get(position).getMaHoaDon().toString());
        holder.soLuong.setText(data.get(position).getSoLuong().toString());
        holder.giaTien.setText(data.get(position).getGiaTien().toString());
        holder.ngayMua.setText(data.get(position).getNgayMua());
        holder.trangThai.setText(data.get(position).getTrangThai());
//        holder.ngayMua.setText(parseDate(data.get(position).getNgayMua()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView maHoaDon, tenSanPham, tenKhachHang, soLuong, giaTien, ngayMua, trangThai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            maHoaDon = itemView.findViewById(R.id.txt_history_invoiceId);
            tenSanPham = itemView.findViewById(R.id.txt_history_product_name);
            tenKhachHang = itemView.findViewById(R.id.txt_history_customer_name);
            soLuong = itemView.findViewById(R.id.txt_history_quantity);
            giaTien = itemView.findViewById(R.id.txt_history_price);
            ngayMua = itemView.findViewById(R.id.txt_history_date);
            trangThai = itemView.findViewById(R.id.txt_history_state);
        }
    }

    private String parseDate(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String formattedDate = "";
        formattedDate = df.format(date);
        return formattedDate;
    }
}
