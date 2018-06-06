/* ClientList.java
 */

import java.util.List;
import java.util.ArrayList;

/* ClientList <- RecordList�C���^�t�F�[�X������
 */
public class ClientList implements RecordList {

	/**
	 * �t�B�[���h
	 */
	private List<Client> list;

	/**
	 * �R���X�g���N�^ ClientList
	 */
	ClientList() {
		this.list = new ArrayList<Client>();
	}

	/** �R���X�g���N�^ ClientList
	 * @param List<Client> al
	 */
	ClientList( List<Client> al ) {
		this.list = al;
	}

	/** size
	 * @return int
	 */
	public int size() {
		return list.size();
	}

	/** add
	 * @param String data
	 * @throws Exception
	 */
	public void add( String data ) throws Exception {
		Client p = new Client( data );
		for( int idx = 0; idx < list.size(); idx++ ) {
			Client pidx = list.get( idx );
			if( pidx.getID() == p.getID() )   // ����ID�̃��R�[�h������ꍇ
				return;                       // ���������I��
			else if( pidx.getID() > p.getID() ) {
				list.add( idx, p );           // ���R�[�h��ǉ�
				return;
			}
		}
		list.add( p );    // ���X�g�����Ƀ��R�[�h��ǉ�
	}

	/** getRecord
	 * @param int idx
	 * @return Record
	 */
	public Record getRecord( int idx ) {
		if( idx >= list.size() )
			return null;
		else
			return list.get( idx );
	}

	/**
	 * allDisplay
	 */
	public void allDisplay() {
		for( Client p : list ) {
			System.out.println( p.toString() );
		}
	}

	/** find
	 * @param int ID
	 * @return int
	 */
	public int find( int ID ) {
		// ������ID�Ɠ���ID�������R�[�h�̈ʒu������
		for( int idx = 0; idx < list.size(); idx++ ) {
			Client pidx = list.get( idx );
			if( pidx.getID() == ID )
				return idx;
		}

		return -1;
	}

	/** get
	 * @param int ID
	 * @return Client
	 */
	public Client get( int ID ) {
		// ������ID�Ɠ���ID�������R�[�h�����݂���Ȃ�΁C
		// ���̃��R�[�h��Ԃ�
		int idx;
		if( (idx = find( ID )) != -1 )
			return list.get( idx );
		else
			return null;
	}
}
