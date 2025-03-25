package com.sxt;

import java.awt.*;

public class Gold extends Object{

    boolean flag=false;
    Gold(){
        this.x=(int)(Math.random()*700);
        this.y=(int)(Math.random()*200+200);

        this.weight=52;
        this.height=52;
        this.flag=false;
        this.m=30;
        this.count=2;
        this.img= Toolkit.getDefaultToolkit().getImage("imgs/sw.png");
    }
}
