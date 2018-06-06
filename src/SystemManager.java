/* 19001 HARAGUCHI TOMOKI */
/* SystemManager.java
 */

/* SystemManager
 */
public class SystemManager {
	/**
	 * �t�B�[���h
	 */
	private PersonList plist;  // �]�ƈ��̃��X�g
	private ClientList clist;  // �ڋq�̃��X�g
	private WorkList wlist;    // �ғ��̃��X�g

	private String pfilename = "person.csv";
	private String cfilename = "client.csv";
	private String wfilename = "work.csv";

	private ConsoleStatus sts1, sts2;
	private DisplayPersonStatus sts5, sts5_2;
	private DisplayPersonsByTypeStatus sts4;
	private TypeSelectionStatus sts3;
	private DisplayPersonsByNameStatus sts7;
	private NameSelectionStatus sts6;
	private AddPersonStatus sts8;
	private UpdatePersonStatus sts9;
	private DeletePersonStatus sts10;
	private AddWorkStatus sts11;
	private DeleteWorkStatus sts12;
	private ExitStatus sts13;

	public static void main( String[] args ) {
		try {
			SystemManager manager = new SystemManager();

			manager.load();
			manager.run();
			manager.save();

		} catch ( Exception e ) {
			e.printStackTrace();
			System.exit( 0 );
		}
	}

	/**
	 * �R���X�g���N�^ SystemManager
	 */
	SystemManager() {

		// �]�ƈ��C�ڋq�C�ғ��̊e���X�g���쐬
		this.plist = new PersonList();
		this.clist = new ClientList();
		this.wlist = new WorkList( this.clist );

		statusSetting();
	}

	// ��ԑJ�ڂ̐ݒ�
	/**
	 * statusSetting
	 */
	public void statusSetting() {

		// �V�X�e���N�����́C�@�\�I���̏��
		sts1 = new ConsoleStatus(
		    "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/\n" +
		    "            �]�ƈ��h���Ǘ��V�X�e��\n" +
		    "                ���j���[\n" +
		    "  �]�ƈ�����(S)\n" +
		    "  �]�ƈ��Ǘ�(JI�F�ǉ� JU�F�X�V JD�F�폜)\n" +
		    "  �ғ��󋵊Ǘ�(KI�F�ǉ� KD�F�폜)\n" +
		    "  �I��(X)\n" +
		    "_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/\n",
		    "�ǂ̋@�\�����s���܂����H\n[S,JI,JU,JD,KI,KD,X]>",
		    false
		 );
		// �N��������"S"���͎��̏��
		sts2 = new ConsoleStatus(
		    "�������@���w�肵�Ă��������B\n" +
                    "N->�������猟��      T->�E�킩�猟��\n" +
                    "E->�]�ƈ������I��(���j���[�ɖ߂�)",
                    "[N,T,E]>",
		    false
		 );

		// �]�ƈ�ID����͂���Ə���\��������
		sts5 = new DisplayPersonStatus(
		    "",
		    "�G���^�[�L�[�������ƌ������ʈꗗ�ɖ߂�܂��B\n>",
		    false,
		    wlist
		 );
		sts5_2 = new DisplayPersonStatus(
		    "",
		    "�G���^�[�L�[�������ƌ������ʈꗗ�ɖ߂�܂��B\n>",
		    false,
		    wlist
		 );

		// �E�킩�瓾���]�Ǝ҃��X�g��\�����C�]�ƈ�ID����͂�����
		sts4 = new DisplayPersonsByTypeStatus(
		    "",
		    "E->�������ʈꗗ�I���i���������w��ɖ߂�j[(�]�ƈ�ID),E]>",
		    false,
		    plist,
		    sts5
		 );

		// �E�햼����͂�����
		sts3 = new TypeSelectionStatus(
		    "�E�햼����͂��Ă��������B\n",
		    "[(�E�햼)]>",
		    false,
		    sts4
		 );

		// �������瓾���]�Ǝ҃��X�g��\�����C�]�ƈ�ID����͂�����
		sts7 = new DisplayPersonsByNameStatus(
		    "",
		    "E->�������ʈꗗ�I���i���������w��ɖ߂�j[(�]�ƈ�ID),E]>",
		    false,
		    plist,
		    sts5_2
		 );

		// �]�ƈ��̎�������͂�����
		sts6 = new NameSelectionStatus(
		    "��������͂��Ă��������B\n",
		    "[(����)]>",
		    false,
		    sts7
		 );

		// �]�ƈ���ǉ�������
		sts8 = new AddPersonStatus(
		    "",
		    "�G���^�[�L�[�������ƃ��j���[�ɖ߂�܂��B>",
		    false,
		    plist
		 );

		// �]�ƈ��̏����X�V������
		sts9 = new UpdatePersonStatus(
		    "",
		    "�X�V���܂����B\n�G���^�[�L�[�������ƃ��j���[�ɖ߂�܂��B>",
		    false,
		    plist
		 );

		// �]�ƈ����폜������
		sts10 = new DeletePersonStatus(
		    "",
		    "���̏]�ƈ������폜���܂����H�iY �͂�  N �������j[Y,N]>",
		    false,
		    plist
		 );

		// �ғ���ǉ�������
		sts11 = new AddWorkStatus(
		    "",
		    "�G���^�[�L�[�������ƃ��j���[�ɖ߂�܂��B>",
		    false,
		    clist, wlist
		 );

		// �ғ����폜������
		sts12 = new DeleteWorkStatus(
		    "",
		    "���̉ғ������폜���܂����H�iY �͂�  N �������j[Y,N]>",
		    false,
		    plist, wlist
		 );

		// �V�X�e�����I��������
		sts13 = new ExitStatus(
		    "",
		    "",
		    true
		 );

		sts1.setNextStatus( "S", sts2 );
		sts1.setNextStatus( "JI", sts8 );
		sts1.setNextStatus( "JU", sts9 );
		sts1.setNextStatus( "JD", sts10 );
		sts1.setNextStatus( "KI", sts11 );
		sts1.setNextStatus( "KD", sts12 );
		sts1.setNextStatus( "X", sts13 );

		sts2.setNextStatus( "N", sts6 );
		sts2.setNextStatus( "T", sts3 );
		sts2.setNextStatus( "E", sts1 );

		sts4.setNextStatus( "E", sts2 );

		sts5.setNextStatus( " ", sts4 );
		sts5_2.setNextStatus( " ", sts7 );

		sts7.setNextStatus( "E", sts2 );

		sts8.setNextStatus( " ", sts1 );

		sts9.setNextStatus( " ", sts1 );

		sts10.setNextStatus( " ", sts1 );

		sts11.setNextStatus( " ", sts1 );

		sts12.setNextStatus( " ", sts1 );
	}

	// �V�X�e���̋N��
	/** run
	 * @throws Exception
	 */
	public void run() throws Exception {
		// ���C�����[�`��
		ConsoleStatus sts = sts1;
		String cmd;

		while( !sts.getIsEndStatus() ) {
			// �ŏ��ɏo�͂��郁�b�Z�[�W
			sts.displayFirstMess();
			// ���̏�ԂɑJ�ڂ��邱�Ƃ𑣂����߂̃��b�Z�[�W
			sts.displayPromptMess();
			// �L�[���͂��󂯕t����
			cmd = sts.inputMessage();
			// �L�[���͂��ꂽ�R�}���h�ɂ���āC
			// ���̏�ԂɑJ�ڂ���
			sts = sts.getNextStatus( cmd );
		}

		// �I����ԂɂȂ�����C���̎|�̃��b�Z�[�W���o�͂���
		// �I���i�ۑ��j�������s��
		sts.displayFirstMess();
	}

	// �}�X�^�t�@�C���̓Ǎ���
	/** load
	 * @throws Exception
	 */
	public void load() throws Exception {
		// �eCSV�t�@�C�����烌�R�[�h��ǂݎ��
		FileLoader pload = new FileLoader( pfilename );
		FileLoader cload = new FileLoader( cfilename );
		FileLoader wload = new FileLoader( wfilename );

		pload.read( plist );
		cload.read( clist );
		wload.read( wlist );
	}

	// �}�X�^�t�@�C���̕ۑ�
	/** save
	 * @throws Exception
	 */
	public void save() throws Exception {
		FileSaver psave = new FileSaver( pfilename );
		FileSaver csave = new FileSaver( cfilename );
		FileSaver wsave = new FileSaver( wfilename );

		psave.write( plist );
		csave.write( clist );
		wsave.write( wlist );
	}
}
