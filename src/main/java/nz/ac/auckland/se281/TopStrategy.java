package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class TopStrategy implements Strategy {

  @Override
  public int[] processStrategy(List<Integer> playerFingers) {

    // Creates a count integer array to store the number of times each integer
    // appears.
    int[] count = new int[5];

    // Loops through the playerFingers list and increments the count array at the
    // index of the integer.
    for (int n = 0; n < playerFingers.size() - 1; n++) {
      for (int i = 0; i < count.length; i++) {
        if (playerFingers.get(n) == i + 1) {
          count[i]++;
        }
      }
    }

    // Finds the maximum count.
    int max = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] > max) {
        max = count[i];
      }
    }

    List<Integer> mostFrequentNumber = new ArrayList<Integer>();
    for (int i = 0; i < count.length; i++) {
      if (count[i] == max) {
        mostFrequentNumber.add(i + 1);
      }
    }

    int finger = Utils.getRandomNumber(1, 5);
    int sum = 0;
    for (int i = 0; i < mostFrequentNumber.size(); i++) {
      sum = mostFrequentNumber.get(i) + finger;
    }

    return new int[] { finger, sum };
  }

}
