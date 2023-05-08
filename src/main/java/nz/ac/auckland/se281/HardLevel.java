package nz.ac.auckland.se281;

import java.util.List;

public class HardLevel implements Level {

    @Override
    public int[] process(List<Integer> sumFingers, int roundNumber) {
        if (roundNumber <= 3) {
            StrategyProcessor strategy = new StrategyProcessor(new RandomStrategy());
            return strategy.process(sumFingers);
        } else {
            StrategyProcessor strategy = new StrategyProcessor(new TopStrategy());
            return strategy.process(sumFingers);
        }
    }

}
