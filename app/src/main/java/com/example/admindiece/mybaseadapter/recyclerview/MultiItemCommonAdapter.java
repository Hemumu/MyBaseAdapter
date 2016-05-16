package com.example.admindiece.mybaseadapter.recyclerview;

import android.content.Context;
import android.view.ViewGroup;

import com.example.admindiece.mybaseadapter.ViewHolder;

import java.util.List;

/**
 * Created by helin on 2016/5/13 14:25.
 */
public abstract class MultiItemCommonAdapter<T> extends CommentAdapter<T> {

    protected  MultiItemTypeSupport<T> mMultiItemTypeSupport;

    public MultiItemCommonAdapter(Context ctx, List<T> datas,MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(ctx, -1, datas);
        this.mMultiItemTypeSupport=multiItemTypeSupport;
    }



    @Override
    public int getItemViewType(int position) {
        if (mMultiItemTypeSupport != null)
            return mMultiItemTypeSupport.getItemViewType(position, mDatas.get(position));
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mMultiItemTypeSupport == null) return super.onCreateViewHolder(parent, viewType);
        int layoutId = mMultiItemTypeSupport.getLayoutId(viewType);
        ViewHolder holder = ViewHolder.getViewHolder(mContext, null, parent, layoutId, -1);
        return holder;
    }
}
