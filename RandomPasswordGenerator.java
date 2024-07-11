import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Prompt user for the desired length of the password
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        // Prompt user for the inclusion of character types
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        // Character pools for password generation
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_=+<>?";

        // Create a pool of characters based on user choices
        StringBuilder characterPool = new StringBuilder();
        if (includeNumbers) characterPool.append(numbers);
        if (includeLowercase) characterPool.append(lowercase);
        if (includeUppercase) characterPool.append(uppercase);
        if (includeSpecial) characterPool.append(special);

        // Check if at least one character type is selected
        if (characterPool.length() == 0) {
            System.out.println("You must include at least one type of character to generate a password.");
            scanner.close();
            return;
        }

        // Generate the random password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }

        // Display the generated password
        System.out.println("Generated password: " + password.toString());

        scanner.close();
    }
}
