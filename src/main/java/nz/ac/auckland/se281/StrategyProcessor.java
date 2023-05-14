package nz.ac.auckland.se281;

import java.util.List;

public class StrategyProcessor {

  private Strategy strategy;

  public StrategyProcessor(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;

  }

  public int[] process(List<Integer> playerFingerPlayed) {
    return strategy.processStrategy(playerFingerPlayed);

  }

}
