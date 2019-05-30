package jamal.math;

public class EuclidAlgo_GreatestCommonDivisor {


    public static void main(String[] args) {
        EuclidAlgo_GreatestCommonDivisor euclidAlgo_greatestCommonDivisor = new EuclidAlgo_GreatestCommonDivisor();

        System.out.println(euclidAlgo_greatestCommonDivisor.gcd(55, 77));
    }

    private int gcd(int n1, int n2) {

        if (n2 == 0) {
            return n1;
        }

        return gcd(n2, n1 % n2);

    }

}
