package com.xiaoke.accountsoft.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import patrickstar.com.accountms.R;

/**
 * Created by ios23 on 17/9/13.
 *
 * 注解：用来为ViewHolder类中的TextView和ImageView组件设置功能图标和说明性文字
 */

public class pictureAdapter extends BaseAdapter {

    private LayoutInflater inflater;//创建LayoutInflater对象

    private List<Picture> pictures;//创建图片数组

    public pictureAdapter(String[] titles, int[] images, Context context){
        super();
        pictures = new ArrayList<Picture>();

        inflater = LayoutInflater.from(context);//初始化LayoutInflater对象

        for(int i=0;i<images.length;i++)
        {
            Picture picture = new Picture(titles[i],images[i]);//把图片和标题放入Picture对象
            pictures.add(picture);//把Picture对象添加到数组中

        }
    }

    @Override
    public int getCount() {

        if(null!=pictures)
        {
            return pictures.size();//若不为空，返回数组长度
        }else {
            return 0;
        }

    }

    @Override
    public Object getItem(int arg0) {
        return pictures.get(arg0);//获取数组指定索引处的项
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {

        ViewHolder viewHolder;//创建ViewHolder对象
        if(arg1 == null){
            arg1 = inflater.inflate(R.layout.gvitem,null);//设置图像标识

            viewHolder = new ViewHolder();
            viewHolder.title=(TextView)arg1.findViewById(R.id.ItemTitle);
            viewHolder.image = (ImageView)arg1.findViewById(R.id.ItemImage);
            arg1.setTag(viewHolder);
        }
        else {

            viewHolder = (ViewHolder)arg1.getTag();
        }

        viewHolder.title.setText(pictures.get(arg0).getTitle());//设置图像标题
        viewHolder.image.setImageResource(pictures.get(arg0).getImageId());//设置图像的二进制
        return arg1;//返回图像
    }
}
