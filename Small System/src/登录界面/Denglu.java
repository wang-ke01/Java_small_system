package ��¼����;
//ȱ����ʾ����
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import ������.JieM;
import ���ݿ�ģ��.TbUserlist;
import ϵͳ��ʾ.JWindowDemo;
import ϵͳ��ʾ.���ݿ���Ϣ.DaoRu;

public class Denglu extends JFrame{
	private JLabel userLabel;	//�����û���ǩ
	private JLabel passLabel;	//���������ǩ
	private JButton enter;		//�����¼��ť
	private JButton exit;		//�����˳���ť
	private static TbUserlist user;
	public Denglu(){
		setTitle("��½��Ʒ����ϵͳ");	//���ô������
		Toolkit toolkit=Toolkit.getDefaultToolkit();	//���Toolkitʵ��
		Dimension screenSize =toolkit.getScreenSize();	//�����ʾ����С
		final JPanel dlPanel = new DengluPanel();	//������̬���������������޸�
		int x=(screenSize.width-dlPanel.getWidth())/2;		//�������ϽǺ�����
		int y=(screenSize.height-dlPanel.getHeight())/2;	//�������Ͻ�������

		dlPanel.setLayout(null);	//����Ϊ�ղ���
		getContentPane().add(dlPanel);				//����������ӵ�������������
		setBounds(x, y, dlPanel.getWidth(), dlPanel.getHeight());	//���õ�¼����λ���Լ���С
		//�������
		userLabel = new JLabel();
		passLabel = new JLabel();
		//���ñ�ǩ�ı�
		userLabel.setText("�û�����");
		passLabel.setText("��  �룺");
		//������̬���ı����������޸�
		final JTextField userName = new JTextField();
		final JPasswordField userPassword = new JPasswordField();	//�����ı�������ʾ���ݣ�Ĭ�Ͻ�ֹʹ�����뷨
		//���ñ�ǩ��λ���Լ���С
		userLabel.setBounds(100, 200, 300, 50);		//�û���ǩ
		passLabel.setBounds(100, 250, 300, 50);		//�����ǩ
		userName.setBounds(150, 210, 250, 30);		//�û��ı�
		userPassword.setBounds(150, 260, 250, 30);	//�����ı�
		//�ѱ�ǩ��ӵ��м�������
		dlPanel.add(userLabel);	//�û���ǩ
		dlPanel.add(passLabel);	//�����ǩ
		//���ı���ӵ��м�������
		dlPanel.add(userName);		//�û��ı�
		dlPanel.add(userPassword);	//�����ı�
		//���찴ť
		enter = new JButton();
		exit = new JButton();
		//Ϊ��ť�����ı�
		enter.setText("��¼");
		exit.setText("�˳�");
		//Ϊ��ť����λ��
		enter.setBounds(170, 320, 70, 40);
		exit.setBounds(290, 320, 70, 40);
		//������*******
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				user = DaoRu.getUser(userName.getText(),new String(userPassword.getPassword()));
				if (user.getUsername() == null || user.getName() == null) {
					userName.setText(null);
					userPassword.setText(null);
					return;
				}
				setVisible(false);
				new JWindowDemo().start();
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});
		//�Ѱ�ť��ӵ��м�������
		dlPanel.add(enter);
		dlPanel.add(exit);

		//���ý��淽��
		toFront();	//����ǰ����ʾ
		setUndecorated(true);	//���ñ�����������ʾ
		setVisible(true);	//���ý���ɼ�
		setResizable(false);//���ý����С���ɸ���
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	//���ùرհ�ť�޲���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void setClosable(boolean b) {
		// TODO Auto-generated method stub

	}
	public static TbUserlist getUser() {
		return user;
	}
	public static void setUser(TbUserlist user) {
		Denglu.user = user;
	}
}
