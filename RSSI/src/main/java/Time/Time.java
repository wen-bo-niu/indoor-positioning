package Time;

import Dao.Dao;
import KNN.KNNFind;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Time {

    private String result;
    public String start() {
        Calendar date = Calendar.getInstance();
        //设置固定开始时间为 00:00:00
        date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 0, 0, 0);
        long daymin = 1000;//5秒
        //得到定时器实例
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            public void run() {
                Dao dao = new Dao();
                String daoRSSI = dao.getRSSI();
                KNNFind find = new KNNFind();
                result = "X:" + find.choose(daoRSSI).get(0).getX() + ",Y:" + find.choose(daoRSSI).get(0).getY() +
                        ",type:" + find.choose(daoRSSI).get(0).getType() + ",rate:" + find.choose(daoRSSI).get(0).getCmp();
                System.out.println(result);
                System.out.println(daoRSSI);
            }
        }, date.getTime(), daymin); //date.getTime()为上面赋值的00:00:00，daymin是执行间隔
        return result;
    }

    private JLabel getLabel() {
        JLabel label = null;
        if (label == null) {
            label = new JLabel(" ");
            label.setLocation(200,50);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.CENTER);
            label.setFont(new Font("微软雅黑", Font.BOLD, 80));
            label.setForeground(new Color(182, 229, 248));

            Calendar date = Calendar.getInstance();
            //设置固定开始时间为 00:00:00
            date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 0, 0, 0);
            long daymin = 1000;//5秒
            //得到定时器实例
            Timer time = new Timer();
            JLabel finalLabel = label;
            time.schedule(new TimerTask() {
                public void run() {
                    Dao dao = new Dao();
                    String daoRSSI = dao.getRSSI();
                    KNNFind find = new KNNFind();
                    result = "X:" + find.choose(daoRSSI).get(0).getX() + ",Y:" + find.choose(daoRSSI).get(0).getY() +
                            ",type:" + find.choose(daoRSSI).get(0).getType() + ",rate:" + find.choose(daoRSSI).get(0).getCmp();
                    if (find.choose(daoRSSI).get(0).getX() == 0) {
                        result = "卧室";
                    } else if (find.choose(daoRSSI).get(0).getX() == 10) {
                        result = "客厅";
                    }else if (find.choose(daoRSSI).get(0).getX() == 20){
                        result="阳台";
                    }
                    finalLabel.setText(result);
                }
            }, date.getTime(), daymin); //date.getTime()为上面赋值的00:00:00，daymin是执行间隔

        }
        return label;

    }

    public void show(){
        JFrame jFrame=new JFrame();
        jFrame.setBounds(150,50,500,500);
        jFrame.add(getLabel());
        jFrame.setVisible(true);
    }


}