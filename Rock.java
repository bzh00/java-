package com.sxt;

import java.awt.*;

public class Rock extends Object{
    Rock(){
        this.x=(int)(Math.random()*700);
        this.y=(int)(Math.random()*200+200);

        this.weight=52;
        this.height=52;
        this.flag=false;
        this.m=150;
        this.count-=4;
        this.img= Toolkit.getDefaultToolkit().getImage("imgs/xc.png");
    }
}
