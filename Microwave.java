import java.util.Scanner;

/**
 * Program that calculates microwave cooking time for Sub, Pizza, or Soup.
 * User chooses food type and quantity (1–3), then program outputs time.
 *
 * @author  Jack Turcotte
 * @version 1.0
 * @since   2025-09-19
 */
public final class Microwave {

    /**
     * This is a private constructor used to
     * satisfy the style checker.
     *
     * @exception IllegalStateException Utility Class
     * @see IllegalStateException
     */
    private Microwave() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Runs the Microwave program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        // Get user input for food
        System.out.print("Are you heating a Sub, Pizza or Soup?: ");
        final Scanner foodScanner = new Scanner(System.in);
        final String foodString = foodScanner.nextLine();

        // Get user input for number
        System.out.print("How many " + foodString
            + "(s) are you cooking? (max: 3): ");
        final Scanner amountScanner = new Scanner(System.in);
        final String amountString = amountScanner.nextLine();

        // Check if food is valid
        if (foodString.equals("Sub")
                || foodString.equals("Pizza")
                || foodString.equals("Soup")) {

            // Check if amount is valid
            try {
                final double amountDouble = Double.parseDouble(amountString);
                if (amountDouble == 1 || amountDouble == 2
                        || amountDouble == 3) {
                    final double amountMultiplier = (0.5 * amountDouble) + 0.5;

                    // Determine food time based on food type
                    double foodTime = 0;
                    if (foodString.equals("Sub")) {
                        foodTime = 1;
                    } else if (foodString.equals("Pizza")) {
                        foodTime = 0.75;
                    } else if (foodString.equals("Soup")) {
                        foodTime = 1.75;
                    }

                    // Calculate time to cook
                    final double timeToCook = foodTime * amountMultiplier;

                    final double minutes = Math.floor(timeToCook);
                    final double seconds = (timeToCook - minutes) * 60;

                    // Display time to cook to user
                    System.out.println("It will take " + minutes
                        + " minutes and " + seconds + " seconds to cook "
                        + amountString + " " + foodString + "(s)");
                } else {
                    // User did not enter valid amount
                    System.out.println("Please enter a valid amount of "
                        + foodString + "(s). You entered "
                        + amountString);
                }
            } catch (NumberFormatException e) {
                // User did not enter a valid number
                System.out.println("Please enter a valid number of food to "
                    + "heat (1, 2 or 3)");
            }
        } else {
            // User did not enter valid food
            System.out.println("Please enter a valid food "
                    + "(Sub, Pizza or Soup). You entered "
            + foodString + ".");
        }

        // Close scanners
        foodScanner.close();
        amountScanner.close();
    }
}
