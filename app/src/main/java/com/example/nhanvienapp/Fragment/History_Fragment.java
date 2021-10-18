package com.example.nhanvienapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhanvienapp.Adapter.History_Adapter;
import com.example.nhanvienapp.Model.Invoice;
import com.example.nhanvienapp.R;

import java.util.ArrayList;

public class History_Fragment extends Fragment {

    private RecyclerView recyclerview_history;
    private LinearLayoutManager layoutManager;
    private ArrayList<Invoice> data = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Lịch sử đơn đặt hàng");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerview_history = view.findViewById(R.id.recyclerview_history);

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
                "26/07/2021",
                "Đã nhận hàng"));
        data.add(new Invoice(
                002,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "Nguyễn Trường An",
                1,
                295.000,
                "26/07/2021",
                "Đã hủy"));
        data.add(new Invoice(
                003,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "Nguyễn Trường An",
                1,
                295.000,
                "26/07/2021",
                "Đã nhận hàng"));
    }

    private void setUpRecycleView()
    {
        History_Adapter adapter = new History_Adapter(data);
        recyclerview_history.setHasFixedSize(true);
        recyclerview_history.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerview_history.setLayoutManager(layoutManager);
    }
}