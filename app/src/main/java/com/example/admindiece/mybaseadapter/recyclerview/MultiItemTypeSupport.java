package com.example.admindiece.mybaseadapter.recyclerview;

import android.content.Context;

import java.util.List;

/**
 * Created by helin on 2016/5/13 14:20.
 */
public interface MultiItemTypeSupport<T>{

    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);

}
