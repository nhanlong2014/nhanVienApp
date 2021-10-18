package com.example.nhanvienapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhanvienapp.Adapter.Invoice_Adapter;
import com.example.nhanvienapp.Model.Invoice;
import com.example.nhanvienapp.R;

import java.util.ArrayList;

public class Invoice_Fragment extends Fragment {

    private RecyclerView recyclerView_invoice;
    private LinearLayoutManager layoutManager;
    private ArrayList<Invoice> data = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Hóa đơn mới");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invoice, container, false);
        recyclerView_invoice = view.findViewById(R.id.recyclerview_create_invoice);

        setData();
        setUpRecycleView();

        return view;
    }

    private void setData(){
        data.add(new Invoice(
                001,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "Nguyễn Trường An",
                1,
                295.000,
                "26/07/2021"));
        data.add(new Invoice(
                002,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "Nguyễn Trường An",
                1,
                295.000,
                "26/07/2021"));
        data.add(new Invoice(
                003,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "Nguyễn Trường An",
                1,
                295.000,
                "26/07/2021"));
    }

    private void setUpRecycleView(){
        Invoice_Adapter adapter = new Invoice_Adapter(getActivity(), data);
        recyclerView_invoice.setHasFixedSize(true);
        recyclerView_invoice.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView_invoice.setLayoutManager(layoutManager);
    }
}