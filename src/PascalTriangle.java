public class PascalTriangle {
    static void printPascal(int n) {
        for (int i = 0; i < n; i++) {
            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    static int nCr(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);

        }
        return result;
    }


    static void main(String[] args) {
        printPascal(5);
        System.out.println(nCr(4,2));
    }
}
