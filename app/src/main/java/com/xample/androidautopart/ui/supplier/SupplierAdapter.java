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
import com.xample.androidautopart.ui.supplier.Supplier;
import com.xample.androidautopart.ui.supplier.SupplierDetailActivity;
import com.xample.androidautopart.ui.supplier.SupplierFragment;

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

            supplierName = v.findViewById(R.id.txtView_name);
            supplierTelephone = v.findViewById(R.id.txtView_telephone);
            supplierContact = v.findViewById(R.id.txtView_contact);
            context = v.getContext();
        }
    }
    public SupplierAdapter(@NonNull List<Supplier> myDataset) {
        dataset = myDataset;
    }

    @Override
    public SupplierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.supplier_card, parent, false);

        view.setOnClickListener(cardOnClickListener);

        return new SupplierViewHolder(view);
    }

    public final View.OnClickListener cardOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int itemPosition = SupplierFragment.recyclerView.getChildLayoutPosition(view);
            //JSONObject item = dataset.get(itemPosition);
            Supplier s = new Supplier();
            Intent intent = new Intent(SupplierFragment.activity, SupplierDetailActivity.class);
            intent.putExtra("supplier", s);
            context.startActivity(intent);
        }
    };

    @Override
    public void onBindViewHolder(SupplierViewHolder holder, int position) {
        for(int i = 0; i < dataset.size(); i++){
            try{

                holder.supplierName.setText((dataset.get(i)).name);
                holder.supplierTelephone.setText((dataset.get(i)).telephone);
                holder.supplierContact.setText((dataset.get(i)).contact);
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