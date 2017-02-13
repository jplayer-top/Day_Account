package com.oblivion.day_account.ui.fragment.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oblivion.day_account.R;
import com.oblivion.day_account.model.net.bean.NewsBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author:Created by Oblivion on 2017/2/13.
 * 功能描述:
 */

public class NewsFragmentViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView3)
    ImageView imageView3;

    public NewsFragmentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public static NewsFragmentViewHolder getHolder(Context mContext) {
        View itemView = View.inflate(mContext, R.layout.newsfragmentviewholder, null);
        return new NewsFragmentViewHolder(itemView);
    }

    public void bindData(NewsBean.ResultBean.DataBean dataBean, Context mContext) {
        title.setText(dataBean.title);
        date.setText(dataBean.date);
        Glide.with(mContext).load(dataBean.thumbnail_pic_s).placeholder(R.drawable.icon_null).error(R.drawable.icon_null).into(imageView);
        Glide.with(mContext).load(dataBean.thumbnail_pic_s02).placeholder(R.drawable.icon_null).error(R.drawable.icon_null).into(imageView2);
        Glide.with(mContext).load(dataBean.thumbnail_pic_s03).placeholder(R.drawable.icon_null).error(R.drawable.icon_null).into(imageView3);
    }

    @OnClick({R.id.title, R.id.date, R.id.imageView, R.id.imageView2, R.id.imageView3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title:
                break;
            case R.id.date:
                break;
            case R.id.imageView:
                break;
            case R.id.imageView2:
                break;
            case R.id.imageView3:
                break;
        }
    }
}
