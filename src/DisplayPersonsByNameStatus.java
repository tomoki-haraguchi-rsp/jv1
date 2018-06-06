/* DisplayPersonsByNameStatus.java
 */

/* DisplayPersonsByNameStatus
 */
public class DisplayPersonsByNameStatus extends ConsoleStatus {

	// �t�B�[���h
	private String name;
	private PersonList plist;
	private PersonList selectedList;
	private DisplayPersonStatus next;

	/**
	 * �R���X�g���N�^ DisplayPersonsByNameStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 * @param PersonList plist
	 * @param DisplayPersonStatus next
	 */
	DisplayPersonsByNameStatus( String firstMess, String promptMess,
	                     boolean IsEndStatus,
	                     PersonList plist, DisplayPersonStatus next ) {
		super( firstMess, promptMess, IsEndStatus );
		this.name = "";
		this.plist = plist;
		this.selectedList = null;
		this.next = next;
	}

	// �ŏ��ɏo�͂��郁�b�Z�[�W��\������
	/** displayFirstMess
	 * @throws Exception
	 */
	public void displayFirstMess() throws Exception {
		displayList();
		super.displayFirstMess();
	}

	// �������鎁����o�^����
	/** setName
	 * @param String name
	 */
	public void setName( String name ) {
		this.name = name;
	}

	// ���͂��ꂽ�����̕�����������Ɋ܂ޏ]�ƈ��̃��R�[�h������
	// ���o������
	/**
	 * displayList
	 */
	public void displayList() {
		// ���͂��ꂽ�����Ɉ�v�܂��͎������܂ޏ]�ƈ��̃��R�[�h������
		// selectedList�Ɏ��o��
		selectedList = plist.searchByName( name );
		// selectedList�̌�����0�Ȃ�Γ��Y�E�������
		// �]�ƈ��͂��Ȃ��ƕ\��
		if( selectedList.size() <= 0 )
			System.out.println( "�]�ƈ������݂��܂���B" );
		else
			selectedList.allDisplay();
	}

	// ���̏�ԂɑJ�ڂ��邱�Ƃ𑣂����߂̃��b�Z�[�W�̕\��
	/** getNextStatus
	 * @param String s
	 * @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus( String s ) {
		// ���l�����͂��ꂽ�ꍇ�C���̐��l�Ɠ���ID������
		// ���R�[�h��selectedList�ɂ��邩�ǂ������肵�C
		// ����΂�������̏��DisplayPersonStatus�ɓn��
		try {
			int i = Integer.parseInt( s );
			Person p = selectedList.get( i );
			if( p == null )
				return this;
			else {
				next.setPersonRecord( p );
				return next;
			}
		} catch( NumberFormatException e ) {
			return super.getNextStatus( s );
		}
	}
}
