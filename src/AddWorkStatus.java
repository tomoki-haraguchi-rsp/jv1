/* AddWorkStatus.java
 */

/* AddWorkStatus
 */
public class AddWorkStatus extends ConsoleStatus {

	// �t�B�[���h
	private ClientList cl;
	private WorkList wl;

	private String[] messages = {
		"�]�ƈ�ID����͂��Ă��������B\n>",
		"�ڋqID����͂��Ă��������B\n>",
		"�ғ��J�n�N��������͂��Ă��������B\n>",
		"�ғ��I���N��������͂��Ă��������B\n>",
		"�P������͂��Ă��������B\n>"
	};
	private String[] data = new String[ 5 ];

	/**
	 * �R���X�g���N�^ AddWorkStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 * @param ClientList cl
	 * @param WorkList wl
	 */
	AddWorkStatus( String firstMess, String promptMess,
	                 boolean IsEndStatus, ClientList cl,
	                 WorkList wl ) {
		super( firstMess, promptMess, IsEndStatus );
		this.cl = cl;
		this.wl = wl;
	}

	// �ŏ��ɏo�͂��郁�b�Z�[�W��\������
	// ���̃N���X�ł͉ғ��̃f�[�^�̓��͏���
	// �݂̂��s��
	/** displayFirstMess
	 * @throws Exception
	 */
	public void displayFirstMess() throws Exception {
		// messages�̊e����������ɕ\�����Ȃ���
		// �L�[�{�[�h���玁���C�Z���Ȃǂ𓾂Ă���
		System.out.print( messages[ 0 ] );
		data[ 0 ] = inputMessage();
		cl.allDisplay();
		System.out.print( messages[ 1 ] );
		data[ 1 ] = inputMessage();
		for( int idx = 2; idx < messages.length; idx++ ) {
			System.out.print( messages[ idx ] );
			data[ idx ] = inputMessage();
		}

		try {
			int pid = Integer.parseInt( data[ 0 ] );  // �]�ƈ�ID
			int cid = Integer.parseInt( data[ 1 ] );  // �ڋqID
			int pr = Integer.parseInt( data[ 4 ] );   // �_��P��

			Work new_w = new Work(
			  wl.size(), // ���݂�WorkList�̃��R�[�h����
			             // �V�������R�[�h��ID�Ƃ���
			  pid, cid, data[ 2 ], data[ 3 ], 
			  pr, false
			);

			// �V�������R�[�h��ǉ�
			wl.add( new_w );
			System.out.println( "ID:" + new_w.getID() + "�œo�^����܂����B" );
		} catch( NumberFormatException e ) {
			System.out.println( "���l�ɕϊ��ł��Ȃ��f�[�^�����͂���Ă��܂��B" );
			System.out.println( "�ē��͂��Ă��������B" );
			displayFirstMess();
			return;
		}
	}

	// ���̏�ԂɑJ�ڂ��邱�Ƃ𑣂����߂̃��b�Z�[�W�̕\��
	// ���̃N���X�́C������Ԃɖ߂�ƌ��܂��Ă��邽�߁C����
	// ���͂���Ă�������ԂɑJ�ڂ���悤�ɂ��Ă���
	/** getNextStatus
	 * @param String s
	 * @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus( String s ) {
		return super.getNextStatus( " " );
	}
}
