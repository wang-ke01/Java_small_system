package ��¼����;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DengluPanel extends JPanel{
	protected ImageIcon beiJ;	//��������ͼƬ�Ľӿ�
	public int width,height;	//���������С��Ĭ��ֵ
	public DengluPanel(){
		super();	//�̳�JPanel�ķ���
		beiJ = new ImageIcon("Image/dengLuBeiJing.jpg");	//��������ͼƬͼ��
		//���ͼ��ĸ߶ȺͿ�ȣ�ʹ�������ͼƬ�Ĵ�С
		width = beiJ.getIconWidth();
		height = beiJ.getIconHeight();
		setSize(width, height);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = beiJ.getImage();
		g.drawImage(img, 0, 0,getParent());
	}
}
