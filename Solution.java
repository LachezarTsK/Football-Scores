package JavaJava.footballScores;

import java.util.Scanner;

public class Challenge {
  private static final int[] BASE_SCORES = {2, 3, 6, 7, 8};

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int score = scanner.nextInt();
    scanner.close();

    int waysToComposeScore = calculate_waysToComposeScore_in_americanFootball(score);
    System.out.println(waysToComposeScore);
  }

  /**
   * Calculates all possible ways to compose a score, by combining the given base scores, in
   * American football.
   *
   * @return An interger, representing all alternatives to compose the score, as described.
   */
  public static int calculate_waysToComposeScore_in_americanFootball(int score) {

    int[] ways_toComposeScore = new int[score + 1];
    ways_toComposeScore[0] = 1;

    for (int i = 0; i < BASE_SCORES.length; i++) {
      for (int j = BASE_SCORES[i]; j <= score; j++) {
        ways_toComposeScore[j] = ways_toComposeScore[j] + ways_toComposeScore[j - BASE_SCORES[i]];
      }
    }
    return ways_toComposeScore[score];
  }
}
