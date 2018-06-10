/* AddPersonStatus.java
 */

/* AddPersonStatus
 */
public class AddPersonStatus extends ConsoleStatus {

	// �t�B�[���h
	private PersonList pl;

	private String[] messages = {
		"��������͂��Ă��������B>",
		"�Z������͂��Ă��������B>",
		"�d�b�ԍ�����͂��Ă��������B>",
		"�E�����͂��Ă��������B>",
		"�Α��N������͂��Ă��������B>",
		"�P������͂��Ă��������B>"
	};
	private String[] data = new String[ 6 ];

	/**
	 * �R���X�g���N�^ AddPersonStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 * @param PersonList pl
	 */
	AddPersonStatus( String firstMess, String promptMess,
	                 boolean IsEndStatus, PersonList pl ) {
		super( firstMess, promptMess, IsEndStatus );
		this.pl = pl;
	}

	// �ŏ��ɏo�͂��郁�b�Z�[�W��\������
	// ���̃N���X�ł͏]�ƈ��̃f�[�^�̓��͏���
	// �݂̂��s��
	/** displayFirstMess
	 * @throws Exception
	 */
	public void displayFirstMess() throws Exception {
		// messages�̊e����������ɕ\�����Ȃ���
		// �L�[�{�[�h���玁���C�Z���Ȃǂ𓾂Ă���
		for( int idx = 0; idx < messages.length; idx++ ) {
			System.out.print( messages[ idx ] );
			data[ idx ] = inputMessage();
		}

		try {
			for( int idx = 0; idx < data.length; idx++ ) {
				if ( data[ idx ].equals( "" ) ) {
					System.out.println( "�����͍��ڂ����݂��܂��B" );
					PrintEmptyData();
					System.out.println( "�ē��͂��܂����H[Y,N]" );
					String c = inputMessage();
					if ( c.equals( "Y" ) ) {
						idx = -1;
						continue;
					} else {
						break;
					}
				}
			}

			int wy = Integer.parseInt( data[ 4 ] );  // �Α��N��
			int pr = Integer.parseInt( data[ 5 ] );  // �P��

			Person new_p = new Person(
			  pl.size(), // ���݂�PersonList�̃��R�[�h����
	                     // �V�������R�[�h��ID�Ƃ���
			  data[ 0 ], data[ 1 ], data[ 2 ], data[ 3 ], 
			  wy, pr, false
			);

			// �V�������R�[�h��ǉ�
			pl.add( new_p );
			System.out.println( "ID:" + new_p.getID() + "�œo�^����܂����B" );
		} catch( NumberFormatException e ) {
			System.out.println( "���l�ɕϊ��ł��Ȃ��f�[�^�����͂���Ă��܂��B" );
			System.out.println( "�ē��͂��Ă��������B" );
			displayFirstMess();
			return;
		}
	}

	private void PrintEmptyData() {
		for( int idx = 0; idx < messages.length; idx++ ) {
			if ( data[idx]  == null || data[ idx ].equals( "" ) ) {
				String[] n = data[idx].split("��");
				System.out.print( n[0] );
			}
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
