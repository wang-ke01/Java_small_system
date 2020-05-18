package 系统显示.查询统计;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import 数据库模型.TbKhXinX;
import 系统显示.数据库信息.DaoRu;
import 系统显示.管理.Item;

public class KeHuChaXun extends JInternalFrame {
	private JTable table;
	private JTextField conditionContent;
	private JComboBox conditionBox2;
	private JComboBox conditionBox1;
	private JButton showAllButton;

	public KeHuChaXun() {
		super();
		setIconifiable(true);
		setClosable(true);
		setTitle("客户信息查询");
		getContentPane().setLayout(new GridBagLayout());
		setBounds(100, 100, 650, 400);
		// setResizable(false);//设置界面大小不可更改

		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		String[] tableHeads = new String[] { "客户代码", "公司名称", "公司地址", "客户简称",
				"助记码", "邮政编码", "电　　话", "传　　真", "联  系  人", "联系电话", "E-Mail",
				"开户银行", "银行账号", "客户分类", "客户性质", "客户分区", "主页", "备注" };
		final DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		dftm.setColumnIdentifiers(tableHeads);

		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setAutoscrolls(true);
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.insets = new Insets(0, 10, 5, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 6;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);

		setupComponet(new JLabel(" 选择查询条件："), 0, 0, 1, 1, false);
		conditionBox1 = new JComboBox();
		conditionBox1.setModel(new DefaultComboBoxModel(new String[] { "公司名称",
				"客户简称", "客户分类", "客户性质", "客户分区", "助记码" }));
		setupComponet(conditionBox1, 1, 0, 1, 30, true);

		conditionBox2 = new JComboBox();
		conditionBox2.setModel(new DefaultComboBoxModel(new String[] { "等于",
				"包含" }));
		setupComponet(conditionBox2, 2, 0, 1, 30, true);

		conditionContent = new JTextField();
		setupComponet(conditionContent, 3, 0, 1, 140, true);

		final JButton queryButton = new JButton();
		queryButton.addActionListener(new queryAction(dftm));
		queryButton.setText("查询");
		setupComponet(queryButton, 4, 0, 1, 1, false);

		showAllButton = new JButton();
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				conditionContent.setText("");
				List list = DaoRu.getKhInfos();
				updateTable(list, dftm);
			}
		});
		setupComponet(showAllButton, 5, 0, 1, 1, false);
		showAllButton.setText("显示全部数据");
	}

	private void updateTable(List list, final DefaultTableModel dftm) {
		int num = dftm.getRowCount();
		for (int i = 0; i < num; i++)
			dftm.removeRow(0);
		Iterator iterator = list.iterator();
		TbKhXinX khInfo;
		while (iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			khInfo = DaoRu.getKhInfo(item);
			Vector rowData = new Vector();
			rowData.add(khInfo.getCustomerCode().trim());
			rowData.add(khInfo.getName().trim());
			rowData.add(khInfo.getCompanySite().trim());
			rowData.add(khInfo.getCustomerName().trim());
			rowData.add(khInfo.getPyCode().trim());
			rowData.add(khInfo.getZipCode().trim());
			rowData.add(khInfo.getCompanyPhone().trim());
			rowData.add(khInfo.getFax().trim());
			rowData.add(khInfo.getLinkman().trim());
			rowData.add(khInfo.getLinkPhone().trim());
			rowData.add(khInfo.getEmail().trim());
			rowData.add(khInfo.getBankName().trim());
			rowData.add(khInfo.getBankAccout().trim());
			rowData.add(khInfo.getCustomerSort().trim());
			rowData.add(khInfo.getCustomerQuale().trim());
			rowData.add(khInfo.getCustomerZone().trim());
			rowData.add(khInfo.getCompanyHomePage().trim());
			rowData.add(khInfo.getRemark().trim());
			dftm.addRow(rowData);
		}
	}

	// 设置组件位置并添加到容器中
	private void setupComponet(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(component, gridBagConstrains);
	}

	private final class queryAction implements ActionListener {
		private final DefaultTableModel dftm;

		private queryAction(DefaultTableModel dftm) {
			this.dftm = dftm;
		}

		public void actionPerformed(final ActionEvent e) {
			String condition, conditionOperation, conditionString;
			List list = null;
			condition = conditionBox1.getSelectedItem().toString().trim();
			conditionOperation = conditionBox2.getSelectedItem().toString()
					.trim();
			conditionString = conditionContent.getText().trim();
			if (!conditionString.isEmpty()) {
				String sql = "select * from tb_khinfo where ";
				if (condition.equals("公司名称")) {
					if (conditionOperation.equals("等于")) {
						list = DaoRu.findForList(sql + "companyName='"
								+ conditionString + "'");
					} else {
						list = DaoRu.findForList(sql + "companyName like '%"
								+ conditionString + "%'");
					}
				} else if (condition.equals("客户简称")) {
					if (conditionOperation.equals("等于")) {
						list = DaoRu.findForList(sql + "customerName='"
								+ conditionString + "'");
					} else {
						list = DaoRu.findForList(sql + "customerName like '%"
								+ conditionString + "%'");
					}
				}else if (condition.equals("客户分类")) {
					if (conditionOperation.equals("等于")) {
						list = DaoRu.findForList(sql + "customerSort='"
								+ conditionString + "'");
					} else {
						list = DaoRu.findForList(sql + "customerSort like '%"
								+ conditionString + "%'");
					}
				}else if (condition.equals("客户性质")) {
					if (conditionOperation.equals("等于")) {
						list = DaoRu.findForList(sql + "customerQuale='"
								+ conditionString + "'");
					} else {
						list = DaoRu.findForList(sql + "customerQuale like '%"
								+ conditionString + "%'");
					}
				}else if (condition.equals("客户分区")) {
					if (conditionOperation.equals("等于")) {
						list = DaoRu.findForList(sql + "customerZone='"
								+ conditionString + "'");
					} else {
						list = DaoRu.findForList(sql + "customerZone like '%"
								+ conditionString + "%'");
					}
				}else if (condition.equals("助记码")) {
					if (conditionOperation.equals("等于")) {
						list = DaoRu.findForList(sql + "pyCode"
								+ conditionString + "'");
					} else {
						list = DaoRu.findForList(sql + "pyCode like '%"
								+ conditionString + "%'");
					}
				}
				updateTable(list, dftm);
			} else
				showAllButton.doClick();
		}
	}
}
