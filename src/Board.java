
public class Board {
	private TYPE [][] board;
	public static final int COLS=3;
	public static final int ROWS=3;
	
	public Board() {
		this.board=new TYPE[ROWS][COLS];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j]=TYPE.EMPTY;
			}
		}
	}
	
	public boolean putOnBoard(int x, int y, TYPE t) {
		if ((x>COLS || x<0 || y>ROWS || y<0 ) || this.board[y][x]!=TYPE.EMPTY) {
		return false;
		}
		this.board[y][x]=t;
		return true;
	}

	public void setBoard(TYPE[][] board) {
		this.board = board;
	}
	
	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j]==TYPE.X) System.out.print("x ");
				else if (board[i][j]==TYPE.O) System.out.print("O ");
				else System.out.print("_ ");
			}
			System.out.println();
		}
	}
	
	public boolean isHorizontalWin() {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0]==board[i][1] && board[i][0]==board[i][2] && board[i][0]!=TYPE.EMPTY) {
				System.out.println("Player " + board[i][0] + " won!!!");
				return true;
			}
		}
		return false;
	}
	
	public boolean isVerticalWin() {
		for (int j = 0; j < board.length; j++) {
			if (board[0][j]==board[1][j] && board[0][j]==board[2][j] && board[0][j]!=TYPE.EMPTY) {
				System.out.println("Player " + board[0][j] + " won!!!");
				return true;
			}
		}
		return false;
	}
	
	public boolean isDiagonalWin() {
		if (board[0][2]==board[1][1] && board[0][2]==board[2][0] && board[0][2]!=TYPE.EMPTY) {
			System.out.println("Player " + board[0][2] + " won!!!");
			return true;
		}
		if (board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[0][0]!=TYPE.EMPTY) {
			System.out.println("Player " + board[0][0] + " won!!!");
			return true;
		}	
		else return false;
	}
	
	public boolean isTie() {
		int count=0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j]!=TYPE.EMPTY) {
					count+=1;
					if (count==9) {
						System.out.println("Nobody won!!!");
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isEndGame() {
		if (isDiagonalWin() || isHorizontalWin() || isVerticalWin() || isTie()) {
			return true;
		}
		return false;
	}
	
}
