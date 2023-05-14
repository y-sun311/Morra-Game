package nz.ac.auckland.se281;

import java.util.List;

public class RandomStrategy implements Strategy {

  public int[] processStrategy(List<Integer> list) {
    int finger = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(finger + 1, finger + 5);

    return new int[] { finger, sum };
  }
}
