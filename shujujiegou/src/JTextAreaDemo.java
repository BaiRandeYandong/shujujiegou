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
        JFrame frame=new JFrame("�ؿ��༭��");    //����Frame����
        JTextArea jta=new JTextArea("����������",10,30);
        jta.setLineWrap(true);    //�����ı����е��ı�Ϊ�Զ�����
        jta.setForeground(Color.BLACK);    //��������ı���ɫ
        jta.setFont(new Font("����",Font.BOLD,16));    //�޸�������ʽ
        jta.setBackground(Color.YELLOW);    //���ð�ť����ɫ
        JScrollPane jsp=new JScrollPane(jta);    //���ı�������������
        Dimension size=jta.getPreferredSize();    //����ı������ѡ��С
        jsp.setBounds(200,70,size.width,size.height);
        frame.setLayout(null);//���ַ�ʽ�޸�
        frame.getContentPane().add(jsp);    //��JPanel������ӵ�JFrame������
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setSize(700,700);    //����JFrame�����Ĵ�С
        frame.setLocationRelativeTo(null);//����


        JLabel nei = new JLabel("�����¿�������10*10�����־�������Թ���ͼ  ����1�����ʼλ�ã�����2�����յ㣬����3�����·������4����ǽ");
        nei.setBounds(10,10,700,20);
        frame.getContentPane().add(nei);

        JLabel ti = new JLabel("�����¿����������Ƶ�ʱ�䣬��λΪ��");
        ti.setBounds(230,270,700,20);
        frame.getContentPane().add(ti);

        JTextField shuru = new JTextField();
        shuru.setBounds(220,320,250,37);
        frame.getContentPane().add(shuru);

        JLabel f = new JLabel("�����¿���������Ҫ����Ϊ���ļ���");
        f.setBounds(230,370,700,20);
        frame.getContentPane().add(f);

        JTextField ff = new JTextField();
        ff.setBounds(220,400,250,37);
        frame.getContentPane().add(ff);

        frame.setVisible(true);
        JButton QQ = new JButton("�ύ");
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
                        JOptionPane.showConfirmDialog(null,"����ɹ�,���α��淢�����ļ�����","",JOptionPane.DEFAULT_OPTION);
                    }else{
                        JOptionPane.showConfirmDialog(null,"����ɹ�","",JOptionPane.DEFAULT_OPTION);
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
