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

        qwe.setTitle("�Թ���Ϸ��ʣ��ʱ��Ϊ:"+count);
        mainf.me.xunhuan();
        jishi(qwe);


    }
public static void jishi(mainf qwe){
    while (count!=0){
        try {
            qwe.setTitle("�Թ���Ϸ��ʣ��ʱ��Ϊ:"+count);
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
    int opt = JOptionPane.showConfirmDialog(null, "�����Ƿ��ӳ�10�������Ϸ����ѡ�񡰷񡱽���ֱ���˳�", "��սʧ��",
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
