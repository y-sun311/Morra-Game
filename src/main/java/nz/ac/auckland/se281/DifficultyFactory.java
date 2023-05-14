package nz.ac.auckland.se281;

public class DifficultyFactory {

  public static Level createLevel(String level) {
    // Return new difficulty level depending on user input.
    if (level.equalsIgnoreCase("easy")) {
      return new EasyLevel();
    } else if (level.equalsIgnoreCase("medium")) {
      return new MediumLevel();
    } else if (level.equalsIgnoreCase("hard")) {
      return new HardLevel();
    } else if (level.equalsIgnoreCase("master")) {
      return new MasterLevel();
      // If neither of the difficult level entered, return null.
    } else {
      return null;
    }

  }

}
