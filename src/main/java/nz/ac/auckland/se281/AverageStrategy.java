package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy implements Strategy {

  @Override
  public int[] processStrategy(List<Integer> sumFIngers) {
    int finger = Utils.getRandomNumber(1, 5);
    int sum = 0;

    for (int i = 0; i < sumFIngers.size() - 1; i++) {
      sum = sum + sumFIngers.get(i);
    }
    int rounded = (int) Math.round((double) sum / (double) (sumFIngers.size() - 1));
    int sumFinal = rounded + finger;

    return new int[] { finger, sumFinal };
  }

}
