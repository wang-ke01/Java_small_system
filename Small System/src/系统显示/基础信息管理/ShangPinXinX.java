package ϵͳ��ʾ.������Ϣ����;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import ϵͳ��ʾ.������Ϣ����.��Ʒ��Ϣ����.ShangPinAddPanel;
import ϵͳ��ʾ.������Ϣ����.��Ʒ��Ϣ����.ShangPinAlterPanel;

public class ShangPinXinX extends JInternalFrame{
	public ShangPinXinX(){
		setIconifiable(true);
		setClosable(true);
		setTitle("��Ʒ����");
		//setResizable(false);//���ý����С���ɸ���
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.setFocusable(false);				//����ѡ����㲻��ȡ����ȡ
		tabPane.setBackground(new Color(211, 230, 192));	//����ѡ�������ɫ
		tabPane.setBorder(new BevelBorder(BevelBorder.RAISED));	//����ѡ��߿�
		final ShangPinAddPanel sptjPanel = new ShangPinAddPanel();
		final ShangPinAlterPanel spxgPanel = new ShangPinAlterPanel();
		tabPane.addTab("��Ʒ��Ϣ���", null, sptjPanel, "��Ʒ���");
		tabPane.addTab("��Ʒ��Ϣ�޸���ɾ��", null, spxgPanel, "�޸���ɾ��");
		getContentPane().add(tabPane);
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spxgPanel.initComboBox();
				spxgPanel.initGysBox();
			}
		});
		//����Ʒ�����ڱ�����ʱ����ʼ����Ʒ��ӽ���Ĺ�Ӧ������ѡ���
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				sptjPanel.initGysBox();
			}
		});
		pack();
		setVisible(true);
	}
}
