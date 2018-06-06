/* Client.java
 */

/* Client <- Record�N���X���p��
 */
public class Client extends Record {
	/**
	 * �t�B�[���h
	 */
	private String name;		// ��Ж�
	private String address;		// �Z��
	private String tel;		// �d�b�ԍ�

	/** �R���X�g���N�^ Client
	 * @param String record
	 * @throws Exception
	 */
	Client( String record ) throws Exception {
		setData( record );
	}

	/** setData
	 * @param String record
	 * @throws Exception
	 */
	public void setData( String record ) throws Exception {
		String[] n = record.split( "," );	// ���R�[�h��","�ŕ���
		try {
			if( n.length != 5 )
			 throw new ArrayIndexOutOfBoundsException
				( "�s���ȃ��R�[�h��ǂݍ��݂܂����B" );

			setID( Integer.parseInt( n[0] ) );
			name = n[1];
			address = n[2];
			tel = n[3];
			if( n[4].equals( "t" ) ) setEraseFlag( true );
			else if( n[4].equals( "f" ) ) setEraseFlag ( false );
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
		String ts = "ID:" + getID() + " ��Ж�:" + name
		           + " �Z��:" + address
		           + " �d�b�ԍ�:" + tel;
		return ts;
	}

	// ���ۃ��\�b�hwriteForCSV�̎���
	/** writeForCSV
	 * @return String
	 */
	public String writeForCSV() {
		String s = "" + getID() + "," + name + "," + address +
		           "," + tel + "," + ( getEraseFlag() ? "t" : "f" );
		return s;
	}

	/** getName
	 * @return String
	 */
	public String getName() {
		return name;
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
}
