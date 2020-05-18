package 数据库模型;

//供应商信息表——数据库
public class TbGysinfo implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String jc;
	private String address;
	private String bianma;
	private String tel;
	private String fax;
	private String lian;
	private String ltel;
	private String yh;
	private String mail;

	// Constructors

	/** default constructor */
	public TbGysinfo() {
	}

	/** minimal constructor */
	public TbGysinfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public TbGysinfo(String id, String name, String jc, String address,
			String bianma, String tel, String fax, String lian, String ltel,
			String yh, String mail) {
		this.id = id;
		this.name = name;
		this.jc = jc;
		this.address = address;
		this.bianma = bianma;
		this.tel = tel;
		this.fax = fax;
		this.lian = lian;
		this.ltel = ltel;
		this.yh = yh;
		this.mail = mail;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJc() {
		return this.jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBianma() {
		return this.bianma;
	}

	public void setBianma(String bianma) {
		this.bianma = bianma;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLian() {
		return this.lian;
	}

	public void setLian(String lian) {
		this.lian = lian;
	}

	public String getLtel() {
		return this.ltel;
	}

	public void setLtel(String ltel) {
		this.ltel = ltel;
	}

	public String getYh() {
		return this.yh;
	}

	public void setYh(String yh) {
		this.yh = yh;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}