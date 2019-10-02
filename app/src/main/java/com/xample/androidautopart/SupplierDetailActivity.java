package com.xample.androidautopart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.xample.androidautopart.ui.supplier.Supplier;

public class SupplierDetailActivity extends AppCompatActivity {

    private TextView id;
    private TextView name;
    private TextView adl1;
    private TextView adl2;
    private TextView adct;
    private TextView adpr;
    private TextView adpc;
    private TextView telephone;
    private TextView contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_detail);

        Intent intent = getIntent();
        Supplier s = (Supplier) intent.getSerializableExtra("supplier");

        id = super.findViewById(R.id.txtView_id);
        name = super.findViewById(R.id.txtView_name);
        adl1 = super.findViewById(R.id.txtView_ad1);
        adl2 = super.findViewById(R.id.txtView_ad2);
        adct = super.findViewById(R.id.txtView_adct);
        adpr = super.findViewById(R.id.txtView_adpr);
        adpc = super.findViewById(R.id.txtView_adpc);
        telephone = super.findViewById(R.id.txtView_telephone);
        contact = super.findViewById(R.id.txtView_contact);

        id.setText(s.id);
        name.setText(s.name);
        adl1.setText(s.address_line_1);
        adl2.setText(s.address_line_2);
        adct.setText(s.address_city);
        adpr.setText(s.address_province);
        adpc.setText(s.address_postal_code);
        telephone.setText(s.telephone);
        contact.setText(s.contact);
    }
}
