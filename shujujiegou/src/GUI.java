import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
public class GUI  {
    String filename;
private int qwe = 0;
    public int getQwe() {
        return qwe;
    }
    public void setQwe(int qwe) {
        this.qwe = qwe;
    }
    public GUI()  {

        int shu=main.count;
        main.count=99999;
        //防止保存时时间流逝
        JFrame zhuGUI = new JFrame();
         zhuGUI.setSize(650, 430);
        zhuGUI.setTitle("请输入要作为保存的文件名，将保存为后缀名为save的存档");
       // zhuGUI.setAlwaysOnTop(true);
        zhuGUI.setLocationRelativeTo(null);
        zhuGUI.setLayout(null);
JTextField shuru = new JTextField();
shuru.setBounds(170,135,250,37);
zhuGUI.getContentPane().add(shuru);
        JButton QQ = new JButton("提交");

     QQ.setBounds(250,300,100,50);

        QQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             filename=shuru.getText();
             zhuGUI.setVisible(false);
                String data = "";
                for (int i = 0; i <10 ; i++) {
                    for (int j = 0; j <10 ; j++) {
                        if(mainf.a[i][j]==5){
                            data+=3;
                        }else{
                            data+=mainf.a[i][j];
                        }

                    }
                    data+="\n";
                }
                data+=shu;
                File fileToDelete = new File(filename);
                boolean isDeleted = fileToDelete.delete();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename+".save", true))) {
                    writer.write(data);
                    if(isDeleted){
                        JOptionPane.showConfirmDialog(null,"保存成功,本次保存发生了文件覆盖","",JOptionPane.DEFAULT_OPTION);
                    }else{
                        JOptionPane.showConfirmDialog(null,"保存成功","",JOptionPane.DEFAULT_OPTION);
                    }


                } catch (IOException w) {
                    w.printStackTrace();
                }
                main.count=shu;
            }
        });
        zhuGUI.getContentPane().add(QQ);

        zhuGUI.setVisible(true);

    }


}



