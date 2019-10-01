package com.xample.androidautopart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<JSONObject> dataset;


    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        protected static TextView productName;
        protected static TextView productCode;
        protected static TextView productPrice;


        public ProductViewHolder(@NonNull View v) {
            super(v);

            productName = v.findViewById(R.id.txtView_Name);
            productCode = v.findViewById(R.id.txtView_Code);
            productPrice = v.findViewById(R.id.txtView_UnitPrice);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductAdapter(@NonNull List<JSONObject> myDataset) {
        dataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_card, parent, false);

        return new ProductViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        for(int i = 0; i < dataset.size(); i++){
            try{
                holder.productName.setText((dataset.get(i)).getString("title"));
                holder.productCode.setText((dataset.get(i)).getString("code"));
                holder.productPrice.setText((dataset.get(i)).getString("unitPrice"));

            } catch (JSONException e){
                e.printStackTrace();
            }
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 3;//dataset.size();
    }
}