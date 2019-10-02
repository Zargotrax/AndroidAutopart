package com.xample.androidautopart.ui.product;

import androidx.lifecycle.ViewModel;

import com.xample.androidautopart.ProductAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends ViewModel {


    public static ProductAdapter adapter;

    public ProductViewModel() {
        //This is the contructor tb added
    }

    public static void GetList(JSONArray response){
        List<Product> listProduct = new ArrayList<>();
        try{
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
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        adapter = new ProductAdapter(listProduct);
        adapter.notifyDataSetChanged();
    }

}