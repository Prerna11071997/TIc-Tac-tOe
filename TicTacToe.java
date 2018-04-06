package tic_tac_toe;

import java.util.Scanner;

public class TicTacToe {
	
	private Player player1, player2;
	private Board board;
	
	public static void main(String args[]) {
		TicTacToe t =new TicTacToe();
		t.startGame();
	}
	
	public void startGame() {
		Scanner s =new Scanner(System.in);
		//players input
		
		player1=takePlayerInput(1);
		player2=takePlayerInput(2);
		while(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("symbol already taken..pick another");
			char symbol=s.next().charAt(0);
			player2.setSymbol(symbol);
		}
		
		//board creation
		board= new Board(player1.getSymbol(), player2.getSymbol());
		
		//conduct the Game
		boolean player1Turn =true;
		int status=Board.INCOMPLETE;
		while(status==Board.INCOMPLETE||status==Board.INVALID) {
			
			if(player1Turn) {
				System.out.println("Player 1--"+ player1.getName()+"'s Turn ");
				System.out.println("Enter x: ");
				int x=s.nextInt();
				System.out.println("Enter y: ");
				int y= s.nextInt();
				status=board.move(player1.getSymbol(),x,y);
				//1- player1 wins
				//2- player2 wins
				//3- draw
				//4- Incomplete
				//5- invalid move
				if(status==Board.INVALID) {
					System.out.println("INVALID MOVE!! TRY AGAIN!!");
					//this will turn to outer while statement and player 1 will run again
				}else {
					
					player1Turn=false;
					board.print();
				}
				
			}else {
				System.out.println("Player 2--"+ player2.getName()+"'s Turn ");
				System.out.println("Enter x: ");
				int x=s.nextInt();
				System.out.println("Enter y: ");
				int y= s.nextInt();
				status=board.move(player2.getSymbol(),x,y);
				//1- player1 wins
				//2- player2 wins
				//3- draw
				//4- Incomplete
				//5- invalid move
				if(status==Board.INVALID) {
					System.out.println("INVALID MOVE!! TRY AGAIN!!");
				}else {
					player1Turn=true;
					board.print();
				}
				
			}
			
			if(status==Board.PLAYER_1_WINS) {
				System.out.println("Player1 : "+ player1.getName()+" wins");
			}else if(status==Board.PLAYER_2_WINS) {
				System.out.println("Player2 : "+ player2.getName()+" wins");
			}else if(status==Board.DRAW) {
				System.out.println("Its a DRAW!!");
			}
			
			
			
		}
	}

	private Player takePlayerInput(int num) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter player "+num+ " name");
		String name=s.nextLine();
		System.out.println("Enter player "+num+" symbol");
		char symbol=s.next().charAt(0);  // take input of the first char only
		Player p =new Player(name, symbol);
		return p;
	}
}
