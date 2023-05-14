package nz.ac.auckland.se281;

import java.util.List;

public class HardLevel implements Level {

  @Override
  // The method process pass List of sum of fingers of player input, and the
  // current round number.
  public int[] process(List<Integer> playerFingerPlayed, int roundNumber) {
    // Use random strategy for the first three rounds.
    if (roundNumber <= 3) {
      StrategyProcessor strategy = new StrategyProcessor(new RandomStrategy());
      return strategy.process(playerFingerPlayed);
      // Use top strategy for the fourth round onwards.
    } else {
      StrategyProcessor strategy = new StrategyProcessor(new TopStrategy());
      return strategy.process(playerFingerPlayed);
    }
  }

}
