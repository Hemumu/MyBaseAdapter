package com.example.admindiece.mybaseadapter.listview;

/**
 * ListView多种Item支持类
 *
 * Created by helin on 2016/5/13 11:17.
 */
public interface  MultiItemTypeSupport<T> {
    int getLayoutId(int position, T t);

    int getViewTypeCount();

    int getItemViewType(int position, T t);
}

