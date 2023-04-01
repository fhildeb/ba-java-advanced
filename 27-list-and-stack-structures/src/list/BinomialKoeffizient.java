package list;

public class BinomialKoeffizient {
    int n;
    int k;

    public BinomialKoeffizient(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public String toString() {
        return "(" + n + "|" + k + ")";
    }

    public static void main(String[] args) {
        ObjectStack problemstapel = new ObjectStack();

        BinomialKoeffizient binkof = new BinomialKoeffizient(5, 3);

        int result = 0;

        problemstapel.push(binkof);

        while (!problemstapel.isEmpty()) {
            System.out.println(problemstapel.toString());
            BinomialKoeffizient bk = (BinomialKoeffizient) problemstapel.pop();
            if (bk.k == 0 || bk.k == bk.n) {
                result += 1;
            } else {
                BinomialKoeffizient biko = new BinomialKoeffizient(bk.n - 1, bk.k - 1);
                BinomialKoeffizient bkoef = new BinomialKoeffizient(bk.n - 1, bk.k);
                problemstapel.push(biko);
                problemstapel.push(bkoef);
            }
        }

        System.out.println(binkof.toString() + " = " + result);

    }

}