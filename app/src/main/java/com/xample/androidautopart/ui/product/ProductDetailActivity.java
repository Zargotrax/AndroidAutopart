package com.xample.androidautopart.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.xample.androidautopart.R;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView id;
    private TextView title;
    private TextView modelNo;
    private TextView code;
    private TextView unitPrice;
    private TextView inventory;
    private TextView supplierId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Intent intent = getIntent();
        Product p = (Product) intent.getSerializableExtra("produit");

        id = super.findViewById(R.id.txtView_idproduct);
        title = super.findViewById(R.id.txtView_title);
        modelNo = super.findViewById(R.id.txtView_modelNB);
        code = super.findViewById(R.id.txtView_code);
        unitPrice = super.findViewById(R.id.txtView_price);
        inventory = super.findViewById(R.id.txtView_inventory);
        supplierId = super.findViewById(R.id.txtView_supplierID);

        id.setText(p.id);
        title.setText(p.title);
        modelNo.setText(p.modelNo);
        code.setText(p.code);
        unitPrice.setText(p.unitPrice);
        inventory.setText(p.inventory);
        supplierId.setText(p.supplierID);

    }
}
