
package com.example.vikas.NewsApp.adpter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.vikas.NewsApp.R;
import com.example.vikas.NewsApp.pojo.Sources;


import java.util.List;


public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    private List<Sources> dataList;
    Context context;

    public NoticeAdapter(List<Sources> dataList, Context context) {
        this.context = context;
        this.dataList = dataList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtNoticeTitle.setText(dataList.get(position).getTitle());
        holder.txtNoticeBrief.setText(dataList.get(position).getDescription());
        holder.txtNoticeFilePath.setText("Read More ");
        holder.txtNoticeFilePath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(dataList.get(position).getUrl()));
                context.startActivity(browserIntent);
            }
        });


        if (dataList.get(position).getUrlToImage() != null &&
                !dataList.get(position).getUrlToImage().equals("")) {
            Glide.with(context)
                    .load(dataList.get(position).getUrlToImage())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            holder.mProgress.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            // holder.mProgress.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(holder.img);
        } else {
            holder.mProgress.setVisibility(View.GONE);
            holder.frameimg.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNoticeTitle, txtNoticeBrief, txtNoticeFilePath;
        FrameLayout frameimg;
        ImageView img;
        private ProgressBar mProgress;
        ViewHolder(View itemView) {
            super(itemView);
            txtNoticeTitle = itemView.findViewById(R.id.txt_notice_title);
            txtNoticeBrief = itemView.findViewById(R.id.txt_notice_brief);
            txtNoticeFilePath = itemView.findViewById(R.id.txt_notice_file_path);
            frameimg = itemView.findViewById(R.id.frameimg);
            img = itemView.findViewById(R.id.img);
            mProgress = (ProgressBar) itemView.findViewById(R.id.progress);

        }
    }
}
