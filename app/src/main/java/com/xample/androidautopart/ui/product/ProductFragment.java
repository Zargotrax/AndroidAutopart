package com.xample.androidautopart.ui.product;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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

public class ProductFragment extends Fragment {

    private ProductViewModel productViewModel;
    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public static FragmentActivity activity;
    public View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        root = inflater.inflate(R.layout.fragment_product, container, false);

        activity = getActivity();
        doRequest();

        recyclerView = root.findViewById(R.id.product_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(ProductViewModel.adapter);

        return root;
    }

    protected void doRequest() {
        RequestQueue queue = Volley.newRequestQueue(this.getContext());

        String url = "https://0bb1c3d7.ngrok.io/products";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        ProductViewModel.GetList(response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Context context = root.getContext();
                        CharSequence text = error.toString();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });
        queue.add(jsonArrayRequest);
    }
}