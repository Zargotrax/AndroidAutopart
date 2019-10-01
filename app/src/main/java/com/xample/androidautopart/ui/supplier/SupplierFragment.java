package com.xample.androidautopart.ui.supplier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.xample.androidautopart.R;

public class SupplierFragment extends Fragment {

    private SupplierViewModel supplierViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        supplierViewModel =
                ViewModelProviders.of(this).get(SupplierViewModel.class);
        View root = inflater.inflate(R.layout.fragment_suppliers, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        supplierViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}