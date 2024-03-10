import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class mainf extends JFrame implements KeyListener {
  public  media shengli = new media(".\\music\\bang.wav");
  public static media me = new media(".\\music\\rabbit dance.wav");


    int x;int y;
    int now=3;
  public  static int [][] a ;


    mainf(int [][] a){

        this.a=a;
        this.setSize(760,760);//设置窗口
        this.setTitle("迷宫游戏");//设置标题
        //this.setAlwaysOnTop(true);//强制置顶
        this.setLocationRelativeTo(null);//居中
        this.setDefaultCloseOperation(3);//关闭方式为按叉号关闭
        this.setLayout(null);//布局方式修改


        JMenuBar jm = new JMenuBar();//设置菜单
        JMenu bianji = new JMenu("编辑");
        JMenu luj = new JMenu("路径检索");
        JMenuItem lu = new JMenuItem("检索并高亮所有路径");
        luj.add(lu);
        JMenu yan = new JMenu("延长时间");
        JMenu zuobi = new JMenu("作弊选项");
        JMenuItem sheng = new JMenuItem("直接获得胜利！");
        sheng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int shu = main.count;
                main.count=99999;
                me.stop();
                shengli.start();
                int opt = JOptionPane.showConfirmDialog(null, "请问是否继续游戏？", "恭喜通关！",
                        JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    main.count=shu;
                      me.xunhuan();
                }else{
                    System.exit(114514);
                }
            }
        });
        JMenuItem shang = new JMenuItem("将上方墙，路性质互换");
        JMenuItem xia = new JMenuItem("将下方墙，路性质互换");
        JMenuItem zuo = new JMenuItem("将左方墙，路性质互换");
        JMenuItem you = new JMenuItem("将右方墙，路性质互换");
        jm.add(zuobi);zuobi.add(shang);zuobi.add(xia);zuobi.add(zuo);zuobi.add(you);zuobi.add(sheng);
        shang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a[x-1][y]==3||a[x-1][y]==5){
                    a[x-1][y]=4;
                } else if (a[x-1][y]==4) {
                    a[x-1][y]=3;
                }
                shuaxin();
            }
        });
        zuo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a[x][y-1]==3||a[x][y-1]==5){
                    a[x][y-1]=4;
                } else if (a[x][y-1]==4) {
                    a[x][y-1]=3;
                }
                shuaxin();
            }
        });
        xia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a[x+1][y]==3||a[x+1][y]==5){
                    a[x+1][y]=4;
                } else if (a[x+1][y]==4) {
                    a[x+1][y]=3;
                }
                shuaxin();
            }
        });
        you.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a[x][y+1]==3||a[x][y+1]==5){
                    a[x][y+1]=4;
                } else if (a[x][y+1]==4) {
                    a[x][y+1]=3;
                }
                shuaxin();
            }
        });
        JMenuItem shi = new JMenuItem("延长10秒");
        JMenuItem sanshi = new JMenuItem("延长30秒");
        JMenuItem fen = new JMenuItem("延长60秒");
        JMenuItem wu = new JMenuItem("延长99999秒");
        JMenuItem gui = new JMenuItem("把时间变回一分钟");
       yan.add(shi);yan.add(sanshi);yan.add(fen);yan.add(wu);yan.add(gui);
       jm.add(yan);
       shi.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               main.count+=10;
           }
       });
       sanshi.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               main.count+=30;
           }
       });
       fen.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               main.count+=60;
           }
       });
       wu.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               main.count+=99999;
           }
       });
       gui.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               main.count=60;
           }
       });
        JMenu yin = new JMenu("音效设置");
        JMenuItem kai = new JMenuItem("开启音乐");
        JMenuItem guanb = new JMenuItem("关闭音乐");
        kai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.media=true;
                me.xunhuan();
            }
        });
        guanb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.media=false;
                me.stop();
            }
        });
       yin.add(kai);
       yin.add(guanb);
        lu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int [][] b =  ShortestPathFinder.han(a);
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j <10 ; j++) {
                        a[i][j]=b[i][j];
                    }
                }
                shuaxin();
            }
        });
      jm.add(bianji);jm.add(luj);jm.add(yin);

        JMenuItem zairu = new JMenuItem("载入数据");
        zairu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int shu=main.count;
                main.count=99999;//防止在读取时倒计时结束
                JFileChooser fileChooser = new JFileChooser();
                int [][] c = new int[10][10];
                // 设置默认的打开目录（如果需要）
                fileChooser.setCurrentDirectory(new File("."));

                // 显示文件选择器对话框
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // 获取所选文件路径
                    String selectedPath = fileChooser.getSelectedFile().getAbsolutePath();

                    try (BufferedReader reader = new BufferedReader(new FileReader(selectedPath))) {
                        String line;
                            for (int i = 0; i <10 ; i++) {
                                line = reader.readLine();
                                char [] arr = line.toCharArray();
                                // System.out.println(arr);
                                for (int j = 0; j < 10; j++) {
                                    a[i][j]= arr[j]-'0';
                                }
                            }
                            line = reader.readLine();
                            shu=Integer.parseInt(line);
                    } catch (Exception w) {
                        w.printStackTrace();
                    }
                } else {
                    JOptionPane.showConfirmDialog(null,"您未选择任何文件！已经载入原先关卡数据！","注意",JOptionPane.DEFAULT_OPTION);
                }

                  main.count=shu;
                  shuaxin();
            }

        });
        JMenuItem baocun = new JMenuItem("保存当前关卡");
        baocun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
            }
        });
        bianji.add(baocun);

        JMenuItem guan =new JMenuItem("编辑新关卡");
        guan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JTextAreaDemo();
            }
        });
        bianji.add(guan);
        bianji.add(zairu);
       shuaxin();
        this.addKeyListener(this);
        this.setJMenuBar(jm);
        this.setVisible(true);//设置可见
    }
void shuaxin(){  //将矩阵与外显GUI同步
        this.getContentPane().removeAll();
    ImageIcon icon1 = new ImageIcon(".\\blocks\\ailisi.gif");
    ImageIcon icon2 = new ImageIcon(".\\blocks\\redstone.png");
    ImageIcon icon3 = new ImageIcon(".\\blocks\\road.png");
    ImageIcon icon4 = new ImageIcon(".\\blocks\\wall.png");
    ImageIcon icon5 = new ImageIcon(".\\blocks\\green.png");
    for (int i = 0; i <10 ; i++) {
        for (int j = 0; j <10 ; j++) {
            if(a[i][j]==1){
                JLabel j1 = new JLabel(icon1);
                j1.setBounds(j*70,i*70,70,70);
                this.getContentPane().add(j1);
                x=i;y=j;
            }
            else if(a[i][j]==2){
                JLabel j1 = new JLabel(icon2);
                j1.setBounds(j*70,i*70,70,70);
                this.getContentPane().add(j1);
            }
            else if(a[i][j]==3){
                JLabel j1 = new JLabel(icon3);
                j1.setBounds(j*70,i*70,70,70);
                this.getContentPane().add(j1);
            }
            else if(a[i][j]==4){
                JLabel j1 = new JLabel(icon4);
                j1.setBounds(j*70,i*70,70,70);
                this.getContentPane().add(j1);
            }
            else if(a[i][j]==5){
                JLabel j1 = new JLabel(icon5);
                j1.setBounds(j*70,i*70,70,70);
                this.getContentPane().add(j1);
            }
        }
    }
this.repaint();
}

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        try {
            if(code==37){
                if(a[x][y-1]!=4){
                    a[x][y]=now;
                    now=a[x][y-1];
                    a[x][y-1]=1;

                    shuaxin();//按照新二维数组加载
                }
            } else if (code==38) {
                if(a[x-1][y]!=4){
                    a[x][y]=now;
                    now=a[x-1][y];
                    a[x-1][y]=1;
                    shuaxin();//按照新二维数组加载
                }
            }
            else if (code==39) {
                if(a[x][y+1]!=4){
                    a[x][y]=now;
                    now=a[x][y+1];
                    a[x][y+1]=1;
                    shuaxin();//按照新二维数组加载
                }
            }
            else if (code==40) {
                if(a[x+1][y]!=4){
                    a[x][y]=now;
                    now=a[x+1][y];
                    a[x+1][y]=1;
                    shuaxin();//按照新二维数组加载

                }
            }
        }catch (Exception q){

        }

        if(now==2){
            int shu = main.count;
            main.count=99999;
            me.stop();
            shengli.start();
            int opt = JOptionPane.showConfirmDialog(null, "请问是否继续游戏？", "恭喜通关！",
                    JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                main.count=shu;
              me.xunhuan();
            }else{
                System.exit(114514);
            }
        }
    }
}
