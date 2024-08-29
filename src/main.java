import java.util.*;

public class main {
    public static String getAIChoice() {
        List<String> strings = Arrays.asList("Rock", "Paper", "Scissors");

        if (strings == null || strings.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(strings.size());
        return strings.get(randomIndex);
    }

    public static void waitFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actualChoice = null;

        // give to the user choices
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.print("Choice: ");

        // get user's choice
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                actualChoice = "Rock";
                break;

            case 2:
                actualChoice = "Paper";
                break;

            case 3:
                actualChoice = "Scissors";
                break;
        
            default:
                System.out.println("Invalid choice!");
        }

        try {
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Rock.");
        waitFor(1000);
        System.out.println("Paper..");
        waitFor(1000);
        System.out.println("Scissors...");
        waitFor(1000);
        System.out.println("Shoot!");

        String AIChoice = getAIChoice();

        System.out.println("Your choice: " + actualChoice);
        System.out.println("Opponent's choice: " + AIChoice);

        if (actualChoice == "Rock" && AIChoice == ("Scissors")) {
            System.out.println("You win! Rock beats Scissors.");
        } else if (actualChoice == ("Paper") && AIChoice == ("Rock")) {
            System.out.println("You win! Paper beats Rock.");
        } else if (actualChoice == ("Scissors") && AIChoice == ("Paper")) {
            System.out.println("You win! Scissors beats Paper.");
        } else if (actualChoice == (AIChoice)) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("You lose! " + AIChoice + " beats " + actualChoice + ".");
        }

        scanner.close();
    }
}