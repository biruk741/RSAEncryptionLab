import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("----------- RSA Encryption Lab -----------");
        mainPrompt();
    }

    private static void mainPrompt() {
        System.out.println("1. Encrypt\n2. Decrypt\n3. Generate key pair");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> encryptPrompt();
            case 2 -> decryptPrompt();
            case 3 -> generateKeyPair();
        }
        mainPrompt();
    }

    private static void encryptPrompt() {
        System.out.println("1. ECB\n2. CTR\n3. CBC\n4. CFB\n5. OFB\n6. Run all modes");
        int choice = scanner.nextInt();
        System.out.println("Please enter the plaintext:");
//        switch (choice) {
//            case 1 -> ECB(scanner2.nextLine());
//            case 2 -> CTR(scanner2.nextLine());
//            case 3 -> CBC(scanner2.nextLine());
//            case 4 -> CFB(scanner2.nextLine());
//            case 5 -> OFB(scanner2.nextLine());
//            case 6 -> runAll(scanner2.nextLine());
//        }
        mainPrompt();
    }

    private static void decryptPrompt() {
        System.out.println("1. ECB\n2. CTR\n3. CBC\n4. CFB\n5. OFB\n");
        int choice = scanner.nextInt();
        System.out.println("Please enter the ciphertext:");
//        switch (choice) {
//            case 1 -> ECBDecrypt(scanner2.nextLine());
//            case 2 -> CTRDecrypt(scanner2.nextLine());
//            case 3 -> CBCDecrypt(scanner2.nextLine());
//            case 4 -> CFBDecrypt(scanner2.nextLine());
//            case 5 -> OFBDecrypt(scanner2.nextLine());
//        }
        mainPrompt();
    }

    private static void generateKeyPair() {
        System.out.println("Please enter a value for p:");
        int p = scanner.nextInt();
        System.out.println("Please enter a value for q:");
        int q = scanner.nextInt();

        RSA.KeyPair[] keyPairs = RSA.generateKeyPair(p,q);

        System.out.println("The public key is: " + keyPairs[0]);
        System.out.println("The private key is: " + keyPairs[1]);

        mainPrompt();
    }
}