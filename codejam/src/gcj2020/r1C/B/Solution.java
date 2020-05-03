package gcj2020.r1C.B;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();

        for (int t = 0; t < numberOfTest; t++) {
            long U = sc.nextInt(); // up to U decimal digits

            //char[] res = new char[]{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'};

            HashMap<Character, Integer> firstCharMap = new HashMap<>();
            HashSet<Character> charSet = new HashSet<>();

            // We collected some data that we believe we can use to recover the secret digit string D from each server.
            // We sent 104 queries to each server.
            for (int i = 0; i < 10000; i++) {
                long Q = sc.nextLong(); // i-th query
                String R = sc.next(); // i-th response

                /*int curr = 0;
                for (int j = 0; j < R.length(); j++) {
                    char c = R.charAt(j);
                    int digit = getDigitFromRes(res, c);
                    if (digit == -1) {
                        int candidatePos = j == 0 ? 1 : 0;
                        for (; candidatePos < res.length; candidatePos++) {
                            if (res[candidatePos] == '-') {
                                res[candidatePos] = c;
                                curr = curr * 10 + candidatePos;
                                break;
                            }
                        }
                    } else {
                        curr = curr * 10 + digit;
                    }
                }

                if (curr > Q) {
                    // Invalid, remove
                    curr = 0;
                    for (int j = R.length() - 1; j >= 0; j--) {
                        int digit = getDigitFromRes(res, R.charAt(j));
                        curr = (int) (digit * Math.pow(10, R.length() - 1 - j) + curr);

                        if (curr > Q) {
                            res[digit] = '-';
                        }
                    }

                    *//*while (curr != 0) {
                        int digit = curr % 10;
                        curr = curr / 10;

                        res[digit] = '-';
                    }*//*
                }*/

                // Put all exists character to Set<>
                // Count all first character in Map<>
                for (int j = 0; j < R.length(); j++) {
                    char first = R.charAt(j);
                    charSet.add(first);
                    if (j == 0) {
                        firstCharMap.put(first, firstCharMap.getOrDefault(first, 0) + 1);
                    }
                }
            }

            // Convert first char Map<> to list
            ArrayList<P> firstCharCountList = new ArrayList<>();
            for (char v : firstCharMap.keySet()) {
                firstCharCountList.add(new P(v, firstCharMap.get(v)));
            }

            // Then sort it by count, DESC
            firstCharCountList.sort(new Comparator<P>() {
                @Override
                public int compare(P a, P b) {
                    return Integer.compare(b.count, a.count);
                }
            });


            char[] result = new char[10];
            for (int i = 1; i < 10; i++) {
                result[i] = firstCharCountList.get(i - 1).character;
                charSet.remove(firstCharCountList.get(i - 1).character);

                /*char c = firstCharCountList.get(i - 1).character;
                result[i] = c;
                charSet.remove(c); // Remove added chars*/
            }
            for (char c : charSet) {
                result[0] = c;
            }

            System.out.println("Case #" + (t + 1) + ": " + new String(result));
        }
    }

    public static int[] KMP(String val) {
        int i = 0;
        int j = -1;
        int[] result = new int[val.length() + 1];
        result[0] = -1;
        while (i < val.length()) {
            while (j >= 0 && val.charAt(j) != val.charAt(i)) {
                j = result[j];
            }
            j++;
            i++;
            result[i] = j;
        }
        return result;

    }

    /*private static int getDigitFromRes(char[] res, char c) {
        for (int i = 0; i < res.length; i++) {
            if (res[i] == c)
                return i;
        }
        return -1;
    }

    private static int digitCount(int number) {
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }

        return count;
    }

    private static boolean contains(char[] res, char c) {
        for (int i = 0; i < res.length; i++) {
            if (res[i] == c)
                return true;
        }
        return false;
    }*/

    public static boolean nextPer(int[] data) {
        int i = data.length - 1;
        while (i > 0 && data[i] < data[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = data.length - 1;
        while (data[j] < data[i - 1]) {
            j--;
        }
        int temp = data[i - 1];
        data[i - 1] = data[j];
        data[j] = temp;
        Arrays.sort(data, i, data.length);
        return true;
    }

    public static int digit(long n) {
        int result = 0;
        while (n > 0) {
            n /= 10;
            result++;
        }
        return result;
    }

    public static double dist(long a, long b, long x, long y) {
        double val = (b - a) * (b - a) + (x - y) * (x - y);
        val = Math.sqrt(val);
        double other = x * x + a * a;
        other = Math.sqrt(other);
        return val + other;

    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long pow(long a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }

        long val = pow(a, b / 2);
        if (b % 2 == 0) {
            return val * val;
        } else {
            return val * (val * a);

        }
    }

    private static class P {
        char character;
        int count;

        P(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public static class FT {

        long[] data;

        FT(int n) {
            data = new long[n];
        }

        public void update(int index, long value) {
            while (index < data.length) {
                data[index] += value;
                index += (index & (-index));
            }
        }

        public long get(int index) {
            long result = 0;
            while (index > 0) {
                result += data[index];
                index -= (index & (-index));
            }
            return result;

        }
    }

    private static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner() throws FileNotFoundException {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/lap12846/avengers/thor/100days-algorithm/codejam/src/gcj2020/r1C/B/sample.in"))));
        }

        public String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}


