package com.sxt;

import java.awt.*;

public class Object {
    //坐标
    int x;
    int y;
    //宽高
    int weight;
    int height;
    //图片
    Image img;
    //标记是否能移动
    boolean flag;

    //添加质量属性
    int m;

    //积分
    int count;


    void paintSelf(Graphics g){
        g.drawImage(img,x,y,null);
    }
    public int getWeight(){
        return weight;
    }

    //获取矩形
    public Rectangle getRec(){
        return new Rectangle(x,y,weight,height);
    }
}
