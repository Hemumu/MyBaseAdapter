package com.example.admindiece.mybaseadapter.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.admindiece.mybaseadapter.ViewHolder;

import java.util.List;

/**
 * 常见的Adapter
 *
 * Created by helin on 2016/5/13 10:54.
 */
public abstract class CommonAdapter<T> extends BaseAdapter{


    protected  Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private int layoutId;

    /**
     * @param ctx
     * @param layoutId
     * @param datas
     */
    public CommonAdapter( Context ctx,int layoutId,List<T> datas){
        this.mContext =ctx;
        mInflater = LayoutInflater.from(ctx);
        this.mDatas = datas;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getViewHolder(mContext, convertView, parent,
                layoutId, position);
        convert(holder, getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T t);
}
