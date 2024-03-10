
import javax.sound.sampled.*;
import java.io.File;


public class media {
    //��Ƶ�ļ�������
    private  AudioInputStream aio;
    //������
    private Clip bgm;
    //����ͣ�ͼ�������ʱ�����ļ��ĺ�����
    private Long microsecondPosition;
    private media(){};
    /*
        ������������Ҫ���ŵ����ֵ�ַ
        filePath=��Ƶ�ļ��ĵ�ַ,���ڴ���file����,�Լ���������Ƶ������
     */
    public media(String filePath) {
        try {
            //������Ƶ����
            this.bgm=AudioSystem.getClip();
            //������
            this.aio = AudioSystem.getAudioInputStream(new File(filePath));
            //������
            bgm.open(aio);
        } catch (Exception e) {
            System.err.println("��Ƶ�ļ���ʼ��ʧ��");
            //System.out.println(e);
        }
    }
    /**
     ��������
     */
    public void start(){
        if(main.media==false)
            return;
        //��������
        bgm.setMicrosecondPosition(0);
        bgm.start();
    }
    public void xunhuan(){
        if(main.media==false)
            return;
        //ѭ����������
        bgm.setMicrosecondPosition(0);
        bgm.start();
        bgm.loop(Clip.LOOP_CONTINUOUSLY);
    }
    /**
     ��ͣ����
     */
    public void pause(){
        //���浱ǰʱ���
        microsecondPosition= bgm.getMicrosecondPosition();
        //��ͣ����
        bgm.stop();
    }
    /**
     ��������
     */
    public void recommence(){
        //������һ����ͣλ�õĺ���ֵ
        bgm.setMicrosecondPosition(microsecondPosition);
        //������λ�ü�������
        bgm.start();
    }
    /**
     ��������
     */
    public void stop(){
        //�жϲ���
        bgm.stop();
        //�ر���
      //  bgm.close();
    }

}

