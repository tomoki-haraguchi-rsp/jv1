/* PersonList.java
 */

import java.util.List;
import java.util.ArrayList;

/* PersonList <- RecordList�C���^�t�F�[�X������
 */
public class PersonList implements RecordList {

	/**
	 * �t�B�[���h
	 */
	private List<Person> list;

	/**
	 * �R���X�g���N�^ PersonList
	 */
	PersonList() {
		this.list = new ArrayList<Person>();
	}

	/** �R���X�g���N�^ PersonList
	 * @param List<Person> al
	 */
	PersonList( List<Person> al ) {
		this.list = al;
	}

	/** size
	 * @return int
	 */
	public int size() {
		return list.size();
	}

	/** add
	 * @param Person p
	 */
	public void add( Person p ) {
		for( int idx = 0; idx < list.size(); idx++ ) {
			Person pidx = list.get( idx );
			if( pidx.getID() == p.getID() )   // ����ID�̃��R�[�h������ꍇ
				return;                       // ���������I��
			else if( pidx.getID() > p.getID() ) {
				list.add( idx, p );           // ���R�[�h��ǉ�
				return;
			}
		}
		list.add( p );    // ���X�g�����Ƀ��R�[�h��ǉ�
	}

	/** add
	 * @param String data
	 * @throws Exception
	 */
	public void add( String data ) throws Exception {
		Person p = new Person( data );
		add( p );
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

	/** delete
	 * @param int ID
	 * @return boolean
	 */
	public boolean delete( int ID ) {
		int idx;
		Person p;
		if( ( idx = find( ID ) ) == -1 )
			return false;
		else {
			p = get( idx );
			p.setEraseFlag( true );
			return true;
		}
	}

	/**
	 * allDisplay
	 */
	public void allDisplay() {
		for( Person p : list ) {
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
			Person pidx = list.get( idx );
			if( pidx.getID() == ID )
				return idx;
		}

		return -1;
	}

	/** get
	 * @param int ID
	 * @return Person
	 */
	public Person get( int ID ) {
		Person p;

		// ������ID�Ɠ���ID�������R�[�h�����݂���Ȃ�΁C
		// ���̃��R�[�h��Ԃ�
		int idx;
		if( (idx = find( ID )) != -1 ) {
			p = list.get( idx );
			// �폜�t���O��false�Ȃ瓖�Y���R�[�h��Ԃ�
			if( !p.getEraseFlag() )
				return p;
			else
				return null;
		}
		else
			return null;
	}

	/** searchByName
	 * @param String name
	 * @return PersonList
	 */
	public PersonList searchByName( String name ) {

		ArrayList<Person> l = new ArrayList<Person>();

		for( int idx = 0; idx < list.size(); idx++ ) {
			Person p = list.get( idx );
			// idx�Ԗڂ̃��R�[�h��name�Ɉ���name���܂܂�邩
			// �ǂ������m�F����
			if( p.getName().indexOf( name ) != -1 &&
			    !p.getEraseFlag() )
				l.add( p );
		}

		return new PersonList( l );
	}

	/** searchByTypes
	 * @param String type
	 * @return PersonList
	 */
	public PersonList searchByTypes( String type ) {

		ArrayList<Person> l = new ArrayList<Person>();

		for( int idx = 0; idx < list.size(); idx++ ) {
			Person pidx = list.get( idx );
			// idx�Ԗڂ̃��R�[�h�̐E��type������type�ƈ�v���邩
			// �ǂ������m�F����
			if( pidx.getType().equals( type ) &&
			    !pidx.getEraseFlag() )
				l.add( pidx );
		}

		return new PersonList( l );
	}
}
