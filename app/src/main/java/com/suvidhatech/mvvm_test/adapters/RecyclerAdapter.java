package com.suvidhatech.mvvm_test.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.suvidhatech.mvvm_test.R;
import com.suvidhatech.mvvm_test.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {


    private List<NicePlace> mNicePlaces = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context context, List<NicePlace> nicePlaces) {
        mNicePlaces = nicePlaces;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        myViewHolder vh = new myViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        // Set the name of the 'NicePlace'
        holder.onBind(mNicePlaces.get(position));
        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mNicePlaces.get(position).getImageUrl())
                .into(((myViewHolder) holder).mImage);
    }


    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView mImage;
        private TextView mName;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.image_name);
        }

        public void onBind(NicePlace nPlace) {
            mName.setText(nPlace.getTitle());

        }
    }
}
