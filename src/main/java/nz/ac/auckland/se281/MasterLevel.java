package nz.ac.auckland.se281;

import java.util.List;

public class MasterLevel implements Level {

  @Override
  public int[] process(List<Integer> sumFingers, int roundNumber) {
    // Use random strategy for the first three rounds.
    if (roundNumber <= 3) {
      StrategyProcessor strategy = new StrategyProcessor(new RandomStrategy());
      return strategy.process(sumFingers);
    } else if (roundNumber > 3) {
      // Use average strategy if the round number is 4,6,8,10...., i.e., even number
      // round number and greater than 3.
      if (roundNumber % 2 == 0) {
        StrategyProcessor strategy = new StrategyProcessor(new AverageStrategy());
        return strategy.process(sumFingers);
        // Use top strategy if the round number is 5,7,9,11...., i.e., odd number
        // round number and greater than 3.
      } else {
        StrategyProcessor strategy = new StrategyProcessor(new TopStrategy());
        return strategy.process(sumFingers);
      }

    }
    return null;
  }

}
