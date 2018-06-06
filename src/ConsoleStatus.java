/* ConsoleStatus.java
 */

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* ConsoleStatus
 */
public class ConsoleStatus {
	/**
	 * �t�B�[���h
	 */
	// ���ɑJ�ڂ����Ԃ��L�^����HashMap
	private HashMap<String, ConsoleStatus> nextStatus;
	// �I����Ԃł��邩�ǂ�����\���ϐ�
	private boolean IsEndStatus;
	// ��ԑJ�ڌ�C�ŏ��ɏo�͂��郁�b�Z�[�W
	private String firstMess;
	// ���̏�ԂɑJ�ڂ��邱�Ƃ𑣂����߂̃��b�Z�[�W
	private String promptMess;

	/**
	 * �R���X�g���N�^ ConsoleStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 */
	ConsoleStatus( String firstMess, String promptMess, boolean IsEndStatus ) {
		this.nextStatus = new HashMap<String, ConsoleStatus>();
		this.firstMess = firstMess;
		this.promptMess = promptMess;
		this.IsEndStatus = IsEndStatus;
	}

	// �I����Ԃ��ǂ������`�F�b�N����
	/** getIsEndStatus
	 * @return boolean
	 */
	public boolean getIsEndStatus() {
		return IsEndStatus;
	}

	// ���̏�Ԃ��Z�b�g����
	/** setNextStatus
	 * @param String s
	 * @param ConsoleStatus c
	 */
	public void setNextStatus( String s, ConsoleStatus c ) {
		nextStatus.put( s, c );
	}

	// ���̏�Ԃ𓾂�
	/** getNextStatus
	 * @param String s
	 * @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus( String s ) {
		// ���͂��ꂽ������ɑΉ��t����ꂽ���̏�Ԃ�
		// ���邩�ǂ����𔻒肵�C����Ύ��̏�Ԃ�Ԃ�
		// �Ȃ����this(���݂̏��)��Ԃ�
		ConsoleStatus cs;
		if( (cs = nextStatus.get( s )) != null )
			return cs;
		else
			return this;
	}

	// �ŏ��ɏo�͂��郁�b�Z�[�W��\������
	/** displayFirstMess
	 * @throws Exception
	 */
	public void displayFirstMess() throws Exception {
		System.out.println( firstMess );
	}

	// ���̏�ԂɑJ�ڂ��邱�Ƃ𑣂����߂̃��b�Z�[�W�̕\��
	/**
	 * displayPromptMess
	 */
	public void displayPromptMess() {
		System.out.print( promptMess );
	}

	// ����҂���̃L�[���͂��󂯕t����
	/** inputMessage
	 * @throws IOException
	 * @return String
	 */
	public String inputMessage() throws IOException {
		String s = null;
		try {

			BufferedReader input
			 = new BufferedReader( new InputStreamReader( System.in ) );
			s = input.readLine();

		} catch( IOException e ) {
			System.out.println( "���͒��ɃG���[���������܂����B" );
			throw e;
		}

		return s;
	}
}
