package com.xample.androidautopart.ui.product;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xample.androidautopart.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> dataset;
    protected Context context;


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        protected TextView productName;
        protected TextView productCode;
        protected TextView productPrice;


        public ProductViewHolder(@NonNull View v) {
            super(v);

            productName = v.findViewById(R.id.txtView_Product_Name);
            productCode = v.findViewById(R.id.txtView_Product_Code);
            productPrice = v.findViewById(R.id.txtView_Product_UnitPrice);
            context = v.getContext();
        }
    }

    public ProductAdapter(@NonNull List<Product> myDataset) {
        this.dataset = myDataset;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.product_card, parent, false);
        final ProductViewHolder holder = new ProductViewHolder(view);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int itemPosition = ProductFragment.recyclerView.getChildLayoutPosition(view);
                //JSONObject item = dataset.get(itemPosition);
                Product p = dataset.get(itemPosition);
                Intent intent = new Intent(ProductFragment.activity, ProductDetailActivity.class);
                intent.putExtra("produit", p);
                context.startActivity(intent);
            }
        });
        return new ProductViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product produit = dataset.get(position);

        holder.productName.setText(produit.title);
        holder.productCode.setText(produit.code);
        holder.productPrice.setText(produit.unitPrice + "$");
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}