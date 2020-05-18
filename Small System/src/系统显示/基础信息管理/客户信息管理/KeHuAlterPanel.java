package 系统显示.基础信息管理.客户信息管理;

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

import 关键字监听器.InputKeyListener;
import 数据库模型.TbDictionary;
import 数据库模型.TbGysinfo;
import 数据库模型.TbKhXinX;
import 系统显示.数据库信息.DaoRu;
import 系统显示.管理.Item;

public class KeHuAlterPanel extends JPanel {
	private JTextField keHuDaiMa; // 客户代码
	private JTextField zhuJiMa; // 助记码
	private JTextField keHuJianCheng; // 客户简称
	private JTextField gongSiMingCheng; // 公司名称
	private JTextField diZhi; // 公司地址
	private JTextField dianHua; // 公司电话
	private JTextField lianXiRen; // 联系人
	private JTextField lianXiDianHua; // 联系电话
	private JTextField chuanZhen; // 传真
	private JComboBox keHuFenLei; // 客户分类
	private JComboBox keHuXingZhi; // 客户性质
	private JComboBox keHuFenQu; // 客户分区
	private JComboBox kaiHuYinHang; // 开户银行
	private JTextField touDiDiZhi; // 投递地址
	private JTextField youZhengBianMa; // 邮政编码
	private JTextField yinHangZhangHao; // 银行账号
	private JTextField EMail; // E-Mail
	private JTextField zhuYe; // 公司主页
	private JTextArea beiZhu; // 备注
	private JScrollPane bz; // 备注滚动条
	private JButton modifyButton;
	private JButton delButton;
	private JComboBox kehu;

	public KeHuAlterPanel() {
		// 界面方法
		setBounds(10, 10, 300, 350); // 设置位置以及大小
		setLayout(new GridBagLayout()); // 设置网格布局管理器
		setVisible(true); // 设置视图可见
		// 创建终态标签，并设置文本，不可修改
		final JLabel khDM = new JLabel("客户代码："); // 客户代码
		final JLabel zJM = new JLabel("助记码："); // 助记码
		final JLabel jc = new JLabel("客户简称："); // 客户简称
		final JLabel gsName = new JLabel("公司名称："); // 公司名称
		final JLabel gsSite = new JLabel("公司地址："); // 公司地址
		final JLabel phone = new JLabel("公司电话："); // 公司电话
		final JLabel linkMan = new JLabel("联系人："); // 联系人
		final JLabel linkPhone = new JLabel("联系电话："); // 联系电话
		final JLabel fax = new JLabel("传真电话："); // 传真电话
		final JLabel khFL = new JLabel("客户分类："); // 客户分类
		final JLabel khXZ = new JLabel("客户性质："); // 客户性质
		final JLabel khFQ = new JLabel("客户分区："); // 客户分区
		final JLabel touDDZ = new JLabel("投递地址："); // 投递地址
		final JLabel yzBM = new JLabel("邮政编码："); // 邮政编码
		final JLabel khYH = new JLabel("开户银行："); // 开户银行
		final JLabel yhZH = new JLabel("银行账号："); // 银行账号
		final JLabel email = new JLabel("E-Mail："); // E-Mail
		final JLabel zy = new JLabel("主页"); // 主页
		final JLabel beiZ = new JLabel("备注："); // 备注
		final JLabel xzKH = new JLabel("选择客户"); // 选择客户
		// 构建文本框以及各种组件
		keHuDaiMa = new JTextField(); // 客户代码
		zhuJiMa = new JTextField(); // 助记码
		keHuJianCheng = new JTextField(); // 客户简称
		gongSiMingCheng = new JTextField(); // 公司名称
		diZhi = new JTextField(); // 公司地址
		dianHua = new JTextField(); // 公司电话
		dianHua.addKeyListener(new InputKeyListener());

		lianXiRen = new JTextField(); // 联系人
		lianXiDianHua = new JTextField(); // 联系电话
		lianXiDianHua.addKeyListener(new InputKeyListener());

		chuanZhen = new JTextField(); // 传真
		chuanZhen.addKeyListener(new InputKeyListener());

		keHuFenLei = new JComboBox(); // 客户分类
		keHuXingZhi = new JComboBox(); // 客户性质
		keHuFenQu = new JComboBox(); // 客户分区
		kaiHuYinHang = new JComboBox(); // 开户银行

		touDiDiZhi = new JTextField(); // 投递地址
		youZhengBianMa = new JTextField(); // 邮政编码
		youZhengBianMa.addKeyListener(new InputKeyListener());

		yinHangZhangHao = new JTextField(); // 银行帐号
		EMail = new JTextField(); // E-Mail
		zhuYe = new JTextField(); // 主页
		beiZhu = new JTextArea(); // 备注
		bz = new JScrollPane(beiZhu);
		// 构建 按钮
		modifyButton = new JButton("修改");
		delButton = new JButton("删除");
		// 声明并构建 中间容器
		JPanel panel = new JPanel();
		// 把按钮添加到中间容器中
		panel.add(modifyButton);
		panel.add(delButton);
		// 处理删除按钮的单击事件
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();
				if (item == null || !(item instanceof Item))
					return;
				int confirm = JOptionPane.showConfirmDialog(
						KeHuAlterPanel.this, "确认删除客户信息吗？");
				if (confirm == JOptionPane.YES_OPTION) {
					int rs = DaoRu.delete("delete tb_khinfo where id='"
							+ item.getId() + "'");
					if (rs > 0) {
						JOptionPane.showMessageDialog(KeHuAlterPanel.this,
								"客户：" + item.getName() + "。删除成功");
						kehu.removeItem(item);
					}
				}
			}
		});
		// 处理修改按钮的单击事件
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
					JOptionPane.showMessageDialog(KeHuAlterPanel.this, "修改完成");
				else
					JOptionPane.showMessageDialog(KeHuAlterPanel.this, "修改失败");
			}
		});
		// 构建 下拉菜单
		kehu = new JComboBox();
		initComboBox();// 初始化下拉选择框

		// 处理客户信息的下拉选择框的选择事件
		kehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKeHuSelectAction();
			}
		});

		initComboBox_fl();
		initComboBox_xz();
		initComboBox_fq();
		initComboBox_yh();
		// 属性设置
		gongSiMingCheng.setEditable(false); // 设置文本不可编辑
		keHuDaiMa.setEditable(false); // 设置文本不可编辑
		kehu.setPreferredSize(new Dimension(230, 21));
		// 定位 标签与文本框 位置
		// 第一行
		setupZuJian(khDM, 0, 0, 1, 0, false);
		setupZuJian(keHuDaiMa, 1, 0, 3, 300, true);
		// 第二行
		setupZuJian(zJM, 0, 1, 1, 0, false);
		setupZuJian(zhuJiMa, 1, 1, 1, 150, true);
		setupZuJian(jc, 2, 1, 1, 0, false);
		setupZuJian(keHuJianCheng, 3, 1, 1, 150, true);
		// 第三行
		setupZuJian(gsName, 0, 2, 1, 0, false);
		setupZuJian(gongSiMingCheng, 1, 2, 1, 150, true);
		setupZuJian(gsSite, 2, 2, 1, 0, false);
		setupZuJian(diZhi, 3, 2, 1, 150, true);
		// 第四行
		setupZuJian(phone, 0, 3, 1, 0, false);
		setupZuJian(dianHua, 1, 3, 1, 150, true);
		setupZuJian(linkMan, 2, 3, 1, 0, false);
		setupZuJian(lianXiRen, 3, 3, 1, 150, true);
		// 第五行
		setupZuJian(linkPhone, 0, 4, 1, 0, false);
		setupZuJian(lianXiDianHua, 1, 4, 1, 150, true);
		setupZuJian(fax, 2, 4, 1, 0, false);
		setupZuJian(chuanZhen, 3, 4, 1, 150, true);
		// 第六行
		setupZuJian(khFL, 0, 5, 1, 0, false);
		setupZuJian(keHuFenLei, 1, 5, 1, 150, true);
		setupZuJian(khXZ, 2, 5, 1, 0, false);
		setupZuJian(keHuXingZhi, 3, 5, 1, 150, true);
		// 第七行
		setupZuJian(khFQ, 0, 6, 1, 0, false);
		setupZuJian(keHuFenQu, 1, 6, 1, 150, true);
		setupZuJian(khYH, 2, 6, 1, 0, false);
		setupZuJian(kaiHuYinHang, 3, 6, 1, 150, true);
		// 第8行
		setupZuJian(yzBM, 0, 7, 1, 0, false);
		setupZuJian(youZhengBianMa, 1, 7, 1, 150, true);
		setupZuJian(touDDZ, 2, 7, 1, 0, false);
		setupZuJian(touDiDiZhi, 3, 7, 1, 150, true);
		// 第9行
		setupZuJian(yhZH, 0, 8, 1, 0, false);
		setupZuJian(yinHangZhangHao, 1, 8, 1, 150, true);
		setupZuJian(email, 2, 8, 1, 0, false);
		setupZuJian(EMail, 3, 8, 1, 150, true);
		// 第10行
		setupZuJian(zy, 0, 9, 1, 0, false);
		setupZuJian(zhuYe, 1, 9, 3, 300, true);
		// 第11行
		setupZuJian(beiZ, 0, 10, 1, 0, false);
		setupZuJian(bz, 1, 10, 3, 300, true);
		// 第12行
		setupZuJian(xzKH, 0, 13, 1, 0, false);
		setupZuJian(kehu, 1, 13, 2, 0, true);
		// 定位 中间容器（2个按钮） 位置
		setupZuJian(panel, 3, 13, 1, 0, false);
		// 定位客户信息的下拉选择框

	}

	// 设置组件位置并添加到容器中
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

	// 初始化客户下拉选择框
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
		// 设置客户分类下拉框当前选项
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
		// 设置客户性质下拉框当前选项
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
		// 设置客户分区下拉框当前选项
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
		// 设置开户银行下拉框当前选项
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
		List khxx_fl = DaoRu.getDictionary_cz("客户分类"); // 调用getGysInfos()方法获取供应商列表
		List<Item> items = new ArrayList<Item>(); // 创建Item列表
		keHuFenLei.removeAllItems(); // 清除下拉列表框中原有的选项
		for (Iterator iter = khxx_fl.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item(); // 封装供应商信息
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item)) // 如果Items列表中包含该供应商的封装对象
				continue; // 跳出本次循环
			items.add(item); // 否则添加该对象到下拉列表框中
			keHuFenLei.addItem(item);
		}
	}

	public void initComboBox_xz() {
		List khxx_xz = DaoRu.getDictionary_cz("客户性质");
		List<Item> items = new ArrayList<Item>(); // 创建Item列表
		keHuXingZhi.removeAllItems();
		for (Iterator iter = khxx_xz.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item(); // 封装供应商信息
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item)) // 如果Items列表中包含该供应商的封装对象
				continue; // 跳出本次循环
			items.add(item); // 否则添加该对象到下拉列表框中
			keHuXingZhi.addItem(item);
		}
		doKeHuSelectAction();
	}

	public void initComboBox_fq() {
		List khxx_fq = DaoRu.getDictionary_cz("客户分区");
		List<Item> items = new ArrayList<Item>(); // 创建Item列表
		keHuFenQu.removeAllItems();
		for (Iterator iter = khxx_fq.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item(); // 封装供应商信息
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item)) // 如果Items列表中包含该供应商的封装对象
				continue; // 跳出本次循环
			items.add(item); // 否则添加该对象到下拉列表框中
			keHuFenQu.addItem(item);
		}
		doKeHuSelectAction();
	}

	public void initComboBox_yh() {
		List khxx_yh = DaoRu.getDictionary_cz("开户银行");
		List<Item> items = new ArrayList<Item>(); // 创建Item列表
		kaiHuYinHang.removeAllItems();
		for (Iterator iter = khxx_yh.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item(); // 封装供应商信息
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item)) // 如果Items列表中包含该供应商的封装对象
				continue; // 跳出本次循环
			items.add(item); // 否则添加该对象到下拉列表框中
			kaiHuYinHang.addItem(item);
		}
		doKeHuSelectAction();
	}
}
