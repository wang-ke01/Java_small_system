package ϵͳ��ʾ.����;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
//���������ʾ
public class WindowUtil {
	//�������С���ó�500x309����
	public static Dimension getSize(){
		return new Dimension(1150,700);
	}
	//���㴰�������ʾʱ���Ͻǵ�����
	public static Point getLocation(){
		Toolkit toolkit=Toolkit.getDefaultToolkit();	//���Toolkitʵ��
		Dimension screenSize =toolkit.getScreenSize();	//�����ʾ����С
		if((screenSize.width<getSize().width)||(screenSize.height<getSize().height)){
			JOptionPane.showMessageDialog(null, "��ʾ���ֱ�������Ϊ1150 x 700","",JOptionPane.WARNING_MESSAGE);
			System.exit(0);	//��ֹ����
		}
		int x=(screenSize.width-getSize().width)/2;		//�������ϽǺ�����
		int y=(screenSize.height-getSize().height)/2;	//�������Ͻ�������
		return new Point(x, y);
	}
}
