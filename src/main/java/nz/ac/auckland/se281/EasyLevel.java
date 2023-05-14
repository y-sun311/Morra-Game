package nz.ac.auckland.se281;

import java.util.List;

public class EasyLevel implements Level {

  @Override
  public int[] process(List<Integer> playerFingerPlayed, int roundNumber) {
    // Create a new random strategy and use implemented( override) processStrategy
    // method to process the specific strategy entered.
    StrategyProcessor strategySystem = new StrategyProcessor(new RandomStrategy());

    return strategySystem.process(playerFingerPlayed);

  }

}
