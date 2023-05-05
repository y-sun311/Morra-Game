package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int roundNumber = 0;
  private int finger;
  private int sum;
  private String player;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.player = options[0];
  }

  public void play() {
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

      // If the user input is not 2 numbers, immidiately ask for input again.

      try {
        double finger = Double.parseDouble(stringArray[0]);
        double sum = Double.parseDouble(stringArray[1]);
        if (finger >= 1
            && finger <= 5
            && sum >= 1
            && sum <= 10
            && finger == (int) finger
            && sum == (int) sum
            && stringArray.length == 2) {
          validNumber = true;
          this.finger = (int) finger;
          this.sum = (int) sum;
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

    MessageCli.PRINT_INFO_HAND.printMessage(player, String.valueOf(finger), String.valueOf(sum));
  }

  public void showStats() {}
}
