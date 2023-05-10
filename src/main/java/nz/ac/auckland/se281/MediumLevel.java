package nz.ac.auckland.se281;

import java.util.List;

public class MediumLevel implements Level {

  @Override
  public int[] process(List<Integer> sumFingers, int roundNumber) {
    if (roundNumber <= 3) {
      StrategyProcessor strategySystem = new StrategyProcessor(new RandomStrategy());
      return strategySystem.process(sumFingers);
    } else {
      StrategyProcessor strategySystem = new StrategyProcessor(new AverageStrategy());
      return strategySystem.process(sumFingers);
    }

  }

}
