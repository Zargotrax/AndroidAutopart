package com.xample.androidautopart.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.xample.androidautopart.ProductAdapter;
import com.xample.androidautopart.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class ProductFragment extends Fragment {

    private ProductViewModel galleryViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private View contx;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(ProductViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        recyclerView = (RecyclerView) root.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ProductAdapter(/*new List<JSONObject>()*/);
        recyclerView.setAdapter(mAdapter);

        contx = root;
        return root;


    }

    protected void doRequest() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this.getContext());

        String url = "https://f6eb04bb.ngrok.io//suppliers";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        ProductViewModel.GetList(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ProductViewModel.GetList(null);
                    }
                });


        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);
    }
}