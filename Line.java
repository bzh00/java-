package com.sxt;

import java.awt.*;

public class Line {//绘制红线
    //起点坐标
    int x=350;
    int y=150;
    //终点坐标
    int endx=550;
    int endy=550;

    //线长
    double length=100;
    double n=0;
    //方向
    int dir=1;
    //状态0摇摆，1抓取，2收回,3抓取返回
    int statc;

    //钩爪图片
    Image hook=Toolkit.getDefaultToolkit().getImage("imgs/gz.png");

    GameWin frame;
    Line(GameWin frame){
        this.frame=frame;
    };


    //判断抓取
    void logic(){
        for(Object obj:this.frame.objectList)
        {
        if(endx>obj.x&&endx<obj.x+obj.weight&&
        endy>obj.y&&endy<obj.y+obj.height){
            statc=3;
            obj.flag=true;
        }
    }
    }
    //把绘制线的代码放进来
    void lines(Graphics g){
        endx=(int)(x+length*Math.cos(n*Math.PI));
        endy=(int)(y+length*Math.sin(n*Math.PI));
        g.setColor(Color.red);
        g.drawLine(x-1,y,endx-1,endy);
        g.drawLine(x,y,endx,endy);
        g.drawLine(x+1,y+1,endx,endy);
        g.drawImage(hook,endx-35,endy+2,null);
    }

    void painSelf(Graphics g){
        logic();
        switch (statc){
            case 0:
                if (n<0.1){
                    dir=1;
                }
                else if(n>0.9){
                    dir=-1;
                }
                n=n+0.005*dir;
                lines(g);
                break;
            case 1:
                if(length<500) {
                    length = length + 5;//延长线后重新绘制
                    lines(g);
                    break;
                }else
                {
                    statc=2;
                }
            case 2://收回线
                if(length>100) {
                    length = length - 5;
                    lines(g);
                }else{
                    statc=0;
                }
                break;
            case 3://碰到物品
                int m=1;
                if(length>100) {
                    length = length - 10;
                    lines(g);
                    for (Object obj:this.frame.objectList) {
                        //变化物品位置
                        if (obj.flag){
                            //抓取到后把质量传给他
                            m=obj.m;
                            obj.x = endx - obj.getWeight()/2;
                            obj.y = endy;
                            if(length<=100){
                                obj.x=-150;
                                obj.y=-150;
                                obj.flag=false;
                                //加分
                                Bg.count+=obj.count;
                                statc=0;
                        }

                        }
                    }
                }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;

        }



    }
}
