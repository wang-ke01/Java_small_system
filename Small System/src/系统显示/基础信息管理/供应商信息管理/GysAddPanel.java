package 系统显示.基础信息管理.供应商信息管理;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import 数据库模型.TbGysinfo;
import 系统显示.数据库信息.DaoRu;

public class GysAddPanel extends JPanel{
	private JTextField EMailF;
	private JTextField yinHangF;
	private JTextField lianXiRenDianHuaF;
	private JTextField lianXiRenF;
	private JTextField chuanZhenF;
	private JTextField dianHuaF;
	private JTextField diZhiF;
	private JTextField bianMaF;
	private JTextField jianChengF;
	private JTextField quanChengF;
	private JButton resetButton;
	public GysAddPanel() {
		setLayout(new GridBagLayout());
		setBounds(10, 10, 510, 302);

		setupComponet(new JLabel("供应商全称："), 0, 0, 1, 1, false);

		quanChengF = new JTextField();
		setupComponet(quanChengF, 1, 0, 3, 400, true);

		setupComponet(new JLabel("简称："), 0, 1, 1, 1, false);

		jianChengF = new JTextField();
		setupComponet(jianChengF, 1, 1, 1, 160, true);

		setupComponet(new JLabel("邮政编码："), 2, 1, 1, 1, false);
		bianMaF = new JTextField();
		setupComponet(bianMaF, 3, 1, 1, 0, true);

		setupComponet(new JLabel("地址："), 0, 2, 1, 1, false);
		diZhiF = new JTextField();
		setupComponet(diZhiF, 1, 2, 3, 0, true);

		setupComponet(new JLabel("电话："), 0, 3, 1, 1, false);
		dianHuaF = new JTextField();
		setupComponet(dianHuaF, 1, 3, 1, 0, true);

		setupComponet(new JLabel("传真："), 2, 3, 1, 1, false);
		chuanZhenF = new JTextField();
		setupComponet(chuanZhenF, 3, 3, 1, 0, true);

		setupComponet(new JLabel("联系人："), 0, 4, 1, 1, false);
		lianXiRenF = new JTextField();
		setupComponet(lianXiRenF, 1, 4, 1, 0, true);

		setupComponet(new JLabel("联系人电话："), 2, 4, 1, 1, false);
		lianXiRenDianHuaF = new JTextField();
		setupComponet(lianXiRenDianHuaF, 3, 4, 1, 0, true);

		setupComponet(new JLabel("开户银行："), 0, 5, 1, 1, false);
		yinHangF = new JTextField();
		setupComponet(yinHangF, 1, 5, 1, 0, true);

		setupComponet(new JLabel("电子信箱："), 2, 5, 1, 1, false);
		EMailF = new JTextField();
		setupComponet(EMailF, 3, 5, 1, 0, true);

		final JButton tjButton = new JButton();
		tjButton.setText("添加");
		tjButton.addActionListener(new TjActionListener());
		setupComponet(tjButton, 2, 6, 1, 0, false);

		resetButton = new JButton();
		setupComponet(resetButton, 3, 6, 1, 0, false);
		resetButton.addActionListener(new ResetActionListener());
		resetButton.setText("重填");
	}
	// 设置组件位置并添加到容器中
	private void setupComponet(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		add(component, gridBagConstrains);
	}
	class ResetActionListener implements ActionListener {// 重填按钮的事件监听类
		public void actionPerformed(final ActionEvent e) {
			diZhiF.setText("");
			bianMaF.setText("");
			chuanZhenF.setText("");
			jianChengF.setText("");
			lianXiRenF.setText("");
			lianXiRenDianHuaF.setText("");
			EMailF.setText("");
			quanChengF.setText("");
			dianHuaF.setText("");
			yinHangF.setText("");
		}
	}
	class TjActionListener implements ActionListener {// 添加按钮的事件监听类
		public void actionPerformed(final ActionEvent e) {
			if (diZhiF.getText().equals("") || quanChengF.getText().equals("") //验证用户输入
					|| chuanZhenF.getText().equals("")
					|| jianChengF.getText().equals("")
					|| yinHangF.getText().equals("")
					|| bianMaF.getText().equals("")
					|| diZhiF.getText().equals("")
					|| lianXiRenF.getText().equals("")
					|| lianXiRenDianHuaF.getText().equals("")
					|| EMailF.getText().equals("")
					|| dianHuaF.getText().equals("")) {
				JOptionPane.showMessageDialog(GysAddPanel.this, "请填写全部信息");
				return;
			}
			try {                                                            //验证是否存在同名供应商
				ResultSet haveUser = DaoRu
						.query("select * from tb_gysinfo where name='"
								+ quanChengF.getText().trim() + "'");
				if (haveUser.next()) {
					JOptionPane.showMessageDialog(GysAddPanel.this,
							"供应商信息添加失败，存在同名供应商", "供应商添加信息",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				ResultSet set = DaoRu.query("select max(id) mid from tb_gysinfo");      //获取供应商的最大ID编号
				String id = null;
				if (set != null && set.next()) {                                 //创建新的供应商编号
					String sid = set.getString("mid").trim();
					if (sid == null)
						id = "gys1001";
					else {
						String str = sid.substring(3);
						id = "gys" + (Integer.parseInt(str) + 1);
					}
				}
				TbGysinfo gysInfo = new TbGysinfo();                            //创建供应商实体对象
				gysInfo.setId(id);                                              //初始化供应商对象
				gysInfo.setAddress(diZhiF.getText().trim());
				gysInfo.setBianma(bianMaF.getText().trim());
				gysInfo.setFax(chuanZhenF.getText().trim());
				gysInfo.setYh(yinHangF.getText().trim());
				gysInfo.setJc(jianChengF.getText().trim());
				gysInfo.setName(quanChengF.getText().trim());
				gysInfo.setLian(lianXiRenF.getText().trim());
				gysInfo.setLtel(lianXiRenDianHuaF.getText().trim());
				gysInfo.setMail(EMailF.getText().trim());
				gysInfo.setTel(dianHuaF.getText().trim());
				DaoRu.addGys(gysInfo);                                           //调用addGys()方法存储供应商
				JOptionPane.showMessageDialog(GysAddPanel.this, "已成功添加客户",
						"客户添加信息", JOptionPane.INFORMATION_MESSAGE);
				resetButton.doClick();                                         //触发"充填"按钮的单击动作
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
