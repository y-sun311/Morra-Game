package nz.ac.auckland.se281;

import java.util.List;

public class EasyLevel implements Level {

  @Override
  public int[] process(List<Integer> sumFIngers, int roundNumber) {
    StrategyProcessor strategySystem = new StrategyProcessor(new RandomStrategy());

    return strategySystem.process(sumFIngers);

  }

}
