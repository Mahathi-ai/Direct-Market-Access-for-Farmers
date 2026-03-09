package com.example.cropconnect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CropAdapter extends RecyclerView.Adapter<CropAdapter.ViewHolder> {

    Context context;
    ArrayList<Crop> cropList;
    DatabaseHelper dbHelper;
    boolean isFarmer;

    public CropAdapter(Context context, ArrayList<Crop> cropList, boolean isFarmer) {
        this.context = context;
        this.cropList = cropList;
        this.isFarmer = isFarmer;
        dbHelper = new DatabaseHelper(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, price;
        Button editBtn, deleteBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.cropNameText);
            price = itemView.findViewById(R.id.cropPriceText);
            editBtn = itemView.findViewById(R.id.editBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_crop, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Crop crop = cropList.get(position);

        holder.name.setText(crop.getName());
        holder.price.setText("Price: " + crop.getPrice());

        // Buyer tap → call farmer
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + crop.getPhone()));
            context.startActivity(intent);
        });

        if(isFarmer){

            holder.editBtn.setVisibility(View.VISIBLE);
            holder.deleteBtn.setVisibility(View.VISIBLE);

            holder.deleteBtn.setOnClickListener(v -> {

                dbHelper.deleteCrop(crop.getId());

                cropList.remove(position);
                notifyDataSetChanged();
            });

            holder.editBtn.setOnClickListener(v -> {

                Intent intent = new Intent(context, EditCropActivity.class);
                intent.putExtra("id", crop.getId());
                intent.putExtra("name", crop.getName());
                intent.putExtra("price", crop.getPrice());
                intent.putExtra("phone", crop.getPhone());

                context.startActivity(intent);
            });

        } else {

            holder.editBtn.setVisibility(View.GONE);
            holder.deleteBtn.setVisibility(View.GONE);

        }
    }

    @Override
    public int getItemCount() {
        return cropList.size();
    }
}
