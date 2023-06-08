package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.Arrays;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
    System.out.println("\nTeste 1: " + Arrays.toString(result) + "\n");
  }

  @Test
  public void SnailShellPatternTest2()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
    assertArrayEquals(result, expected);
    System.out.println("\nTest 2 getSnailShell: " + Arrays.toString(result) + "\n");
  }

  @Test
  public void SnailShellPatternTest7x7Matrix()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
        { 1, 2, 3, 4, 5, 6, 7 },
        { 24, 25, 26, 27, 28, 29, 8 },
        { 23, 40, 41, 42, 43, 30, 9 },
        { 22, 39, 48, 49, 44, 31, 10 },
        { 21, 38, 47, 46, 45, 32, 11 },
        { 20, 37, 36, 35, 34, 33, 12 },
        { 19, 18, 17, 16, 15, 14, 13 }
    };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {
        1, 2, 3, 4, 5, 6, 7,
        8, 9, 10, 11, 12, 13, 14,
        15, 16, 17, 18, 19, 20, 21,
        22, 23, 24, 25, 26, 27, 28,
        29, 30, 31, 32, 33, 34, 35,
        36, 37, 38, 39, 40, 41, 42,
        43, 44, 45, 46, 47, 48, 49
    };
    assertArrayEquals(result, expected);
    System.out.println("\nTest 3 getSnailShell: " + Arrays.toString(result) + "\n");
  }

  @Test
  public void testEmptyMatrix() throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = new int[0][0];
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = new int[0];
    assertArrayEquals(result, expected);
    System.out.println("\nTest for empty matrix: " + Arrays.toString(result) + "\n");
  }

  @Test
  public void testNonSquareMatrix() throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
        { 1, 2, 3 },
        { 4, 5, 6 }
    };
    Future<int[]> result = new SnailShellPattern().getSnailShell(matrix);
    assertNull(result.get(10, TimeUnit.SECONDS));
  }

}