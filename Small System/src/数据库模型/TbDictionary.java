package ���ݿ�ģ��;
//�����ֵ䡪�����ݿ�
public class TbDictionary {
	private String id;	//���к�
	private String typeCode;	//��Ӧ����
	private String typeName;	//��Ӧ��������
	private String valueCode;	//��Ӧ����ѡ��
	private String valueName;	//��Ӧ����ѡ������
	private String lrczy;		//¼�����ݵĲ���Ա����
	private String lrdate;		//¼�����ݵ�����

	public TbDictionary(){

	}

	public TbDictionary(String id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param typeCode
	 * @param typeName
	 * @param valueCode
	 * @param valueName
	 * @param lrczy
	 * @param lrdate
	 */
	public TbDictionary(String id, String typeCode, String typeName,
			String valueCode, String valueName, String lrczy, String lrdate) {
		this.id = id;
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.valueCode = valueCode;
		this.valueName = valueName;
		this.lrczy = lrczy;
		this.lrdate = lrdate;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id Ҫ���õ� id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * @param typeCode Ҫ���õ� typeCode
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * @return typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName Ҫ���õ� typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return valueCode
	 */
	public String getValueCode() {
		return valueCode;
	}

	/**
	 * @param valueCode Ҫ���õ� valueCode
	 */
	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}

	/**
	 * @return valueName
	 */
	public String getValueName() {
		return valueName;
	}

	/**
	 * @param valueName Ҫ���õ� valueName
	 */
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	/**
	 * @return lrczy
	 */
	public String getLrczy() {
		return lrczy;
	}

	/**
	 * @param lrczy Ҫ���õ� lrczy
	 */
	public void setLrczy(String lrczy) {
		this.lrczy = lrczy;
	}

	/**
	 * @return lrdate
	 */
	public String getLrdate() {
		return lrdate;
	}

	/**
	 * @param lrdate Ҫ���õ� lrdate
	 */
	public void setLrdate(String lrdate) {
		this.lrdate = lrdate;
	}



}
