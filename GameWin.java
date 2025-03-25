package com.sxt;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameWin extends JFrame{//窗口类

    //存储物品,集合
    List<Object> objectList=new ArrayList<>();


    Bg bg=new Bg();
    Line line =new Line(this);
    Image offSereenImage;
//在类中无法写循环，所以使用代码块
    {
        for (int i=0;i<5;i++){
            objectList.add(new Gold());
        }
        for (int i=0;i<3;i++){
            objectList.add(new Rock());
        }
    }


    void launch() throws InterruptedException {
        this.setVisible(true);//窗口是否可见
        this.setSize(764,700);//窗口大小
        this.setLocationRelativeTo(null);//设置窗口位置，这样就可以居中
        this.setTitle("黄金矿工");//设置标题

        //添加一个关闭窗口的方法
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //添加一个鼠标事件
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==1){
                    line.statc=1;
                }
            }
        });
        while(true){
            repaint();
            Thread.sleep(10);
        }

    }
    @Override
    public void paint(Graphics g) {

        offSereenImage=this.createImage(764,700);
        Graphics gImage=offSereenImage.getGraphics();
        bg.paintSelf(gImage);
        line.painSelf(gImage);
        for (Object obj:objectList)
        {
            obj.paintSelf(gImage);
        }
//        gold.paintSelf(gImage);
        g.drawImage(offSereenImage,0,0,null);

    }

    public static void main(String[] args) throws InterruptedException {
        GameWin gamewin=new GameWin();
        gamewin.launch();
    }
}
