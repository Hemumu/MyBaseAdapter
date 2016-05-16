package com.example.admindiece.mybaseadapter.recyclerview;

/**
 * Created by helin on 2016/5/13 16:07.
 */
public interface  SectionSupport<T> {
    public int sectionHeaderLayoutId();
    public int sectionTitleTextViewId();
    public String getTitle(T t);

}
