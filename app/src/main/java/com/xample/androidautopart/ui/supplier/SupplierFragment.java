package com.xample.androidautopart.ui.supplier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xample.androidautopart.R;

public class SupplierFragment extends Fragment {

    private SupplierViewModel supplierViewModel;
    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public static FragmentActivity activity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        supplierViewModel =
                ViewModelProviders.of(this).get(SupplierViewModel.class);
        View root = inflater.inflate(R.layout.fragment_suppliers, container, false);

        activity = getActivity();
        doRequest();

        recyclerView = root.findViewById(R.id.supplier_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(SupplierViewModel.adapter);

        return root;
    }
}