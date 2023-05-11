package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int roundNumber = 0;
  public int fingerHuman;
  public int sumHuman;
  private String player;
  private String chosenLevel;
  private List<Integer> playerFinger = new ArrayList<Integer>();
  private int gameStatus = 0;
  private int pointsWin;
  private int humanPoints;
  private int aiPoints;

  public Morra() {
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.player = options[0];
    this.chosenLevel = difficulty.name();
    // Clear the playerFinger list and reset the round number for each new game.
    playerFinger.clear();
    roundNumber = 0;
    humanPoints = 0;
    aiPoints = 0;
    gameStatus = 1;
    this.pointsWin = pointsToWin;
  }

  public void play() {

    // Check if play is run before a new game created
    if (gameStatus == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Initialise round number.
    roundNumber++;
    boolean validNumber = false;

    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));
    // Ask for user input for fingers and sum.
    MessageCli.ASK_INPUT.printMessage();

    while (validNumber == false) {

      String input = Utils.scanner.nextLine();

      // Split user input to integer array.
      String[] stringArray = input.split(" ");

      try {
        double finger = Double.parseDouble(stringArray[0]);
        double sum = Double.parseDouble(stringArray[1]);
        if (finger >= 1 && finger <= 5 && sum >= 1 && sum <= 10 && finger == (int) finger
            && sum == (int) sum && stringArray.length == 2) {
          validNumber = true;
          this.fingerHuman = (int) finger;
          this.sumHuman = (int) sum;
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }
        // Print error message if the user input is not a number.
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
      } catch (Exception e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    MessageCli.PRINT_INFO_HAND.printMessage(player, String.valueOf(fingerHuman),
        String.valueOf(sumHuman));

    playerFinger.add(fingerHuman);

    // Create the difficulty level based on the user input and process strategy
    // based on the
    // difficulty level.
    Level level = DifficultyFactory.createLevel(chosenLevel);
    int[] result = level.process(playerFinger, roundNumber);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(result[0]),
        String.valueOf(result[1]));

    // Compare the result of the human and AI and print the outcome of the round.
    if (result[0] + fingerHuman == sumHuman && result[0] + fingerHuman != result[1]) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      humanPoints++;
    } else if (result[0] + fingerHuman == result[1] && result[0] + fingerHuman != sumHuman) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      aiPoints++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

    if (humanPoints == pointsWin) {
      MessageCli.END_GAME.printMessage(player, String.valueOf(roundNumber));
      gameStatus = 0;

    }

    if (aiPoints == pointsWin) {
      MessageCli.END_GAME.printMessage("Jarvis", String.valueOf(roundNumber));
      gameStatus = 0;
    }

  }

  public void showStats() {
    if (gameStatus == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(player, String.valueOf(humanPoints),
        String.valueOf(pointsWin - humanPoints));
    MessageCli.PRINT_PLAYER_WINS.printMessage("Jarvis", String.valueOf(aiPoints), String.valueOf(pointsWin - aiPoints));

  }
}
