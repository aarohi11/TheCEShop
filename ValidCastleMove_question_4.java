import java.util.Scanner;

// Q-3: Find valid castling move
// Logic: As only rook and king are given and they have not changed their positions, if they are in same row, castling is possible
// either from king/queen side, else no

public class ValidCastleMove 
{
	public static boolean checkMoves(String [][]chessboard)
	{
		int m = chessboard.length;
		int n = chessboard[0].length;
		// Case-1: Black-King and Black rook
		if((chessboard[0][0] == "R" || chessboard[0][n-1]=="R") && chessboard[0][4] == "K")
		{
			//System.out.println("\n Inside first if:");
			return true;
		}
		
		// Case-2: White-King and White rook
		else if((chessboard[m-1][0] == "R" || chessboard[m-1][n-1]=="R") && chessboard[m-1][4] == "K")
		{
			//System.out.println("\n Inside second if:");
			return true;
		}
		
		// Case-3: Black-King and white rook
		else if((chessboard[m-1][0] == "R" || chessboard[m-1][n-1]=="R") && chessboard[0][4] == "K")
		{
			//System.out.println("\n Inside third if:");
			return false;
		}
		
		// Case-4: White-King and black rook
		else if((chessboard[0][0] == "R" || chessboard[0][n-1]=="R") && chessboard[m-1][4] == "K")
		{
			//System.out.println("\n Inside fourth if:");
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("\n Enter rows on chessboard:");
		int m = scan.nextInt();
		System.out.println("\n Enter columns on chessboard:");
		int n = scan.nextInt();
		String [][]chessboard = new String[m][n];
		
		System.out.println("\n Enter row for rook:");
		int rook_row = scan.nextInt();
		System.out.println("\n Enter col for rook:");
		int rook_col = scan.nextInt();
		
		chessboard[rook_row][rook_col] = "R";
		
		System.out.println("\n Enter row for King:");
		int king_row = scan.nextInt();
		System.out.println("\n Enter col for King:");
		int king_col = scan.nextInt();
		
		chessboard[king_row][king_col] = "K";
		boolean validMoves = checkMoves(chessboard);
		System.out.println("\n Rook at row:"+rook_row+" and col:"+rook_col+" castles king at row:"+king_row+" and col:"+king_col+":"+validMoves);
	}
}
