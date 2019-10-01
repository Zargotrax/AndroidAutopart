package com.xample.androidautopart.ui.product;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProductViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public static JSONArray GetList(JSONArray response ){
        try{
            for(int i = 0; i < response.length(); i++){
                JSONObject res = response.getJSONObject(i);
                String title = res.getString("title");
                String modelNo = res.getString("modelNo");
                String code = res.getString("code");
            }
            return response;
        } catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

    public LiveData<String> getText() {
        return mText;
    }


}