import java.util.Scanner;

public class AppRun {
    private static void invalidInput() {
        System.out.println("\nInvalid input\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInputOption = scanner.nextLine();
            if (userInputOption.equals("0")) {
                //
            } else if (userInputOption.equals("1")) {
                //
            } else if (userInputOption.equals("2")) {
                break;
            } else {
                invalidInput();
            }
        }
        scanner.close();
    }
}
