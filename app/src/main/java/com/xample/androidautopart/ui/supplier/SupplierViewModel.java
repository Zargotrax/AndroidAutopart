package com.xample.androidautopart.ui.supplier;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SupplierViewModel extends ViewModel {

    public static SupplierAdapter adapter;

    public SupplierViewModel() {
    }

    public static void GetList(JSONArray response){
        List<Supplier> listSupplier = new ArrayList<>();
        try{
            for(int i = 0; i < response.length(); i++){
                JSONObject res = response.getJSONObject(i);
                Supplier s= new Supplier();

                s.id = res.getString("id");
                s.name = res.getString("name");
                s.address_line_1 = res.getString("address_line_1");
                s.address_line_2 = res.getString("address_line_2");
                s.address_city = res.getString("address_city");
                s.address_province = res.getString("address_province");
                s.address_postal_code = res.getString("address_postal_code");
                s.telephone = res.getString("telephone");
                s.contact = res.getString("contact");

                listSupplier.add(s);
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        adapter = new SupplierAdapter(listSupplier);
        adapter.notifyDataSetChanged();
    }

}