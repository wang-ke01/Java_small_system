package ϵͳ��ʾ.ϵͳ����;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ϵͳ��ʾ.ϵͳ����.����Ա����.ShanChuCaoZuoYuan;
import ϵͳ��ʾ.ϵͳ����.����Ա����.TJCzy;
public class CzyGL extends JInternalFrame {
	public CzyGL() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 491, 287);
		setTitle("����Ա����");
		//setResizable(false);//���ý����С���ɸ���
		JTabbedPane tabPane = new JTabbedPane();
		final TJCzy tjPanel = new TJCzy();
		final ShanChuCaoZuoYuan delPanel = new ShanChuCaoZuoYuan();
		tabPane.addTab("��Ӳ���Ա", null, tjPanel, "��Ӳ���Ա");
		tabPane.addTab("ɾ������Ա", null, delPanel, "ɾ������Ա");
		getContentPane().add(tabPane);
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				delPanel.initTable();
			}
		});
		pack();
		setVisible(true);
	}
}
