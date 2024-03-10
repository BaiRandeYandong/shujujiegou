import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class JTextAreaDemo
{ String data;
    String fn;
    JTextAreaDemo(){
int shu = main.count;
main.count=99999;
        JFrame frame=new JFrame("关卡编辑器");    //创建Frame窗口
        JTextArea jta=new JTextArea("请输入内容",10,30);
        jta.setLineWrap(true);    //设置文本域中的文本为自动换行
        jta.setForeground(Color.BLACK);    //设置组件的背景色
        jta.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        jta.setBackground(Color.YELLOW);    //设置按钮背景色
        JScrollPane jsp=new JScrollPane(jta);    //将文本域放入滚动窗口
        Dimension size=jta.getPreferredSize();    //获得文本域的首选大小
        jsp.setBounds(200,70,size.width,size.height);
        frame.setLayout(null);//布局方式修改
        frame.getContentPane().add(jsp);    //将JPanel容器添加到JFrame容器中
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setSize(700,700);    //设置JFrame容器的大小
        frame.setLocationRelativeTo(null);//居中


        JLabel nei = new JLabel("请在下框中输入10*10的数字矩阵代表迷宫地图  数字1代表初始位置，数字2代表终点，数字3代表道路，数字4代表墙");
        nei.setBounds(10,10,700,20);
        frame.getContentPane().add(nei);

        JLabel ti = new JLabel("请在下框中输入限制的时间，单位为秒");
        ti.setBounds(230,270,700,20);
        frame.getContentPane().add(ti);

        JTextField shuru = new JTextField();
        shuru.setBounds(220,320,250,37);
        frame.getContentPane().add(shuru);

        JLabel f = new JLabel("请在下框中输入需要保存为的文件名");
        f.setBounds(230,370,700,20);
        frame.getContentPane().add(f);

        JTextField ff = new JTextField();
        ff.setBounds(220,400,250,37);
        frame.getContentPane().add(ff);

        frame.setVisible(true);
        JButton QQ = new JButton("提交");
        QQ.setBounds(300,600,100,50);
        QQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data= jta.getText();
                data=data+"\n"+shuru.getText();
                fn=ff.getText();


                File fileToDelete = new File(fn);
                boolean isDeleted = fileToDelete.delete();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fn+".save", true))) {
                    writer.write(data);
                    if(isDeleted){
                        JOptionPane.showConfirmDialog(null,"保存成功,本次保存发生了文件覆盖","",JOptionPane.DEFAULT_OPTION);
                    }else{
                        JOptionPane.showConfirmDialog(null,"保存成功","",JOptionPane.DEFAULT_OPTION);
                    }


                } catch (IOException w) {
                    w.printStackTrace();
                }
                frame.setVisible(false);
                main.count=shu;
            }
        });
        frame.getContentPane().add(QQ);

    }


}
