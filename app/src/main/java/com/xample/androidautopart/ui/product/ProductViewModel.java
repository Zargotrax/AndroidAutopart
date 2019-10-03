package com.xample.androidautopart.ui.product;

import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends ViewModel {


    public ProductAdapter adapter;
    public List<Product> listProduct;

    public ProductViewModel() {
        listProduct = new ArrayList<>();
        adapter = new ProductAdapter(listProduct);

    }

    public void GetList(JSONArray response){
        try{
            listProduct.clear();
            for(int i = 0; i < response.length(); i++){
                JSONObject res = response.getJSONObject(i);
                Product p = new Product();

                p.id = res.getString("id");
                p.title = res.getString("title");
                p.modelNo = res.getString("modelNo");
                p.code = res.getString("code");
                p.unitPrice = res.getString("unitPrice");
                p.inventory = res.getString("inventory");
                p.supplierID = res.getString("supplierId");

                listProduct.add(p);
                adapter.notifyDataSetChanged();
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}