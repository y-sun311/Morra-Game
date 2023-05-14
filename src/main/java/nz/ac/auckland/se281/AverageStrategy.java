package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy implements Strategy {

  @Override
  public int[] processStrategy(List<Integer> playerFingersPlayed) {
    // Generate a random integer from 1 to 5.
    int finger = Utils.getRandomNumber(1, 5);
    int sum = 0;
    // Calculate the sum of player finger played in previous rounds.
    for (int i = 0; i < playerFingersPlayed.size() - 1; i++) {
      sum = sum + playerFingersPlayed.get(i);
    }
    // Round the average value and add it to finger as sumJarvis.
    int rounded = (int) Math.round((double) sum / (double) (playerFingersPlayed.size() - 1));
    int sumJarvis = rounded + finger;
    return new int[] { finger, sumJarvis };
  }

}
