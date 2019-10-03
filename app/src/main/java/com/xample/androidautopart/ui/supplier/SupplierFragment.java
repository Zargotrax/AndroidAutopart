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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.xample.androidautopart.R;

import org.json.JSONArray;

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

    protected void doRequest() {
        RequestQueue queue = Volley.newRequestQueue(this.getContext());

        String url = "https://f6eb04bb.ngrok.io/suppliers";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        SupplierViewModel.GetList(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        queue.add(jsonArrayRequest);
    }
}