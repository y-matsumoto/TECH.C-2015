/**
 * 指定されたサイズの九九表を作成する。
 * @author sitri
 *
 */
package MultiplicationTable;
/**
 * 任意のサイズの九九表を示す。
 * 演算結果は保持せず、標準出力経由で渡す。
 * 解の数がユーザの入力に大きく影響されるため、それをメモリにすべて保持するような設計は危険だろう。
 * @author sitri
 *
 */
public class MultiplicationTable {
	protected int row = 9; // 初期値は9とする。
	protected int col = 9; // 初期値は9とする。
	/**
	 * 九九表のサイズで初期化する。
	 * @param row 行数。縦の長さ。
	 * @param col 要素数。横の長さ。
	 */
	public MultiplicationTable(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public void print() {
		int maxLength = 1 + Integer.toString(this.col * this.row).length(); // 解の最大桁数。
		String numFormat = "%" + maxLength + "d"; // 解の最大桁数を考慮した、数値の表示桁数をしたフォーマット。
			// 例えば、9x9の九九表なら、2桁が最大桁数なので、%2d で表示する。
		for(int i=1; i<=this.row; i++){
			for(int j=1; j<=this.col; j++){
				System.out.printf(numFormat + " ", i*j);
			}
			System.out.println(); // 改行
		}
	}

}
