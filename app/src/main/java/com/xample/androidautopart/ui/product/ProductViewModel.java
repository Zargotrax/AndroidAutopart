package com.xample.androidautopart.ui.product;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xample.androidautopart.ProductAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public static ProductAdapter adapter;

    public ProductViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public static void GetList(JSONArray response){
        List<JSONObject> listJson = new ArrayList<JSONObject>();
        try{
            for(int i = 0; i < response.length(); i++){
                JSONObject res = response.getJSONObject(i);
                listJson.add(res);
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        adapter = new ProductAdapter(listJson);
        adapter.notifyDataSetChanged();
    }

    public LiveData<String> getText() {
        return mText;
    }


}