package com.example.nhanvienapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Invoice_Adapter extends RecyclerView.Adapter<Invoice_Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Invoice> data;

    public Invoice_Adapter(Context context, ArrayList<Invoice> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Invoice_Adapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_invoice, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tenSanPham.setText(data.get(position).getTenSanPham());
        holder.tenKhachHang.setText(data.get(position).getTenKhachHang());
        holder.maHoaDon.setText(data.get(position).getMaHoaDon().toString());
        holder.soLuong.setText(data.get(position).getSoLuong().toString());
        holder.giaTien.setText(data.get(position).getGiaTien().toString());
        holder.ngayMua.setText(data.get(position).getNgayMua());
//        holder.ngayMua.setText(parseDate(data.get(position).getNgayMua()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView maHoaDon, tenSanPham, tenKhachHang, soLuong, giaTien, ngayMua;
        Button btnSuccess;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            maHoaDon = itemView.findViewById(R.id.txt_invoiceId);
            tenSanPham = itemView.findViewById(R.id.txt_invoice_product_name);
            tenKhachHang = itemView.findViewById(R.id.txt_invoice_customer_name);
            soLuong = itemView.findViewById(R.id.txt_invoice_quantity);
            giaTien = itemView.findViewById(R.id.txt_invoice_price);
            ngayMua = itemView.findViewById(R.id.txt_invoice_date);
            btnSuccess = itemView.findViewById(R.id.btn_invoice);

            btnSuccess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new SweetAlertDialog(context)
                            .setTitleText("Đã xác nhận!")
                            .show();
                }
            });
        }
    }

    private String parseDate(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String formattedDate = "";
        formattedDate = df.format(date);
        return formattedDate;
    }
}
