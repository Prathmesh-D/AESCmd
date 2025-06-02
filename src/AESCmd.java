package src;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AESCmd {

    private static final String ALGORITHM = "AES";
    private static final String ENCODING = "UTF-8";

    public static String encrypt(String value, String key) throws Exception {
        if (key.length() != 16) {
            throw new IllegalArgumentException("Key must be 16 characters long.");
        }
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(ENCODING), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(value.getBytes(ENCODING));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedValue, String key) throws Exception {
        if (key.length() != 16) {
            throw new IllegalArgumentException("Key must be 16 characters long.");
        }
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(ENCODING), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedValue);
        byte[] decryptedBytes = cipher.doFinal(decodedValue);
        return new String(decryptedBytes, ENCODING);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to AES Encryption/Decryption Program!");

        while (true) {
            try {
                System.out.println("\nChoose an option:");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        System.out.print("Enter the plaintext: ");
                        String plaintext = scanner.nextLine();
                        System.out.print("Enter the key (16 characters long): ");
                        String encKey = scanner.nextLine();
                        String encryptedText = encrypt(plaintext, encKey);
                        System.out.println("Encrypted text: " + encryptedText);
                        break;

                    case 2:
                        System.out.print("Enter the ciphertext: ");
                        String ciphertext = scanner.nextLine();
                        System.out.print("Enter the key (16 characters long): ");
                        String decKey = scanner.nextLine();
                        String decryptedText = decrypt(ciphertext, decKey);
                        System.out.println("Decrypted text: " + decryptedText);
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); 
            }
        }
    }
}
