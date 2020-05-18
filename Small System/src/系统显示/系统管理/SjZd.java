package ϵͳ��ʾ.ϵͳ����;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import ϵͳ��ʾ.ϵͳ����.�����ֵ�.AddDictionary;
import ϵͳ��ʾ.ϵͳ����.�����ֵ�.DelDictionary;

public class SjZd extends JInternalFrame {
	public SjZd() {
		setIconifiable(true);
		setClosable(true);
		setTitle("�����ֵ����");
		setResizable(false);
		setFocusable(true);
		// setBounds(100, 100, 400, 400);
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.setFocusable(false); // ����ѡ����㲻��ȡ
		tabPane.setBackground(new Color(211, 230, 192)); // ����ѡ�������ɫ
		tabPane.setBorder(new BevelBorder(BevelBorder.RAISED)); // ����ѡ��߿�
		final AddDictionary tjzdPanel = new AddDictionary();
		final DelDictionary sczdPanel = new DelDictionary();

		tabPane.addTab("��������ֵ�", null, tjzdPanel, "�ֵ����");
		tabPane.addTab("ɾ�������ֵ�", null, sczdPanel, "�ֵ�ɾ��");

		tabPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO �Զ����ɵķ������
				sczdPanel.initTable();
			}
		});
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO �Զ����ɵķ������
				super.internalFrameActivated(e);
				tjzdPanel.initTimeField();
			}

		});
		getContentPane().add(tabPane);
		pack();
		setVisible(true);

	}

}
