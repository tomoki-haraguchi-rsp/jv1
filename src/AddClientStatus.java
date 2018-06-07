/* AddCustomerStatus.java
 */

/* AddCustomerStatus
 */
public class AddClientStatus extends ConsoleStatus {

	// フィールド
	private ClientList cl;

	private String[] messages = {
		"会社名を入力してください。>",
		"住所を入力してください。>",
		"電話番号を入力してください。>",
	};
	private String[] data = new String[ 5 ];

	/**
	 * コンストラクタ AddCustomerStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 * @param CustomerList cl
	 */
	AddClientStatus( String firstMess, String promptMess,
	                 boolean IsEndStatus, ClientList cl ) {
		super( firstMess, promptMess, IsEndStatus );
		this.cl = cl;
	}

	// 最初に出力するメッセージを表示する
	// このクラスでは従業員のデータの入力処理
	// のみを行う
	/** displayFirstMess
	 * @throws Exception
	 */
	public void displayFirstMess() throws Exception {
		// messagesの各文字列を順に表示しながら
		// キーボードから氏名，住所などを得ていく
		for( int idx = 0; idx < messages.length; idx++ ) {
			System.out.print( messages[ idx ] );
			data[ idx ] = inputMessage();
		}

		try {
                                                        String id = String.valueOf(cl.size());
			// 新しいレコードを追加
			cl.add( id + "," + data[0] + "," + data[1] + "," + data[2] + ",f");
			System.out.println( "ID:" + cl.size() + "で登録されました。" );
		} catch( NumberFormatException e ) {
			System.out.println( "数値に変換できないデータが入力されています。" );
			System.out.println( "再入力してください。" );
			displayFirstMess();
			return;
		}
	}

	// 次の状態に遷移することを促すためのメッセージの表示
	// このクラスは，初期状態に戻ると決まっているため，何が
	// 入力されても初期状態に遷移するようにしている
	/** getNextStatus
	 * @param String s
	 * @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus( String s ) {
		return super.getNextStatus( " " );
	}
}
