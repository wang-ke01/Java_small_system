package ���ݿ�ģ��;
//�ͻ���Ϣ�������ݿ�
public class TbKhXinX implements java.io.Serializable{
	private String id;				//���к�
	private String customerCode;	//�ͻ�����
	private String pyCode;			//������
	private String customerName;	//�ͻ����
	private String name;			//��˾����
	private String companySite;		//��˾��ַ
	private String companyPhone;	//��˾�绰
	private String linkman;			//��ϵ��
	private String linkPhone;		//��ϵ�绰
	private String fax;				//����
	private String customerSort;	//�ͻ�����
	private String customerQuale;	//�ͻ�����
	private String customerZone;	//�ͻ�����
	private String address;			//Ͷ�ݵ�ַ
	private String zipCode;			//��������
	private String bankName;		//��������
	private String bankAccout;		//�����˺�
	private String email;			//����
	private String companyHomePage;	//��˾��ҳ
	private String remark;			//��ע
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
	//���췽��
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
