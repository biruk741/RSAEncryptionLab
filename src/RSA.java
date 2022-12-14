import java.math.BigInteger;
import java.util.ArrayList;

public class RSA {

    public enum PairType {
        PUBLIC, PRIVATE
    }

    public static class KeyPair {
        PairType type;

        BigInteger a, b, c;

        public KeyPair(PairType type, BigInteger a, BigInteger b, BigInteger... c) {
            this.type = type;
            this.a = a;
            this.b = b;

            if (type == PairType.PUBLIC && c.length != 0)
                throw new IllegalArgumentException("Too many inputs for public key");

            if (type == PairType.PRIVATE) this.c = c[0];
        }

        public BigInteger[] getPublicKey() {
            return new BigInteger[]{a, b};
        }

        public BigInteger[] getPrivateKey() {
            return new BigInteger[]{a, b, c};
        }

        public String toString() {
            if (this.type == PairType.PUBLIC)
                return "[n = " + a + ", e = " + b + "]";
            return "[p = " + a + ", q = " + b + ", d = " + c + "]";
        }
    }

    public static BigInteger encrypt(BigInteger x, BigInteger e, BigInteger n){
        return x.modPow(e,n);
    }
    public static BigInteger decrypt(BigInteger y, BigInteger d, BigInteger n){
        return y.modPow(d,n);
    }

    public static KeyPair[] generateKeyPair(BigInteger p, BigInteger q) {
        // Changed generateKeyPair to take two BigIntergers p, q.
        BigInteger n = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = findE(phi);

        BigInteger d = e.modInverse(phi);

        return new KeyPair[]{
                new KeyPair(PairType.PUBLIC, n, e),
                new KeyPair(PairType.PRIVATE, p, q, d),
        };
    }

    public static BigInteger findE(BigInteger phi) {
        for (int i = 2; i < phi.intValue(); i++) {
            BigInteger e = BigInteger.valueOf(i);
            if (areRelativelyPrime(e, phi))
                return e;
        }
        throw new ArithmeticException("No possible values for e were found.");
    }

    private static boolean areRelativelyPrime(BigInteger a, BigInteger b) {
        return gcd(a,b).equals(BigInteger.ONE);
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) return a;
        return gcd(b,a.mod(b));
    }
}
