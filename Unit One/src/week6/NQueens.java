package week6;

import java.util.Scanner;
import java.util.Stack;
import week6.Queen;

public class NQueens {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.println("Enter Queen #:");
    int n = Integer.parseInt(in.nextLine());
    printIt(solveNQueens(n), n);
    in.close();

  }


  /**
   * Creating a board via ASCII, and placing Queens via printed "Q"s. Empty spots replaced with an astrix.
   * @param solveNQueens 
   * @param n Input.
   */
  private static void printIt(Stack<Queen> solveNQueens, int n) {
    
    String p;
    String [][] board = new String [n][n];

    for (int k = 0; k < n; k++){

      Queen q = solveNQueens.peek();
      int a = q.getRow()-1;
      int b = q.getCol()-1;
      board [a][b] = "Q";
      solveNQueens.pop();
    
    }

    for (int j = 0; j < n; j++){

      for (int h = 0; h <  n; h++){

        if (board[j][h] == null)
          board [j][h] = "*";

      }

    }

    for (int y = 0; y < n; y++){

      System.out.println();

      for (int x = 0; x<n; x++){

        p = board[y][x];
        System.out.print(p+" ");

      }

    }

  }

  /**
   * Queens are placed and positioned.
   * @param n Input.
   * @return
   */
  private static Stack<Queen> solveNQueens(int n) {
        
    Stack<Queen> goodQueens = new Stack<Queen>();
    int numFilled = 0;
    Queen q = new Queen(1, 1);
    goodQueens.push(q);
    numFilled++;

    int col = 0;

    while (numFilled != n) {

      int row = numFilled + 1;
      col++;

      if (!conflict(new Queen(row, col), goodQueens)&&(col<=n)) {

        goodQueens.push(new Queen(row, col));
        numFilled++;
        col = 0;

      } 

      else {

        if (col + 1 > n) {

           q = goodQueens.pop();
           col = q.getCol();
            numFilled--;

        }

      }   

    }

    return goodQueens;

  }


  /**
   * Conflict checks to see queens are at conflict (Essentially checks if queens are in check with eachother).
   * @param queen
   * @param goodQueens
   * @return
   */
  private static boolean conflict(Queen queen, Stack<Queen> goodQueens) {
    Stack<Queen> temp = new Stack<Queen>();

    while(!goodQueens.isEmpty()){

      Queen q = goodQueens.peek();

      if (q.getCol() == queen.getCol() || q.getRow() == queen.getRow() || (Math.abs(q.getCol() - queen.getCol()) == Math.abs(q.getRow() - queen.getRow()))) {

        while (!temp.isEmpty())
          goodQueens.push(temp.pop());
        return true;

      }
      
      else {

        temp.push(goodQueens.pop());

      }

    }

    while (!temp.isEmpty())

    goodQueens.push(temp.pop());

    return false;  

  }

}