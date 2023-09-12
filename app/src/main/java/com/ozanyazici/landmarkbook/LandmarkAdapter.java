package com.ozanyazici.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ozanyazici.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    //ViewHolder sınıfından nesne oluşturulduğunda çağrılacak metot. XML i bağlama işlemini burda yapıcaz.
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    //Layout içerisinde hangi verileri göstermek istiyorsak burda göstericez.
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(holder.getAdapterPosition()).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bir activite içinde olmadığımız için Context i getirmek için getContext yazdım.
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
               //intent.putExtra("landmark",landmarkArrayList.get(holder.getAdapterPosition()));
                Singleton singleton = Singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    //Kaç tane xml oluşturulacağını dödüren metod bizim şuan 4 tane var.
    public int getItemCount() {
        //Lİstenin uzunluğunu almak için Constructor yazdım.
        return landmarkArrayList.size();
    }

    //Görünümlerimizi tutacak olan sınıf.
    public class LandmarkHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
