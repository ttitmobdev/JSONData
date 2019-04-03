package com.example.user.jsondata;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.jsondata.Model.Item;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Item> mItems;
    private Context context;
    private PostItemListener mItemListener;

    public Adapter(List<Item> items, Context context, PostItemListener mItemListener) {
        this.mItems = items;
        this.context = context;
        this.mItemListener = mItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View postView = layoutInflater.inflate(R.layout.custom_user,viewGroup,false);
        ViewHolder holder = new ViewHolder(postView,this.mItemListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Item item = mItems.get(i);
        viewHolder.title.setText(item.getOwner().getDisplayName());
        Uri uri = Uri.parse(item.getOwner().getProfileImage());
        Picasso.get().load(uri).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateAnswers(List<Item> items){
        mItems = items;
        notifyDataSetChanged();
    }

    public Item getItem(int adapterPosition){
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener{
        void onPostClick(long id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public ImageView image;
        PostItemListener mItemListener;
        public ViewHolder(@NonNull View itemView, PostItemListener postItemListener) {
            super(itemView);
            title = itemView.findViewById(R.id.nameId);
            image = itemView.findViewById(R.id.imageView);
            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Item item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getAnswerId());

            notifyDataSetChanged();
        }
    }
}
