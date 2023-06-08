package com.premiumminds.internship.snail;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values that represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {

    if (matrix.length == 0) {
      return CompletableFuture.completedFuture(new int[0]);
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int[] snailShellArray = new int[rows * cols];
    int index = 0;

    // Test if the matrix is N*N
    if (rows != cols) {
      System.out.println("\nMatrix must be N*N\n");
      return CompletableFuture.completedFuture(null);
    }

    int topRow = 0;
    int bottomRow = rows - 1;
    int leftCol = 0;
    int rightCol = cols - 1;

    //Llgorithm for the Snailshellpattern with time complexity O(N)
    while (topRow <= bottomRow && leftCol <= rightCol) {
      // Traverse the top row of the matrix from left to right
      for (int i = leftCol; i <= rightCol; i++) {
        snailShellArray[index++] = matrix[topRow][i];
      }
      topRow++;

      // Traverse the right column of the matrix from top to bottom
      for (int i = topRow; i <= bottomRow; i++) {
        snailShellArray[index++] = matrix[i][rightCol];
      }
      rightCol--;

      // Check if there are still rows and columns to traverse
      if (topRow <= bottomRow) {
        // Traverse the bottom row of the matrix from right to left
        for (int i = rightCol; i >= leftCol; i--) {
          snailShellArray[index++] = matrix[bottomRow][i];
        }
        bottomRow--;
      }

      if (leftCol <= rightCol) {
        // Traverse the left column of the matrix from bottom to top
        for (int i = bottomRow; i >= topRow; i--) {
          snailShellArray[index++] = matrix[i][leftCol];
        }
        leftCol++;
      }
    }

    return CompletableFuture.completedFuture(snailShellArray);
  }
}
