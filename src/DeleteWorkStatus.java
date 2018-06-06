/* DeleteWorkStatus.java
 */

import java.lang.NumberFormatException;

/* DeleteWorkStatus
 */
public class DeleteWorkStatus extends ConsoleStatus {

	// �t�B�[���h
	private PersonList pl;
	private WorkList wl;
	private int id = -1;
	private String data;
	private WorkList selectedWl = null;

	/**
	 * �R���X�g���N�^ DeleteWorkStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 * @param PersonList pl
	 * @param WorkList wl
	 */
	DeleteWorkStatus( String firstMess, String promptMess,
	                 boolean IsEndStatus, PersonList pl, WorkList wl ) {
		super( firstMess, promptMess, IsEndStatus );
		this.pl = pl;
		this.wl = wl;
		this.id = -1;
		this.data = "";
		this.selectedWl = null;
	}

	// �ŏ��ɏo�͂��郁�b�Z�[�W��\������
	// ���̃N���X�ł͉ғ��̃f�[�^�̍폜����
	// �݂̂��s��
	/** displayFirstMess
	 * @throws Exception
	 */
	public void displayFirstMess() throws Exception {
		String	comma;
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

		selectedWl = wl.searchByPersonID( p.getID() );
		// �w�肵���]�ƈ�ID�̏]�ƈ������蓖�Ă��Ă���
		// �ғ��̕\��
		selectedWl.displayWithClient();

		System.out.print( "�폜����ғ�ID����͂��Ă��������B\n[" );
		comma = "";
		for( int idx = 0; idx < wl.size(); idx++ ) {
			Work w = selectedWl.get( idx );

			// idx�̒l�Ɠ����ғ�ID�̃��R�[�h���Ȃ��ꍇ�C��΂�
			if( w == null ) continue;
			System.out.print( comma + w.getID() );
			comma = ",";
		}
		System.out.print( "]>" );
		data = inputMessage();
		try {
			id = Integer.parseInt( data ); // �폜����ғ�ID
		} catch( NumberFormatException e ) {
			id = -1;
		}
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
			wl.delete( id );
			System.out.println( "�폜���܂����B" );
		}

		return super.getNextStatus( " " );
	}
}
