package ϵͳ��ʾ.������Ϣ����.�ͻ���Ϣ����;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
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
import ���ݿ�ģ��.TbGysinfo;
import ���ݿ�ģ��.TbKhXinX;
import ϵͳ��ʾ.���ݿ���Ϣ.DaoRu;
import ϵͳ��ʾ.����.Item;

public class KeHuAlterPanel extends JPanel {
	private JTextField keHuDaiMa; // �ͻ�����
	private JTextField zhuJiMa; // ������
	private JTextField keHuJianCheng; // �ͻ����
	private JTextField gongSiMingCheng; // ��˾����
	private JTextField diZhi; // ��˾��ַ
	private JTextField dianHua; // ��˾�绰
	private JTextField lianXiRen; // ��ϵ��
	private JTextField lianXiDianHua; // ��ϵ�绰
	private JTextField chuanZhen; // ����
	private JComboBox keHuFenLei; // �ͻ�����
	private JComboBox keHuXingZhi; // �ͻ�����
	private JComboBox keHuFenQu; // �ͻ�����
	private JComboBox kaiHuYinHang; // ��������
	private JTextField touDiDiZhi; // Ͷ�ݵ�ַ
	private JTextField youZhengBianMa; // ��������
	private JTextField yinHangZhangHao; // �����˺�
	private JTextField EMail; // E-Mail
	private JTextField zhuYe; // ��˾��ҳ
	private JTextArea beiZhu; // ��ע
	private JScrollPane bz; // ��ע������
	private JButton modifyButton;
	private JButton delButton;
	private JComboBox kehu;

	public KeHuAlterPanel() {
		// ���淽��
		setBounds(10, 10, 300, 350); // ����λ���Լ���С
		setLayout(new GridBagLayout()); // �������񲼾ֹ�����
		setVisible(true); // ������ͼ�ɼ�
		// ������̬��ǩ���������ı��������޸�
		final JLabel khDM = new JLabel("�ͻ����룺"); // �ͻ�����
		final JLabel zJM = new JLabel("�����룺"); // ������
		final JLabel jc = new JLabel("�ͻ���ƣ�"); // �ͻ����
		final JLabel gsName = new JLabel("��˾���ƣ�"); // ��˾����
		final JLabel gsSite = new JLabel("��˾��ַ��"); // ��˾��ַ
		final JLabel phone = new JLabel("��˾�绰��"); // ��˾�绰
		final JLabel linkMan = new JLabel("��ϵ�ˣ�"); // ��ϵ��
		final JLabel linkPhone = new JLabel("��ϵ�绰��"); // ��ϵ�绰
		final JLabel fax = new JLabel("����绰��"); // ����绰
		final JLabel khFL = new JLabel("�ͻ����ࣺ"); // �ͻ�����
		final JLabel khXZ = new JLabel("�ͻ����ʣ�"); // �ͻ�����
		final JLabel khFQ = new JLabel("�ͻ�������"); // �ͻ�����
		final JLabel touDDZ = new JLabel("Ͷ�ݵ�ַ��"); // Ͷ�ݵ�ַ
		final JLabel yzBM = new JLabel("�������룺"); // ��������
		final JLabel khYH = new JLabel("�������У�"); // ��������
		final JLabel yhZH = new JLabel("�����˺ţ�"); // �����˺�
		final JLabel email = new JLabel("E-Mail��"); // E-Mail
		final JLabel zy = new JLabel("��ҳ"); // ��ҳ
		final JLabel beiZ = new JLabel("��ע��"); // ��ע
		final JLabel xzKH = new JLabel("ѡ��ͻ�"); // ѡ��ͻ�
		// �����ı����Լ��������
		keHuDaiMa = new JTextField(); // �ͻ�����
		zhuJiMa = new JTextField(); // ������
		keHuJianCheng = new JTextField(); // �ͻ����
		gongSiMingCheng = new JTextField(); // ��˾����
		diZhi = new JTextField(); // ��˾��ַ
		dianHua = new JTextField(); // ��˾�绰
		dianHua.addKeyListener(new InputKeyListener());

		lianXiRen = new JTextField(); // ��ϵ��
		lianXiDianHua = new JTextField(); // ��ϵ�绰
		lianXiDianHua.addKeyListener(new InputKeyListener());

		chuanZhen = new JTextField(); // ����
		chuanZhen.addKeyListener(new InputKeyListener());

		keHuFenLei = new JComboBox(); // �ͻ�����
		keHuXingZhi = new JComboBox(); // �ͻ�����
		keHuFenQu = new JComboBox(); // �ͻ�����
		kaiHuYinHang = new JComboBox(); // ��������

		touDiDiZhi = new JTextField(); // Ͷ�ݵ�ַ
		youZhengBianMa = new JTextField(); // ��������
		youZhengBianMa.addKeyListener(new InputKeyListener());

		yinHangZhangHao = new JTextField(); // �����ʺ�
		EMail = new JTextField(); // E-Mail
		zhuYe = new JTextField(); // ��ҳ
		beiZhu = new JTextArea(); // ��ע
		bz = new JScrollPane(beiZhu);
		// ���� ��ť
		modifyButton = new JButton("�޸�");
		delButton = new JButton("ɾ��");
		// ���������� �м�����
		JPanel panel = new JPanel();
		// �Ѱ�ť��ӵ��м�������
		panel.add(modifyButton);
		panel.add(delButton);
		// ����ɾ����ť�ĵ����¼�
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();
				if (item == null || !(item instanceof Item))
					return;
				int confirm = JOptionPane.showConfirmDialog(
						KeHuAlterPanel.this, "ȷ��ɾ���ͻ���Ϣ��");
				if (confirm == JOptionPane.YES_OPTION) {
					int rs = DaoRu.delete("delete tb_khinfo where id='"
							+ item.getId() + "'");
					if (rs > 0) {
						JOptionPane.showMessageDialog(KeHuAlterPanel.this,
								"�ͻ���" + item.getName() + "��ɾ���ɹ�");
						kehu.removeItem(item);
					}
				}
			}
		});
		// �����޸İ�ť�ĵ����¼�
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();
				TbKhXinX khinfo = new TbKhXinX();
				khinfo.setId(item.getId());
				khinfo.setCustomerCode(keHuDaiMa.getText().trim());
				khinfo.setPyCode(zhuJiMa.getText().trim());
				khinfo.setCustomerName(keHuJianCheng.getText().trim());
				khinfo.setName(gongSiMingCheng.getText().trim());
				khinfo.setCompanySite(diZhi.getText().trim());
				khinfo.setCompanyPhone(dianHua.getText().trim());
				khinfo.setLinkman(lianXiRen.getText().trim());
				khinfo.setLinkPhone(lianXiDianHua.getText().trim());
				khinfo.setFax(chuanZhen.getText().trim());
				khinfo.setCustomerSort(keHuFenLei.getSelectedItem().toString());
				khinfo.setCustomerQuale(keHuXingZhi.getSelectedItem()
						.toString());
				khinfo.setCustomerZone(keHuFenQu.getSelectedItem().toString());
				khinfo.setAddress(touDiDiZhi.getText().trim());
				khinfo.setZipCode(youZhengBianMa.getText().trim());
				khinfo.setBankName(kaiHuYinHang.getSelectedItem().toString());
				khinfo.setBankAccout(yinHangZhangHao.getText().trim());
				khinfo.setEmail(EMail.getText().trim());
				khinfo.setCompanyHomePage(zhuYe.getText().trim());
				khinfo.setRemark(beiZhu.getText().trim());
				if (DaoRu.updateKeHu(khinfo) == 1)
					JOptionPane.showMessageDialog(KeHuAlterPanel.this, "�޸����");
				else
					JOptionPane.showMessageDialog(KeHuAlterPanel.this, "�޸�ʧ��");
			}
		});
		// ���� �����˵�
		kehu = new JComboBox();
		initComboBox();// ��ʼ������ѡ���

		// ����ͻ���Ϣ������ѡ����ѡ���¼�
		kehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKeHuSelectAction();
			}
		});

		initComboBox_fl();
		initComboBox_xz();
		initComboBox_fq();
		initComboBox_yh();
		// ��������
		gongSiMingCheng.setEditable(false); // �����ı����ɱ༭
		keHuDaiMa.setEditable(false); // �����ı����ɱ༭
		kehu.setPreferredSize(new Dimension(230, 21));
		// ��λ ��ǩ���ı��� λ��
		// ��һ��
		setupZuJian(khDM, 0, 0, 1, 0, false);
		setupZuJian(keHuDaiMa, 1, 0, 3, 300, true);
		// �ڶ���
		setupZuJian(zJM, 0, 1, 1, 0, false);
		setupZuJian(zhuJiMa, 1, 1, 1, 150, true);
		setupZuJian(jc, 2, 1, 1, 0, false);
		setupZuJian(keHuJianCheng, 3, 1, 1, 150, true);
		// ������
		setupZuJian(gsName, 0, 2, 1, 0, false);
		setupZuJian(gongSiMingCheng, 1, 2, 1, 150, true);
		setupZuJian(gsSite, 2, 2, 1, 0, false);
		setupZuJian(diZhi, 3, 2, 1, 150, true);
		// ������
		setupZuJian(phone, 0, 3, 1, 0, false);
		setupZuJian(dianHua, 1, 3, 1, 150, true);
		setupZuJian(linkMan, 2, 3, 1, 0, false);
		setupZuJian(lianXiRen, 3, 3, 1, 150, true);
		// ������
		setupZuJian(linkPhone, 0, 4, 1, 0, false);
		setupZuJian(lianXiDianHua, 1, 4, 1, 150, true);
		setupZuJian(fax, 2, 4, 1, 0, false);
		setupZuJian(chuanZhen, 3, 4, 1, 150, true);
		// ������
		setupZuJian(khFL, 0, 5, 1, 0, false);
		setupZuJian(keHuFenLei, 1, 5, 1, 150, true);
		setupZuJian(khXZ, 2, 5, 1, 0, false);
		setupZuJian(keHuXingZhi, 3, 5, 1, 150, true);
		// ������
		setupZuJian(khFQ, 0, 6, 1, 0, false);
		setupZuJian(keHuFenQu, 1, 6, 1, 150, true);
		setupZuJian(khYH, 2, 6, 1, 0, false);
		setupZuJian(kaiHuYinHang, 3, 6, 1, 150, true);
		// ��8��
		setupZuJian(yzBM, 0, 7, 1, 0, false);
		setupZuJian(youZhengBianMa, 1, 7, 1, 150, true);
		setupZuJian(touDDZ, 2, 7, 1, 0, false);
		setupZuJian(touDiDiZhi, 3, 7, 1, 150, true);
		// ��9��
		setupZuJian(yhZH, 0, 8, 1, 0, false);
		setupZuJian(yinHangZhangHao, 1, 8, 1, 150, true);
		setupZuJian(email, 2, 8, 1, 0, false);
		setupZuJian(EMail, 3, 8, 1, 150, true);
		// ��10��
		setupZuJian(zy, 0, 9, 1, 0, false);
		setupZuJian(zhuYe, 1, 9, 3, 300, true);
		// ��11��
		setupZuJian(beiZ, 0, 10, 1, 0, false);
		setupZuJian(bz, 1, 10, 3, 300, true);
		// ��12��
		setupZuJian(xzKH, 0, 13, 1, 0, false);
		setupZuJian(kehu, 1, 13, 2, 0, true);
		// ��λ �м�������2����ť�� λ��
		setupZuJian(panel, 3, 13, 1, 0, false);
		// ��λ�ͻ���Ϣ������ѡ���

	}

	// �������λ�ò���ӵ�������
	private void setupZuJian(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		gridBagConstrains.insets = new Insets(3, 1, 2, 1);
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		if (component == bz) {
			beiZhu.setLineWrap(true);
			gridBagConstrains.gridheight = 3;
			gridBagConstrains.ipadx = ipadx;
			gridBagConstrains.ipady = 50;

		}
		add(component, gridBagConstrains);
	}

	// ��ʼ���ͻ�����ѡ���
	public void initComboBox() {
		List khInfo = DaoRu.getKhInfos();
		List<Item> items = new ArrayList<Item>();
		kehu.removeAllItems();
		for (Iterator iter = khInfo.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item))
				continue;
			items.add(item);
			kehu.addItem(item);
		}
		doKeHuSelectAction();
	}

	private void doKeHuSelectAction() {
		Item selectedItem;
		if (!(kehu.getSelectedItem() instanceof Item)) {
			return;
		}
		selectedItem = (Item) kehu.getSelectedItem();
		TbKhXinX khInfo = DaoRu.getKhInfo(selectedItem);
		keHuDaiMa.setText(khInfo.getCustomerCode());
		zhuJiMa.setText(khInfo.getPyCode());
		keHuJianCheng.setText(khInfo.getCustomerName());
		gongSiMingCheng.setText(khInfo.getName());
		diZhi.setText(khInfo.getCompanySite());
		dianHua.setText(khInfo.getCompanyPhone());
		lianXiRen.setText(khInfo.getLinkman());
		lianXiDianHua.setText(khInfo.getLinkPhone());
		chuanZhen.setText(khInfo.getFax());
		// ���ÿͻ�����������ǰѡ��
		Item item = new Item();
		item.setId(null);
		item.setName(khInfo.getCustomerSort());
		TbDictionary dictionary = DaoRu.getDictionary(item);
		item.setId(dictionary.getId());
		item.setName(dictionary.getValueName());
		for (int i = 0; i < keHuFenLei.getItemCount(); i++) {
			Item khfl = (Item) keHuFenLei.getItemAt(i);
			if (khfl.getName().equals(item.getName())) {
				item = khfl;
			}
		}
		keHuFenLei.setSelectedItem(item);
		// ���ÿͻ�����������ǰѡ��
		Item item_1 = new Item();
		item_1.setId(null);
		item_1.setName(khInfo.getCustomerQuale());
		TbDictionary dictionary_1 = DaoRu.getDictionary(item_1);
		item_1.setId(dictionary_1.getId());
		item_1.setName(dictionary_1.getValueName());
		for (int i = 0; i < keHuXingZhi.getItemCount(); i++) {
			Item khxz = (Item) keHuXingZhi.getItemAt(i);
			if (khxz.getName().equals(item_1.getName())) {
				item_1 = khxz;
			}
		}
		keHuXingZhi.setSelectedItem(item_1);
		// ���ÿͻ�����������ǰѡ��
		Item item_2 = new Item();
		item_2.setId(null);
		item_2.setName(khInfo.getCustomerZone());
		TbDictionary dictionary_2 = DaoRu.getDictionary(item_2);
		item_2.setId(dictionary_2.getId());
		item_2.setName(dictionary_2.getValueName());
		for (int i = 0; i < keHuFenQu.getItemCount(); i++) {
			Item khfq = (Item) keHuFenQu.getItemAt(i);
			if (khfq.getName().equals(item_2.getName())) {
				item_2 = khfq;
			}
		}
		keHuFenQu.setSelectedItem(item_2);
		// ���ÿ�������������ǰѡ��
		Item item_3 = new Item();
		item_3.setId(null);
		item_3.setName(khInfo.getBankName());
		TbDictionary dictionary_3 = DaoRu.getDictionary(item_3);
		item_3.setId(dictionary_3.getId());
		item_3.setName(dictionary_3.getValueName());
		for (int i = 0; i < kaiHuYinHang.getItemCount(); i++) {
			Item khyh = (Item) kaiHuYinHang.getItemAt(i);
			if (khyh.getName().equals(item_3.getName())) {
				item_3 = khyh;
			}
		}
		kaiHuYinHang.setSelectedItem(item_3);
		kaiHuYinHang.getSelectedItem();
		touDiDiZhi.setText(khInfo.getAddress());
		youZhengBianMa.setText(khInfo.getZipCode());
		yinHangZhangHao.setText(khInfo.getBankAccout());
		EMail.setText(khInfo.getEmail());
		zhuYe.setText(khInfo.getCompanyHomePage());
		beiZhu.setText(khInfo.getRemark());
	}

	public void initComboBox_fl() {
		List khxx_fl = DaoRu.getDictionary_cz("�ͻ�����"); // ����getGysInfos()������ȡ��Ӧ���б�
		List<Item> items = new ArrayList<Item>(); // ����Item�б�
		keHuFenLei.removeAllItems(); // ��������б����ԭ�е�ѡ��
		for (Iterator iter = khxx_fl.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item(); // ��װ��Ӧ����Ϣ
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item)) // ���Items�б��а����ù�Ӧ�̵ķ�װ����
				continue; // ��������ѭ��
			items.add(item); // ������Ӹö��������б����
			keHuFenLei.addItem(item);
		}
	}

	public void initComboBox_xz() {
		List khxx_xz = DaoRu.getDictionary_cz("�ͻ�����");
		List<Item> items = new ArrayList<Item>(); // ����Item�б�
		keHuXingZhi.removeAllItems();
		for (Iterator iter = khxx_xz.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item(); // ��װ��Ӧ����Ϣ
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item)) // ���Items�б��а����ù�Ӧ�̵ķ�װ����
				continue; // ��������ѭ��
			items.add(item); // ������Ӹö��������б����
			keHuXingZhi.addItem(item);
		}
		doKeHuSelectAction();
	}

	public void initComboBox_fq() {
		List khxx_fq = DaoRu.getDictionary_cz("�ͻ�����");
		List<Item> items = new ArrayList<Item>(); // ����Item�б�
		keHuFenQu.removeAllItems();
		for (Iterator iter = khxx_fq.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item(); // ��װ��Ӧ����Ϣ
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item)) // ���Items�б��а����ù�Ӧ�̵ķ�װ����
				continue; // ��������ѭ��
			items.add(item); // ������Ӹö��������б����
			keHuFenQu.addItem(item);
		}
		doKeHuSelectAction();
	}

	public void initComboBox_yh() {
		List khxx_yh = DaoRu.getDictionary_cz("��������");
		List<Item> items = new ArrayList<Item>(); // ����Item�б�
		kaiHuYinHang.removeAllItems();
		for (Iterator iter = khxx_yh.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item(); // ��װ��Ӧ����Ϣ
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item)) // ���Items�б��а����ù�Ӧ�̵ķ�װ����
				continue; // ��������ѭ��
			items.add(item); // ������Ӹö��������б����
			kaiHuYinHang.addItem(item);
		}
		doKeHuSelectAction();
	}
}
