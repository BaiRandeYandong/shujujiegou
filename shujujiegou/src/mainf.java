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
        this.setSize(760,760);//���ô���
        this.setTitle("�Թ���Ϸ");//���ñ���
        //this.setAlwaysOnTop(true);//ǿ���ö�
        this.setLocationRelativeTo(null);//����
        this.setDefaultCloseOperation(3);//�رշ�ʽΪ����Źر�
        this.setLayout(null);//���ַ�ʽ�޸�


        JMenuBar jm = new JMenuBar();//���ò˵�
        JMenu bianji = new JMenu("�༭");
        JMenu luj = new JMenu("·������");
        JMenuItem lu = new JMenuItem("��������������·��");
        luj.add(lu);
        JMenu yan = new JMenu("�ӳ�ʱ��");
        JMenu zuobi = new JMenu("����ѡ��");
        JMenuItem sheng = new JMenuItem("ֱ�ӻ��ʤ����");
        sheng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int shu = main.count;
                main.count=99999;
                me.stop();
                shengli.start();
                int opt = JOptionPane.showConfirmDialog(null, "�����Ƿ������Ϸ��", "��ϲͨ�أ�",
                        JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    main.count=shu;
                      me.xunhuan();
                }else{
                    System.exit(114514);
                }
            }
        });
        JMenuItem shang = new JMenuItem("���Ϸ�ǽ��·���ʻ���");
        JMenuItem xia = new JMenuItem("���·�ǽ��·���ʻ���");
        JMenuItem zuo = new JMenuItem("����ǽ��·���ʻ���");
        JMenuItem you = new JMenuItem("���ҷ�ǽ��·���ʻ���");
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
        JMenuItem shi = new JMenuItem("�ӳ�10��");
        JMenuItem sanshi = new JMenuItem("�ӳ�30��");
        JMenuItem fen = new JMenuItem("�ӳ�60��");
        JMenuItem wu = new JMenuItem("�ӳ�99999��");
        JMenuItem gui = new JMenuItem("��ʱ����һ����");
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
        JMenu yin = new JMenu("��Ч����");
        JMenuItem kai = new JMenuItem("��������");
        JMenuItem guanb = new JMenuItem("�ر�����");
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

        JMenuItem zairu = new JMenuItem("��������");
        zairu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int shu=main.count;
                main.count=99999;//��ֹ�ڶ�ȡʱ����ʱ����
                JFileChooser fileChooser = new JFileChooser();
                int [][] c = new int[10][10];
                // ����Ĭ�ϵĴ�Ŀ¼�������Ҫ��
                fileChooser.setCurrentDirectory(new File("."));

                // ��ʾ�ļ�ѡ�����Ի���
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // ��ȡ��ѡ�ļ�·��
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
                    JOptionPane.showConfirmDialog(null,"��δѡ���κ��ļ����Ѿ�����ԭ�ȹؿ����ݣ�","ע��",JOptionPane.DEFAULT_OPTION);
                }

                  main.count=shu;
                  shuaxin();
            }

        });
        JMenuItem baocun = new JMenuItem("���浱ǰ�ؿ�");
        baocun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
            }
        });
        bianji.add(baocun);

        JMenuItem guan =new JMenuItem("�༭�¹ؿ�");
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
        this.setVisible(true);//���ÿɼ�
    }
void shuaxin(){  //������������GUIͬ��
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

                    shuaxin();//�����¶�ά�������
                }
            } else if (code==38) {
                if(a[x-1][y]!=4){
                    a[x][y]=now;
                    now=a[x-1][y];
                    a[x-1][y]=1;
                    shuaxin();//�����¶�ά�������
                }
            }
            else if (code==39) {
                if(a[x][y+1]!=4){
                    a[x][y]=now;
                    now=a[x][y+1];
                    a[x][y+1]=1;
                    shuaxin();//�����¶�ά�������
                }
            }
            else if (code==40) {
                if(a[x+1][y]!=4){
                    a[x][y]=now;
                    now=a[x+1][y];
                    a[x+1][y]=1;
                    shuaxin();//�����¶�ά�������

                }
            }
        }catch (Exception q){

        }

        if(now==2){
            int shu = main.count;
            main.count=99999;
            me.stop();
            shengli.start();
            int opt = JOptionPane.showConfirmDialog(null, "�����Ƿ������Ϸ��", "��ϲͨ�أ�",
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
