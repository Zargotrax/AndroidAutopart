package com.xample.androidautopart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xample.androidautopart.ui.product.Product;
import com.xample.androidautopart.ui.product.ProductFragment;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> dataset;
    protected Context context;

    public static final String ID = "com.example.myfirstapp.ID";

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        protected TextView productName;
        protected TextView productCode;
        protected TextView productPrice;


        public ProductViewHolder(@NonNull View v) {
            super(v);

            productName = v.findViewById(R.id.txtView_Name);
            productCode = v.findViewById(R.id.txtView_Code);
            productPrice = v.findViewById(R.id.txtView_UnitPrice);
            context = v.getContext();
        }
    }
    public ProductAdapter(@NonNull List<Product> myDataset) {
        dataset = myDataset;
    }

    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_card, parent, false);

        view.setOnClickListener(cardOnClickListener);

        return new ProductViewHolder(view);
    }

    public final View.OnClickListener cardOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int itemPosition = ProductFragment.recyclerView.getChildLayoutPosition(view);
            //JSONObject item = dataset.get(itemPosition);
            Product p = new Product();
            Intent intent = new Intent(ProductFragment.activity, ProductDetailActivity.class);
            intent.putExtra(ID, p);
            context.startActivity(intent);
        }
    };

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        for(int i = 0; i < dataset.size(); i++){
            try{

                holder.productName.setText((dataset.get(i)).title);
                holder.productCode.setText((dataset.get(i)).code);
                holder.productPrice.setText((dataset.get(i)).unitPrice);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}