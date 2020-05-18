package 数据库模型;
//客户信息——数据库
public class TbKhXinX implements java.io.Serializable{
	private String id;				//序列号
	private String customerCode;	//客户代码
	private String pyCode;			//助记码
	private String customerName;	//客户简称
	private String name;			//公司名称
	private String companySite;		//公司地址
	private String companyPhone;	//公司电话
	private String linkman;			//联系人
	private String linkPhone;		//联系电话
	private String fax;				//传真
	private String customerSort;	//客户分类
	private String customerQuale;	//客户性质
	private String customerZone;	//客户分区
	private String address;			//投递地址
	private String zipCode;			//邮政编码
	private String bankName;		//开户银行
	private String bankAccout;		//银行账号
	private String email;			//邮箱
	private String companyHomePage;	//公司主页
	private String remark;			//备注
	public TbKhXinX(){
	}
	public TbKhXinX(String id){
		this.id = id;
	}
	public TbKhXinX(String id,String customerCode, String pyCode,String customerName, String name , String companySite
			, String companyPhone, String linkman, String linkPhone, String fax, String customerSort,
			String customerQuale, String customerZone, String address, String zipCode, String bankName,
			String bankAccout, String email, String companyHomePage, String remark){
		this.id = id;
		this.customerCode = customerCode;
		this.pyCode = pyCode;
		this.customerName = customerName;
		this.name = name;
		this.companySite = companySite;
		this.companyPhone = companyPhone;
		this.linkman = linkman;
		this.linkPhone = linkPhone;
		this.fax = fax;
		this.customerSort = customerSort;
		this.customerQuale = customerQuale;
		this.customerZone = customerZone;
		this.address = address;
		this.zipCode = zipCode;
		this.bankName = bankName;
		this.bankAccout = bankAccout;
		this.email = email;
		this.companyHomePage = companyHomePage;
		this.remark = remark;
	}
	//构造方法
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getPyCode() {
		return pyCode;
	}
	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanySite() {
		return companySite;
	}
	public void setCompanySite(String companySite) {
		this.companySite = companySite;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCustomerSort() {
		return customerSort;
	}
	public void setCustomerSort(String customerSort) {
		this.customerSort = customerSort;
	}
	public String getCustomerQuale() {
		return customerQuale;
	}
	public void setCustomerQuale(String customerQuale) {
		this.customerQuale = customerQuale;
	}
	public String getCustomerZone() {
		return customerZone;
	}
	public void setCustomerZone(String customerZone) {
		this.customerZone = customerZone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccout() {
		return bankAccout;
	}
	public void setBankAccout(String bankAccout) {
		this.bankAccout = bankAccout;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyHomePage() {
		return companyHomePage;
	}
	public void setCompanyHomePage(String companyHomePage) {
		this.companyHomePage = companyHomePage;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
