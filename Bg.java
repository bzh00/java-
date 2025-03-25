package com.sxt;

import java.awt.*;

public class Bg {

    //总分
    static int count=0;
    Image bg=Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    Image tk=Toolkit.getDefaultToolkit().getImage("imgs/tk.jpg");
    Image r=Toolkit.getDefaultToolkit().getImage("imgs/r.png");

    void paintSelf(Graphics g)
    {
        g.drawImage(bg,0,150,null);
        g.drawImage(tk,0,-250,null);
        g.drawImage(r,350,130,null);


        //绘制分数表
        g.setColor(Color.BLACK);
        g.setFont(new Font("仿宋",Font.BOLD,30));
        g.drawString("积分:"+count,30,60);
    }
}
