import java.math.BigInteger;
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

    /*
        Since numbers that are too big to fit into integers broke .nextInt(), I construct a new BigInteger object
        by feeding the constructor a string of a BigInteger.
     */
    private static void encryptPrompt() {
        System.out.println("Enter a number to encrypt: ");
        BigInteger x = new BigInteger(scanner2.nextLine().replace(",", ""));
        System.out.println("Enter the public exponent: ");
        BigInteger e = new BigInteger(scanner2.nextLine().replace(",", ""));
        System.out.println("Enter n: ");
        BigInteger n = new BigInteger(scanner2.nextLine().replace(",", ""));
        System.out.println("The result is: " + RSA.encrypt(x,e,n));
        mainPrompt();
    }

    private static void decryptPrompt() {
        System.out.println("Enter a number to decrypt: ");
        BigInteger y = new BigInteger(scanner2.nextLine().replace(",", ""));
        System.out.println("Enter the private exponent: ");
        BigInteger d = new BigInteger(scanner2.nextLine().replace(",", ""));
        System.out.println("Enter n: ");
        BigInteger n = new BigInteger(scanner2.nextLine().replace(",", ""));
        System.out.println("The result is: " + RSA.decrypt(y,d,n));
        mainPrompt();
    }

    private static void generateKeyPair() {
        System.out.println("Please enter a value for p:");
        BigInteger p = new BigInteger(scanner2.nextLine().replace(",", ""));
        System.out.println("Please enter a value for q:");
        BigInteger q = new BigInteger(scanner2.nextLine().replace(",", ""));

        RSA.KeyPair[] keyPairs = RSA.generateKeyPair(p,q);

        System.out.println("The public key is: " + keyPairs[0]);
        System.out.println("The private key is: " + keyPairs[1]);

        mainPrompt();
    }
}