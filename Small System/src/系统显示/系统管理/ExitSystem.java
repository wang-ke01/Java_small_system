package ϵͳ��ʾ.ϵͳ����;

import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class ExitSystem {
	public ExitSystem() {
		int keys = JOptionPane.showConfirmDialog(null,
				"�Ƿ��˳����������ϵͳ��", "�˳�ϵͳ", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (keys == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}