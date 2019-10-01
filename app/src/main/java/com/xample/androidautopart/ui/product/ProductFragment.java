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
import com.xample.androidautopart.R;

import org.json.JSONArray;

public class ProductFragment extends Fragment {

    private  ProductViewModel productViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private View contx;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productViewModel =
                ViewModelProviders.of(this).get(ProductViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        doRequest();

        recyclerView = root.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        //mAdapter = new ProductAdapter(ProductViewModel.GetList());
        recyclerView.setAdapter(ProductViewModel.adapter);

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
                        //Create a list of JSONObject and the go through the response to add them to the list, then pass it to the adapter
                        ProductViewModel.GetList(response);
//                        List<JSONObject> listJson = new ArrayList<JSONObject>();
//                        try{
//                            for(int i = 0; i < response.length(); i++){
//                                JSONObject res = response.getJSONObject(i);
//                                listJson.add(res);
//                            }
//                        } catch (JSONException e){
//                            e.printStackTrace();
//                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);
    }
}