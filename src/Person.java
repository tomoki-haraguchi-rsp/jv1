/* Person.java
 */

/* Person <- Record�N���X���p��
 */

public class Person extends Record {
	/**
	 * �t�B�[���h
	 */
	private String name;		// ����
	private String address;		// �Z��
	private String tel;		// �d�b�ԍ�
	private String type;		// �E��
	private int workingYears;	// �Α��N��
	private int price;		// �P��

	/** �R���X�g���N�^ Person
	 * @param int ID
	 * @param String name 
	 * @param String address 
	 * @param String tel 
	 * @param String type 
	 * @param int workingYears
	 * @param int price
	 * @param boolean eraseFlag
	 */
	Person( int ID, String name, String address, String tel,
	 String type, int workingYears, int price, boolean eraseFlag ) {
		super( ID, eraseFlag );
	 	this.name = name;
	 	this.address = address;
	 	this.tel = tel;
	 	this.type = type;
	 	this.workingYears = workingYears;
	 	this.price = price;
	}

	/** �R���X�g���N�^ Person
	 * @param String record
	 * @throws Exception
	 */
	Person( String record ) throws Exception {
		setData( record );
	}

	/** setData
	 * @param String record
	 * @throws Exception
	 */
	public void setData( String record ) throws Exception {
		String[] n = record.split( "," );	// ���R�[�h��","�ŕ���
		try {
			if( n.length != 8 )
			 throw new ArrayIndexOutOfBoundsException
			   ( "�s���ȃ��R�[�h��ǂݍ��݂܂����B" );

			setID( Integer.parseInt( n[0] ) );
			name = n[1];
			address = n[2];
			tel = n[3];
			type = n[4];
			workingYears = Integer.parseInt( n[5] );
			price = Integer.parseInt( n[6] );
			if( n[7].equals( "t" ) ) setEraseFlag( true );
			else if( n[7].equals( "f" ) ) setEraseFlag ( false );
			else throw new NumberFormatException();
		} catch( NumberFormatException e ) {
			System.out.println
			  ( "���l�܂��͍폜�t���O�ɕϊ��ł��Ȃ��l�����R�[�h�Ɋ܂܂�Ă��܂��B" );
			throw e;
		}
	}

	/** toString
	 * @return String
	 */
	public String toString() {
		String ts = "ID:" + getID() + " ����:" + name
		           + "\n�Z��:" + address + " �d�b�ԍ�:" + tel
		           + "\n�E��:" + type
		           + " �Α��N��:" + workingYears + "�N "
		           + "�P��:" + price + "�~";
		return ts;
	}

	// ���ۃ��\�b�hwriteForCSV�̎���
	/** writeForCSV
	 * @return String
	 */
	public String writeForCSV() {
		String s = "" + getID() + "," + name + "," + address +
		           "," + tel + "," + type + "," + workingYears +
		           "," + price + "," + ( getEraseFlag() ? "t" : "f" );
		return s;
	}

	/** getName
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/** getType
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/** setName
	 * @param String name
	 */
	public void setName( String name ) {
		this.name = name;
	}

	/** setAddress
	 * @param String address
	 */
	public void setAddress( String address ) {
		this.address = address;
	}

	/** setTel
	 * @param String tel
	 */
	public void setTel( String tel ) {
		this.tel = tel;
	}

	/** setType
	 * @param String type
	 */
	public void setType( String type ) {
		this.type = type;
	}

	/** setWorkingYears
	 * @param int workingYears
	 */
	public void setWorkingYears( int workingYears ) {
		this.workingYears = workingYears;
	}

	/** setPrice
	 * @param int price
	 */
	public void setPrice( int price ) {
		this.price = price;
	}

}
