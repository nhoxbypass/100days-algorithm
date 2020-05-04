package covid19_1.day4_number_complement;

class Solution {
    public static void main(String[] args) {
        int res = findComplement(5);
        System.out.println(res);
    }

    public static int findComplement(int N) {
        int sum = 0;
        long pow = 1;

        // We travel to each bit to flip
        // Do, while is used because if N is 0, then it has to add 1 (and not go directly out of the loop).
        do {
            // We check the rightmost bit is `0` by check whether it's divided by 2 (because the last bit is 2^0=1)
            if (N % 2 == 0) {
                // Reverse of the last bit is `1` --> add to result
                sum += pow;
            }

            // Shift to the next bit
            N = (N >> 1);

            // Increase the power (of 2)
            pow *= 2;
        } while (N != 0);

        return sum;
    }
}