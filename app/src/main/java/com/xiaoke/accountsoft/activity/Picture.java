package com.xiaoke.accountsoft.activity;

/**
 * Created by ios23 on 17/9/13.\
 *
 * 注解：用来定义功能图标及说明文字的实体
 */

 class Picture {

    private String title;//定义字符串，表示图像标题
    private int imageId;//定义int变量，表示图像的二进制值

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //默认构造函数
    public Picture()
    {
        super();
    }


    //定义带参数的构造函数
    public Picture(String title, int imageId){
        super();
        this.imageId = imageId;
        this.title = title;

    }
}
