/* DeletePersonStatus.java
 */

/* DeletePersonStatus
 */
public class DeletePersonStatus extends ConsoleStatus {

	// �t�B�[���h
	private PersonList pl;
	private int id = -1;
	private String data;

	/**
	 * �R���X�g���N�^ DeletePersonStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 * @param PersonList pl
	 */
	DeletePersonStatus( String firstMess, String promptMess,
	                 boolean IsEndStatus, PersonList pl ) {
		super( firstMess, promptMess, IsEndStatus );
		this.pl = pl;
		this.id = -1;
		this.data = "";
	}

	// �ŏ��ɏo�͂��郁�b�Z�[�W��\������
	// ���̃N���X�ł͏]�ƈ��̃f�[�^�̍폜����
	// �݂̂��s��
	/** displayFirstMess
	 * @throws Exception
	 */
	public void displayFirstMess() throws Exception {
		// ID�̓���
		System.out.print( "�]�ƈ�ID����͂��Ă��������B\n>" );
		data = inputMessage();
		try {
			id = Integer.parseInt( data ); // �]�ƈ�ID
		} catch( NumberFormatException e ) {
			System.out.println( "���l�ɕϊ��ł��Ȃ��f�[�^�����͂���Ă��܂��B" );
			System.out.println( "�ē��͂��Ă��������B" );
			displayFirstMess();
			return;
		}

		Person p = pl.get( id );
		if( p == null ) {
			System.out.println( "�w���ID�̏]�ƈ��͑��݂��܂���B" );
			System.out.println( "�ē��͂��Ă��������B" );
			displayFirstMess();
			return;
		}

		// �]�ƈ��̏��̕\��
		System.out.println( p.toString() + "\n" );
	}

	// Y�����͂��ꂽ�ꍇ�w�肳�ꂽ���R�[�h���폜�C
	// N(�܂��͂���ȊO)�̏ꍇ����������
	// ������ԂɑJ�ڂ���悤�ɂ��Ă���
	/** getNextStatus
	 * @param String s
	 * @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus( String s ) {
		if( s.equals( "Y" ) ) {
			System.out.println( "�폜���܂����B" );
			pl.delete( id );
		}

		return super.getNextStatus( " " );
	}

}
