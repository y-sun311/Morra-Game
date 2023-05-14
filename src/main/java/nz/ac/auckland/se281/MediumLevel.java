package nz.ac.auckland.se281;

import java.util.List;

public class MediumLevel implements Level {

  @Override
  // This method implements the medium level and pass a list of previous player
  // guess for sum of finers and the current round number.
  public int[] process(List<Integer> playerFingerPlayed, int roundNumber) {
    // Use random strategy for the first three rounds and average strategy for the
    // fourth onwards.
    if (roundNumber <= 3) {
      StrategyProcessor strategySystem = new StrategyProcessor(new RandomStrategy());
      return strategySystem.process(playerFingerPlayed);
    } else {
      StrategyProcessor strategySystem = new StrategyProcessor(new AverageStrategy());
      return strategySystem.process(playerFingerPlayed);
    }

  }

}
