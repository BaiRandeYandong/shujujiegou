import javax.swing.*;


public class main {
   public static boolean media = true;
static     media lost = new media(".\\music\\shibai.wav");
    public static int count = 50;
    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 4, 3, 3, 3, 3, 3, 3, 3},
                {3, 3, 4, 3, 4, 3, 4, 4, 4, 3},
                {3, 3, 4, 3, 4, 3, 3, 3, 4, 3},
                {3, 3, 4, 3, 4, 4, 4, 3, 4, 3},
                {3, 3, 4, 3, 3, 3, 4, 3, 4, 3},
                {3, 3, 4, 4, 4, 3, 4, 3, 4, 3},
                {3, 3, 3, 3, 4, 3, 4, 3, 4, 4},
                {3, 3, 4, 4, 4, 3, 4, 3, 4, 3},
                {3, 4, 4, 4, 4, 2, 4, 3, 4, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
        };
      mainf qwe =  new mainf(a);

        qwe.setTitle("迷宫游戏，剩余时间为:"+count);
        mainf.me.xunhuan();
        jishi(qwe);


    }
public static void jishi(mainf qwe){
    while (count!=0){
        try {
            qwe.setTitle("迷宫游戏，剩余时间为:"+count);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count--;
    }
shibai(qwe);
}
public static void shibai(mainf qwe){
        mainf.me.stop();
        lost.xunhuan();
    int opt = JOptionPane.showConfirmDialog(null, "请问是否延长10秒继续游戏？若选择“否”将会直接退出", "挑战失败",
            JOptionPane.YES_NO_OPTION);
    if (opt == JOptionPane.YES_OPTION) {
        count=10;
        lost.stop();
        mainf.me.xunhuan();
        jishi(qwe);
    }else{
        System.exit(114514);
    }
}
}
