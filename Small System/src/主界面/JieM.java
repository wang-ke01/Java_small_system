package ������;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import ���ݿ�ģ��.TbUserlist;
import ��¼����.Denglu;
import ϵͳ��ʾ.����.WindowUtil;
import ϵͳ��ʾ.ϵͳ����.ExitSystem;

public class JieM {
	private JDesktopPane desktopPane;
	private JLabel backLabel; // ������ǩ
	private JFrame frame;
	private TbUserlist user = Denglu.getUser();
	// �������

	// ������ť
	private JButton khG;
	private JButton spG;
	private JButton gyG;
	private JButton jt;
	private JButton jhD;
	private JButton xsT;
	private JButton xsD;
	private JButton kcP;
	private JButton kcjP;
	private JButton czG;
	private JButton qxG;
	private JButton ggM;
	private JButton tcX;
	private JButton khC;
	private JButton spC;
	private JButton gyC;
	private JButton xsC;
	private JButton xsTC;
	private JButton rkC;
	private JButton rktC;
	private JButton xsP;
	private JButton zdC;
	private JButton zdG;
	private Map<String, JInternalFrame> ifs = new HashMap<String, JInternalFrame>();

	public JieM() {
		frame = new JFrame("С�ͳ�����Ʒ����ϵͳ");
		WindowUtil windowsuUtil = new WindowUtil();
		int x = windowsuUtil.getLocation().x;
		int y = windowsuUtil.getLocation().y;
		frame.getContentPane().setBackground(new Color(189, 252, 201)); // *****���ñ���ɫ(�ϱ���)
		frame.addComponentListener(new FrameListener()); // ��Ӵ����¼�������
		frame.getContentPane().setLayout(new BorderLayout()); // ���ò��ֹ�����
		frame.setBounds(x, y, 1150, 700); // ���ô���λ��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backLabel = new JLabel(); // ������ǩ
		backLabel.setVerticalAlignment(SwingConstants.TOP); // ���ñ�����ǩ��ֱ���뷽ʽ
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);// ���ñ�����ǩˮƽ���뷽ʽ������
		updateBackImage(); // ���»��ʼ������ͼƬ
		desktopPane = new JDesktopPane(); // �����������
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE)); // ��������ǩ��ӵ����������
		frame.getContentPane().add(desktopPane); // ���������嵽������
		JTabbedPane navigationPanel = createNavigationPanel(); // ����������ǩ���
		frame.getContentPane().add(navigationPanel, BorderLayout.NORTH);// ��ӵ�����嵽������
		frame.setVisible(true); // ��ʾ����

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Denglu();
			}
		});
	}

	public JTabbedPane createNavigationPanel() {
		TbUserlist user = Denglu.getUser();
		// ����һ����ǩ������
		JTabbedPane jtp = new JTabbedPane();
		jtp.setFocusable(false); // ����ѡ����㲻��ȡ����ȡ   
		jtp.setBackground(new Color(211, 230, 192)); // ***********����ѡ�������ɫ
		jtp.setBorder(new BevelBorder(BevelBorder.RAISED)); // ����ѡ��߿�

		// ������Ϣ����ť
		khG = new JButton("�ͻ���Ϣ����");
		spG = new JButton("��Ʒ��Ϣ����");
		gyG = new JButton("��Ӧ����Ϣ����");

		// ��������ť
		jt = new JButton("����/�˻�");
		jhD = new JButton("������");
		// ���۹���
		xsT = new JButton("�����˻�");
		xsD = new JButton("���۵�");
		// ������
		kcP = new JButton("����̵�");
		kcjP = new JButton("���۸��̵�");
		// ϵͳ����
		czG = new JButton("����Ա����");
		qxG = new JButton("Ȩ�޹���");
		zdG = new JButton("�����ֵ����");
		ggM = new JButton("��������");
		tcX = new JButton("");
		// ��ѯͳ��
		khC = new JButton("�ͻ���ѯ");
		spC = new JButton("��Ʒ��ѯ");
		gyC = new JButton("��Ӧ�̲�ѯ");
		xsC = new JButton("���۲�ѯ");
		xsTC = new JButton("�����˻���ѯ");
		rkC = new JButton("����ѯ");
		rktC = new JButton("����˻���ѯ");
		xsP = new JButton("��������");
		zdC = new JButton("�����ֵ��ѯ");

		JPanel jc = new JPanel();
		jc.setBackground(new Color(189, 252, 201)); // *****���ñ�����ɫ��������Ϣ �м����ѡ�
		jc.setLayout(new BoxLayout(jc, BoxLayout.X_AXIS)); // ���ò��֣��������
		jc.add(createFrameButton("�ͻ���Ϣ����", "������Ϣ����.KeHuXinX", khG));
		jc.add(createFrameButton("��Ʒ��Ϣ����", "������Ϣ����.ShangPinXinX", spG));
		jc.add(createFrameButton("��Ӧ����Ϣ����", "������Ϣ����.GysXinX", gyG));

		JPanel jh = new JPanel();
		jh.setBackground(new Color(189, 252, 201)); // ******���ñ�����ɫ���������� �м����ѡ�
		jh.setLayout(new BoxLayout(jh, BoxLayout.X_AXIS)); // ���ò��֣��������
		jh.add(createFrameButton("������", "��������.JinHuoDan", jhD));
		jh.add(createFrameButton("�����˻�", "��������.JinHuoTuiHuo", jt));

		JPanel xs = new JPanel();
		xs.setBackground(new Color(189, 252, 201));// ******���ñ�����ɫ�����۹��� �м����ѡ�
		xs.setLayout(new BoxLayout(xs, BoxLayout.X_AXIS));
		xs.add(createFrameButton("���۵�", "���۹���.XiaoShouDan", xsD));
		xs.add(createFrameButton("�����˻�", "���۹���.XiaoShouTuiHuo", xsT));

		JPanel kc = new JPanel();
		kc.setBackground(new Color(189, 252, 201));// ******���ñ�����ɫ����ѯͳ�� �м����ѡ�
		kc.setLayout(new BoxLayout(kc, BoxLayout.X_AXIS));
		kc.add(createFrameButton("����̵�", "������.KuCunPanDian", kcP));
		kc.add(createFrameButton("�۸����", "������.JiaGeTiaoZheng", kcjP));

		JPanel xt = new JPanel();
		xt.setBackground(new Color(189, 252, 201));// ******���ñ�����ɫ��ϵͳ���� �м����ѡ�
		xt.setLayout(new BoxLayout(xt, BoxLayout.X_AXIS));
		xt.add(createFrameButton("����Ա����", "ϵͳ����.CzyGL", czG));
		xt.add(createFrameButton("Ȩ�޹���", "ϵͳ����.QuanManager", qxG));
		xt.add(createFrameButton("�ֵ����", "ϵͳ����.SjZd", zdG));
		xt.add(createFrameButton("��������", "ϵͳ����.GengGaiMiMa", ggM));
		xt.add(createSysExit("�˳�ϵͳ", "ϵͳ����.ExitSystem", tcX));
		tcX.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				new ExitSystem();
			}
		});

		// String q =user.getQuan();
		// int r =q.compareTo("a");
		// if( r == 0 ) //�����¼���û��ǹ���Ա��ݣ�����Ӳ���Ա�����Ȩ�޹����ܡ�
		// ���⣺ֱ����if( user.getQuan()=="a" ) �жϲ��У���δ�ҵ�ԭ��
		// {

		// }
		JPanel cx = new JPanel();
		cx.setBounds(0, 0, 600, 41);
		cx.setName("searchStatisticPanel");
		cx.setBackground(new Color(189, 252, 201));
		cx.setLayout(new BoxLayout(cx, BoxLayout.X_AXIS));
		cx.add(createFrameButton("�ͻ���Ϣ��ѯ", "��ѯͳ��.KeHuChaXun", khC));
		cx.add(createFrameButton("��Ʒ��Ϣ��ѯ", "��ѯͳ��.ShangPinChaXun", spC));
		cx.add(createFrameButton("��Ӧ����Ϣ��ѯ", "��ѯͳ��.GongYingShangChaXun", gyC));
		cx.add(createFrameButton("������Ϣ��ѯ", "��ѯͳ��.XiaoShouChaXun", xsC));
		cx.add(createFrameButton("�����˻���ѯ", "��ѯͳ��.XiaoShouTuiHuoChaXun", xsTC));
		cx.add(createFrameButton("����ѯ", "��ѯͳ��.RuKuChaXun", rkC));
		cx.add(createFrameButton("����˻���ѯ", "��ѯͳ��.RuKuTuiHuoChaXun", rktC));
		cx.add(createFrameButton("��������", "��ѯͳ��.XiaoShouPaiHang", xsP));
		cx.add(createFrameButton("�ֵ��ѯ", "��ѯͳ��.ShuJuZiDianChaXun", zdC));

		// ��������������ǩ����������
		jtp.addTab("   ������Ϣ����   ", null, jc, "������Ϣ����");
		jtp.addTab("   ��������   ", null, jh, "��������");
		jtp.addTab("   ���۹���   ", null, xs, "���۹���");
		jtp.addTab("   ��ѯͳ��   ", null, cx, "��ѯͳ��");
		jtp.addTab("   ������   ", null, kc, "������");
		jtp.addTab("   ϵͳ����   ", null, xt, "ϵͳ����");
		return jtp;
	}

	/** *********************��������************************* */
	// Ϊ�ڲ��������Action�ķ���
	private JButton createFrameButton(String fName, String cname, JButton button) {
		String imgUrl = "Image/ActionIcon/" + fName + ".png";
		String imgUrl_roll = "Image/ActionIcon/" + fName + "_roll.png";
		String imgUrl_down = "Image/ActionIcon/" + fName + "_down.png";
		Icon icon = new ImageIcon(imgUrl); // ������ťͼ��
		Icon icon_roll = null;
		if (imgUrl_roll != null)
			icon_roll = new ImageIcon(imgUrl_roll); // ���������ڰ�ť��ʱ��ͼ��
		Icon icon_down = null;
		if (imgUrl_down != null)
			icon_down = new ImageIcon(imgUrl_down); // ������ť���µ�ͼ��
		Action action = new openFrameAction(fName, cname, icon); // ��openFrameAction
																	// �ഴ��Action����
		button.setAction(action);
		button.setMargin(new Insets(0, 0, 0, 0)); // ���ð�ť�����ܱ߽�Ϊ0
		button.setHideActionText(true); // ���ذ�ť�� �ı���Ϣ
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		if (icon_roll != null)
			button.setRolloverIcon(icon_roll);
		if (icon_down != null)
			button.setPressedIcon(icon_down);
		return button;
	}

	// �˳�ϵͳͼ�귽��
	private JButton createSysExit(String fName, String cname, JButton button) {
		String imgUrl = "Image/ActionIcon/" + fName + ".png";
		String imgUrl_roll = "Image/ActionIcon/" + fName + "_roll.png";
		String imgUrl_down = "Image/ActionIcon/" + fName + "_down.png";
		Icon icon = new ImageIcon(imgUrl); // ������ťͼ��
		Icon icon_roll = null;
		if (imgUrl_roll != null)
			icon_roll = new ImageIcon(imgUrl_roll); // ���������ڰ�ť��ʱ��ͼ��
		Icon icon_down = null;
		if (imgUrl_down != null)
			icon_down = new ImageIcon(imgUrl_down); // ������ť���µ�ͼ��

		button.setMargin(new Insets(0, 0, 0, 0)); // ���ð�ť�����ܱ߽�Ϊ0
		button.setHideActionText(true); // ���ذ�ť�� �ı���Ϣ
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setIcon(icon);
		if (icon_roll != null)
			button.setRolloverIcon(icon_roll);
		if (icon_down != null)
			button.setPressedIcon(icon_down);
		return button;
	}

	// ��ȡ�ڲ������Ψһʵ������
	private JInternalFrame getIFrame(String frameName) {
		JInternalFrame jf = null;
		if (!ifs.containsKey(frameName)) {
			try {
				Class fClass = Class.forName("ϵͳ��ʾ." + frameName);
				Constructor constructor = fClass.getConstructor(null);
				jf = (JInternalFrame) constructor.newInstance(null);
				ifs.put(frameName, jf);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			jf = ifs.get(frameName);
		return jf;
	}

	// ���±�����ǩ�ķ�����������ǩʹ��HTML��������������ı���ͼƬ����ͼƬ����������Ĵ�С�Զ����š�
	private void updateBackImage() {
		if (backLabel != null) {
			int backw = frame.getWidth();
			int backh = frame.getHeight();
			backLabel.setSize(backw, backh); // ��ʼ��������ǩ�Ĵ�С
			backLabel.setText("<html><body><image width='" + (backw)
					+ "' height='" + (backh - 110) + "' src="
					+ JieM.this.getClass().getResource("JXCBJX.jpg")
					+ "'></img></body></html>"); // ���ñ�����ǩ��ͼ��
		}
	}

	// ���������
	private final class FrameListener extends ComponentAdapter {
		public void componentResized(final ComponentEvent e) {
			updateBackImage();
		}
	}

	// ������˵���ĵ����¼�������
	protected final class openFrameAction extends AbstractAction {
		private String frameName = null;

		private openFrameAction() {
		}

		public openFrameAction(String cname, String frameName, Icon icon) {
			this.frameName = frameName;
			putValue(Action.NAME, cname); // ����Action������
			putValue(Action.SHORT_DESCRIPTION, cname); // ����Action����ʾ�ı���
			putValue(Action.SMALL_ICON, icon); // ����Action��ͼ��
		}

		public void actionPerformed(final ActionEvent e) {
			JInternalFrame jf = getIFrame(frameName); // ����getFrame()������ȡ��Ӧ�Ĵ������
			// ���ڲ�����չ�ʱ�����ڲ���������ifs����������ô��塣
			jf.addInternalFrameListener(new InternalFrameAdapter() {
				public void internalFrameClosed(InternalFrameEvent e) {
					ifs.remove(frameName);
				}
			});
			if (jf.getDesktopPane() == null) {
				desktopPane.add(jf); // ��������ӵ���������
				jf.setVisible(true); // ��ʾ����
			}
			try {
				jf.setSelected(true); // ʹ���崦�ڱ�ѡ��״̬
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		}
	}

	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// ���������Ϊϵͳ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
