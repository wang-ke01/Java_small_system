package ϵͳ��ʾ.������Ϣ����;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ϵͳ��ʾ.������Ϣ����.��Ӧ����Ϣ����.GysAddPanel;
import ϵͳ��ʾ.������Ϣ����.��Ӧ����Ϣ����.GysAlterPanel;

public class GysXinX extends JInternalFrame{
	public GysXinX(){
		setIconifiable(true);
		setClosable(true);
		setTitle("��Ӧ����Ϣ����");
		setResizable(false);//���ý����С���ɸ���
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.setFocusable(false);				//����ѡ����㲻��ȡ����ȡ
		tabPane.setBackground(new Color(211, 230, 192));	//����ѡ�������ɫ
		tabPane.setBorder(new BevelBorder(BevelBorder.RAISED));	//����ѡ��߿�
		final GysAddPanel gystjPanel = new GysAddPanel();
		final GysAlterPanel gysxgPanel = new GysAlterPanel();
		tabPane.addTab("��Ӧ����Ϣ���", null, gystjPanel, "��Ӧ�����");
		tabPane.addTab("��Ӧ����Ϣ�޸���ɾ��", null, gysxgPanel, "�޸���ɾ��");
		getContentPane().add(tabPane);
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				gysxgPanel.initComboBox();
			}
		});
		pack();
		//this.setBounds(300, 300, 600, 400);
		setVisible(true);
	}
}
