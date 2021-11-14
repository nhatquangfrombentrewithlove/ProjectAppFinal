package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.BlogList;
import com.example.model.ChooseList;
import com.example.projectapp.R;

import java.util.ArrayList;

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.ViewHolder> {
    Context context;
    ArrayList<BlogList> blogLists;

    public BlogListAdapter(Context context, ArrayList<BlogList> blogList) {
        this.context = context;
        this.blogLists = blogList;
    }


    @NonNull

    @Override
    public BlogListAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.custom_blog_offer, parent, false);
        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogListAdapter.ViewHolder holder, int position) {
        holder.imvDeXuatBlog.setImageResource(blogLists.get(position).getImvDeXuatBlog());
        holder.txtTitleBlog.setText(blogLists.get(position).getTxtTitleBlog());
        holder.txtSubBlog.setText(blogLists.get(position).getTxtSubBlog());
        holder.txtTacGia.setText(blogLists.get(position).getTxtTacGia());
        holder.txtTimeRead.setText(blogLists.get(position).getTxtTimeRead());
    }

    @Override
    public int getItemCount(){
        return blogLists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvDeXuatBlog;
        TextView txtTitleBlog, txtSubBlog, txtTacGia, txtTimeRead;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imvDeXuatBlog = itemView.findViewById(R.id.imvDeXuatBlog);
            txtTitleBlog = itemView.findViewById(R.id.txtTitleBlog);
            txtSubBlog = itemView.findViewById(R.id.txtSubBlog);
            txtTacGia = itemView.findViewById(R.id.txtTacGia);
            txtTimeRead = itemView.findViewById(R.id.txtTimeRead);
        }
    }

}
