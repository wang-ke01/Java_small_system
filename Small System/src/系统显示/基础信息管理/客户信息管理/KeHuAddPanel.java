package ϵͳ��ʾ.������Ϣ����.�ͻ���Ϣ����;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import �ؼ��ּ�����.InputKeyListener;
import ���ݿ�ģ��.TbDictionary;
import ���ݿ�ģ��.TbKhXinX;
import ϵͳ��ʾ.���ݿ���Ϣ.DaoRu;
import ϵͳ��ʾ.����.Item;
import ϵͳ��ʾ.����.Time;

public class KeHuAddPanel extends JPanel{
	private JTextField keHuDaiMa;		//�ͻ�����
	private JTextField zhuJiMa;			//������
	private JTextField keHuJianCheng;	//�ͻ����
	private JTextField gongSiMingCheng;	//��˾����
	private JTextField diZhi;			//��˾��ַ
	private JTextField dianHua;			//��˾�绰
	private JTextField lianXiRen;		//��ϵ��
	private JTextField lianXiDianHua;	//��ϵ�绰
	private JTextField chuanZhen;		//����
	private JComboBox keHuFenLei;		//�ͻ�����
	private JComboBox keHuXingZhi;		//�ͻ�����
	private JComboBox keHuFenQu;		//�ͻ�����
	private JTextField touDiDiZhi;		//Ͷ�ݵ�ַ
	private JTextField youZhengBianMa;	//��������
	private JComboBox kaiHuYinHang;	//��������
	private JTextField yinHangZhangHao;	//�����˺�
	private JTextField EMail;			//E-Mail
	private JTextField zhuYe;			//��˾��ҳ
	private JTextArea beiZhu;			//��ע
	private JScrollPane bz;				//��ע������
	private JButton resetButton;
	private String code = null;			//�ͻ���������

	public KeHuAddPanel(){
		super();
		//JPanel ��������
		setBounds(10, 10, 300, 350);	//���ò���λ��
		setLayout(new GridBagLayout());	//����Ϊ���񲼾ֹ�����
		setVisible(true);				//������ͼ�ɼ�
		//������̬��ǩ���������ı��������޸�
		final JLabel khDM = new JLabel("�ͻ����룺");			//�ͻ�����
		final JLabel zJM = new JLabel("�����룺");			//������
		final JLabel jc = new JLabel("�ͻ���ƣ�");			//�ͻ����
		final JLabel gsName = new JLabel("��˾���ƣ�");		//��˾����
		final JLabel gsSite = new JLabel("��˾��ַ��");		//��˾��ַ
		final JLabel phone = new JLabel("��˾�绰��");			//��˾�绰
		final JLabel linkMan = new JLabel("��ϵ�ˣ�");		//��ϵ��
		final JLabel linkPhone = new JLabel("��ϵ�绰��");		//��ϵ�绰
		final JLabel fax = new JLabel("����绰��");			//����绰
		final JLabel khFL = new JLabel("�ͻ����ࣺ");			//�ͻ�����
		final JLabel khXZ = new JLabel("�ͻ����ʣ�");			//�ͻ�����
		final JLabel khFQ = new JLabel("�ͻ�������");			//�ͻ�����
		final JLabel touDDZ = new JLabel("Ͷ�ݵ�ַ��");		//Ͷ�ݵ�ַ
		final JLabel yzBM = new JLabel("�������룺");			//��������
		final JLabel khYH = new JLabel("�������У�");			//��������
		final JLabel yhZH = new JLabel("�����˺ţ�");			//�����˺�
		final JLabel email = new JLabel("E-Mail��");			//E-Mail
		final JLabel zy = new JLabel("��ҳ");				//��ҳ
		final JLabel beiZ = new JLabel("��ע��");				//��ע
		//�����ı����Լ��������
		keHuDaiMa = new JTextField();		//�ͻ�����
		code = new Time().getTime();
		keHuDaiMa.setText(code);
		keHuDaiMa.setEditable(false);
		zhuJiMa = new JTextField();			//������
		keHuJianCheng = new JTextField();	//�ͻ����
		gongSiMingCheng = new JTextField();	//��˾����
		diZhi = new JTextField();			//��˾��ַ

		dianHua = new JTextField();			//��˾�绰
		dianHua.addKeyListener(new InputKeyListener());

		lianXiRen = new JTextField();		//��ϵ��

		lianXiDianHua = new JTextField();	//��ϵ�绰
		lianXiDianHua.addKeyListener(new InputKeyListener());

		chuanZhen = new JTextField();		//����
		chuanZhen.addKeyListener(new InputKeyListener());

		keHuFenLei = new JComboBox();		//�ͻ�����

		keHuXingZhi = new JComboBox();		//�ͻ�����
		keHuFenQu = new JComboBox();		//�ͻ�����
		kaiHuYinHang = new JComboBox();	//��������


		initComboBox_fl();
		initComboBox_xz();
		initComboBox_fq();
		initComboBox_yh();

		youZhengBianMa = new JTextField();	//��������
		youZhengBianMa.addKeyListener(new InputKeyListener());
		touDiDiZhi = new JTextField();		//Ͷ�ݵ�ַ
		yinHangZhangHao = new JTextField();	//�����ʺ�
		EMail = new JTextField();			//E-Mail
		zhuYe = new JTextField();			//��ҳ
		beiZhu = new JTextArea();			//��ע
		bz = new JScrollPane(beiZhu);
		//������������̬��ť
		final JButton saveButton = new JButton("����");	//���水ť
		saveButton.addActionListener(new SaveButtonActionListener());	//��Ӽ�����
		resetButton = new JButton("����");				//���ð�ť
		resetButton.addActionListener(new ChongZheButtonActionListener());	//��Ӽ�����
		//��λ ��ǩ���ı��� λ��
		//��һ��
		setupZuJian(khDM, 0, 0, 1, 0, false);
		setupZuJian(keHuDaiMa, 1, 0, 3, 300, true);
		//�ڶ���
		setupZuJian(zJM, 0, 1, 1, 0, false);
		setupZuJian(zhuJiMa, 1, 1, 1, 150, true);
		setupZuJian(jc, 2, 1, 1, 0, false);
		setupZuJian(keHuJianCheng, 3, 1, 1, 150, true);
		//������
		setupZuJian(gsName, 0, 2, 1, 0, false);
		setupZuJian(gongSiMingCheng, 1, 2, 1, 150, true);
		setupZuJian(gsSite, 2, 2, 1, 0, false);
		setupZuJian(diZhi, 3, 2, 1, 150, true);
		//������
		setupZuJian(phone, 0, 3, 1, 0, false);
		setupZuJian(dianHua, 1, 3, 1, 150, true);
		setupZuJian(linkMan, 2, 3, 1, 0, false);
		setupZuJian(lianXiRen, 3, 3, 1, 150, true);
		//������
		setupZuJian(linkPhone, 0, 4, 1, 0, false);
		setupZuJian(lianXiDianHua, 1, 4, 1, 150, true);
		setupZuJian(fax, 2, 4, 1, 0, false);
		setupZuJian(chuanZhen, 3, 4, 1, 150, true);
		//������
		setupZuJian(khFL, 0, 5, 1, 0, false);
		setupZuJian(keHuFenLei, 1, 5, 1, 150, true);
		setupZuJian(khXZ, 2, 5, 1, 0, false);
		setupZuJian(keHuXingZhi, 3, 5, 1, 150, true);
		//������
		setupZuJian(khFQ, 0, 6, 1, 0, false);
		setupZuJian(keHuFenQu, 1, 6, 1, 150, true);
		setupZuJian(khYH, 2, 6, 1, 0, false);
		setupZuJian(kaiHuYinHang, 3, 6, 1, 150, true);

		//��8��
		setupZuJian(yzBM, 0, 7, 1, 0, false);
		setupZuJian(youZhengBianMa, 1, 7, 1, 150, true);
		setupZuJian(touDDZ, 2, 7, 1, 0, false);
		setupZuJian(touDiDiZhi, 3, 7, 1, 150, true);
		//��9��
		setupZuJian(yhZH, 0, 8, 1, 0, false);
		setupZuJian(yinHangZhangHao, 1, 8, 1, 150, true);
		setupZuJian(email, 2, 8, 1, 0, false);
		setupZuJian(EMail, 3, 8, 1, 150, true);
		//��10��
		setupZuJian(zy, 0, 9, 1, 0, false);
		setupZuJian(zhuYe, 1, 9, 3, 300, true);
		//��11��
		setupZuJian(beiZ, 0, 10, 1, 0, false);
		setupZuJian(bz, 1, 10, 3, 300, true);
		//��λ ��ť λ��
		setupZuJian(saveButton, 1, 14, 1, 0, false);
		setupZuJian(resetButton, 3, 14, 1, 0, false);

	}
	// �������λ�ò���ӵ�������
	private void setupZuJian(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		gridBagConstrains.insets = new Insets(3, 1, 2, 1);
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		if(component==bz){
			beiZhu.setLineWrap(true);
			gridBagConstrains.gridheight = 3;
			gridBagConstrains.ipadx = ipadx;
			gridBagConstrains.ipady = 50;
		}
		add(component, gridBagConstrains);
	}

	private final class SaveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(final ActionEvent e) {
			// TODO �Զ����ɵķ������
			if(zhuJiMa.getText().equals("")
					||keHuJianCheng.getText().equals("")
					||gongSiMingCheng.getText().equals("")
					||diZhi.getText().equals("")
					||dianHua.getText().equals("")
					||lianXiRen.getText().equals("")
					||lianXiDianHua.getText().equals("")
					||keHuFenLei.getSelectedItem().equals("")
					||keHuXingZhi.getSelectedItem().equals("")
					||keHuFenQu.getSelectedItem().equals("")
					||touDiDiZhi.getText().equals("")
					||youZhengBianMa.getText().equals("")
					||kaiHuYinHang.getSelectedItem().equals("")
					||yinHangZhangHao.getText().equals("")){
				JOptionPane.showMessageDialog(null, "����дȫ����Ϣ");
				return;
			}
			ResultSet haveUser = DaoRu
					.query("select * from tb_khinfo where companyName='"
							+ gongSiMingCheng.getText().trim() + "'");
			try {
				if (haveUser.next()){
					System.out.println("error");
					JOptionPane.showMessageDialog(KeHuAddPanel.this,
							"�ͻ���Ϣ���ʧ�ܣ�����ͬ���ͻ�", "�ͻ������Ϣ",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			} catch (Exception er) {
				er.printStackTrace();
			}
			ResultSet set = DaoRu.query("select max(id) from tb_khinfo");
			String id = null;
			try {
				if (set != null && set.next()) {
					String sid = set.getString(1);
					if (sid == null)
						id = "kh1001";
					else {
						String str = sid.substring(2);
						id = "kh" + (Integer.parseInt(str) + 1);
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			TbKhXinX khinfo = new TbKhXinX();
			khinfo.setId(id);
			khinfo.setCustomerCode(code);
			khinfo.setPyCode(zhuJiMa.getText().trim());
			khinfo.setCustomerName(keHuJianCheng.getText().trim());
			khinfo.setName(gongSiMingCheng.getText().trim());
			khinfo.setCompanySite(diZhi.getText().trim());
			khinfo.setCompanyPhone(dianHua.getText().trim());
			khinfo.setLinkman(lianXiRen.getText().trim());
			khinfo.setLinkPhone(lianXiDianHua.getText().trim());
			khinfo.setFax(chuanZhen.getText().trim());
			khinfo.setCustomerSort(keHuFenLei.getSelectedItem().toString());
			khinfo.setCustomerQuale(keHuXingZhi.getSelectedItem().toString());
			khinfo.setCustomerZone(keHuFenQu.getSelectedItem().toString());
			khinfo.setAddress(touDiDiZhi.getText().trim());
			khinfo.setZipCode(youZhengBianMa.getText().trim());
			khinfo.setBankName(kaiHuYinHang.getSelectedItem().toString());
			khinfo.setBankAccout(yinHangZhangHao.getText().trim());
			khinfo.setEmail(EMail.getText().trim());
			khinfo.setCompanyHomePage(zhuYe.getText().trim());
			khinfo.setRemark(beiZhu.getText().trim());
			DaoRu.addKeHu(khinfo);
			JOptionPane.showMessageDialog(KeHuAddPanel.this, "�ѳɹ���ӿͻ�",
					"�ͻ������Ϣ", JOptionPane.INFORMATION_MESSAGE);
			resetButton.doClick();
		}
	}
	// ���ð�ť���¼�������
	private class ChongZheButtonActionListener implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			code = new Time().getTime();
			keHuDaiMa.setText(code);
			zhuJiMa.setText("");
			keHuJianCheng.setText("");
			gongSiMingCheng.setText("");
			diZhi.setText("");
			dianHua.setText("");
			lianXiRen.setText("");
			lianXiDianHua.setText("");
			chuanZhen.setText("");
			keHuFenLei.getSelectedIndex();
			keHuXingZhi.getSelectedIndex();
			keHuFenQu.getSelectedIndex();
			touDiDiZhi.setText("");
			youZhengBianMa.setText("");
			kaiHuYinHang.getSelectedIndex();
			yinHangZhangHao.setText("");
			EMail.setText("");
			zhuYe.setText("");
			beiZhu.setText("");
		}
	}
	public void initComboBox_fl(){
		List khxx_fl = DaoRu.getDictionary_cz("�ͻ�����");                 //����getGysInfos()������ȡ��Ӧ���б�
		List<Item> items = new ArrayList<Item>();                  //����Item�б�
		keHuFenLei.removeAllItems();                                      //��������б����ԭ�е�ѡ��
		for (Iterator iter = khxx_fl.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item();                                //��װ��Ӧ����Ϣ
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item))                             //���Items�б��а����ù�Ӧ�̵ķ�װ����
				continue;                                         //��������ѭ��
			items.add(item);                                      //������Ӹö��������б����
			keHuFenLei.addItem(item);
		}




	}
	public void initComboBox_xz(){
		List khxx_xz = DaoRu.getDictionary_cz("�ͻ�����");
		List<Item> items = new ArrayList<Item>();                  //����Item�б�
		keHuXingZhi.removeAllItems();
		for (Iterator iter = khxx_xz.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item();                                //��װ��Ӧ����Ϣ
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item))                             //���Items�б��а����ù�Ӧ�̵ķ�װ����
				continue;                                         //��������ѭ��
			items.add(item);                                      //������Ӹö��������б����
			keHuXingZhi.addItem(item);
		}
	}
	public void initComboBox_fq(){
		List khxx_fq = DaoRu.getDictionary_cz("�ͻ�����");
		List<Item> items = new ArrayList<Item>();                  //����Item�б�
		keHuFenQu.removeAllItems();
		for (Iterator iter = khxx_fq.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item();                                //��װ��Ӧ����Ϣ
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item))                             //���Items�б��а����ù�Ӧ�̵ķ�װ����
				continue;                                         //��������ѭ��
			items.add(item);                                      //������Ӹö��������б����
			keHuFenQu.addItem(item);
		}
	}
	public void initComboBox_yh(){
		List khxx_yh = DaoRu.getDictionary_cz("��������");
		List<Item> items = new ArrayList<Item>();                  //����Item�б�
		kaiHuYinHang.removeAllItems();
		for (Iterator iter = khxx_yh.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item();                                //��װ��Ӧ����Ϣ
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item))                             //���Items�б��а����ù�Ӧ�̵ķ�װ����
				continue;                                         //��������ѭ��
			items.add(item);                                      //������Ӹö��������б����
			kaiHuYinHang.addItem(item);
		}
	}
}
