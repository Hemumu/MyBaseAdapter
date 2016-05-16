package com.example.admindiece.mybaseadapter.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admindiece.mybaseadapter.ViewHolder;

import java.util.List;

/**
 * Created by helin on 2016/5/13 11:21.
 */
public  abstract class MultiItemTypeAdapter<T> extends CommonAdapter<T>{
    private  MultiItemTypeSupport<T> mMultItemSupport;

    /**
     * @param ctx
     * @param layoutId
     * @param datas
     */
    public MultiItemTypeAdapter(Context ctx, int layoutId, List<T> datas, MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(ctx, layoutId, datas);
        this.mMultItemSupport=multiItemTypeSupport;
        if (mMultItemSupport == null)
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
    }

    @Override
    public int getViewTypeCount() {
        if (mMultItemSupport != null)
            return mMultItemSupport.getViewTypeCount();
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        if( mMultItemSupport!=null )
            return  mMultItemSupport.getItemViewType(position,mDatas.get(position));
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mMultItemSupport == null)
            return super.getView(position, convertView, parent);
        int layoutId = mMultItemSupport.getLayoutId(position, getItem(position));

        ViewHolder viewHolder = ViewHolder.getViewHolder(mContext, convertView, parent,
                layoutId, position);
        convert(viewHolder, getItem(position));
        return viewHolder.getConvertView();
    }
}
