package com.xample.androidautopart.ui.supplier;

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

public class SupplierAdapter extends RecyclerView.Adapter<SupplierAdapter.SupplierViewHolder> {
    private List<Supplier> dataset;
    protected Context context;


    public class SupplierViewHolder extends RecyclerView.ViewHolder {
        protected TextView supplierName;
        protected TextView supplierTelephone;
        protected TextView supplierContact;


        public SupplierViewHolder(@NonNull View v) {
            super(v);

            supplierName = v.findViewById(R.id.txtView_Supplier_Name);
            supplierTelephone = v.findViewById(R.id.txtView_Supplier_Phone);
            supplierContact = v.findViewById(R.id.txtView_Supplier_Contact);
            context = v.getContext();
        }
    }
    public SupplierAdapter(@NonNull List<Supplier> myDataset) {
        dataset = myDataset;
    }

    @Override
    public SupplierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.supplier_card, parent, false);
        final SupplierViewHolder holder = new SupplierViewHolder(view);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int itemPosition = SupplierFragment.recyclerView.getChildLayoutPosition(view);
                //JSONObject item = dataset.get(itemPosition);
                Supplier s = dataset.get(itemPosition);
                Intent intent = new Intent(SupplierFragment.activity, SupplierDetailActivity.class);
                intent.putExtra("supplier", s);
                context.startActivity(intent);
            }
        });

        return new SupplierViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SupplierViewHolder holder, int position) {
        Supplier supplier = dataset.get(position);

            holder.supplierName.setText(supplier.name);
            holder.supplierTelephone.setText(supplier.telephone);
            holder.supplierContact.setText(supplier.contact);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}