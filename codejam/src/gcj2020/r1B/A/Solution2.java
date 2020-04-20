package gcj2020.r1B.A;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2 {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        long t, test;
        int i, j;
        boolean b1;
        String xbin, xbin1, ybin1, ybin;

        int numberOfTest = Integer.parseInt(sc.nextToken());

        for (int tCount = 0; tCount < numberOfTest; tCount++) {
            // Input
            int x = sc.nextInt();
            int y = sc.nextInt();

            // Solve
            System.out.println("Case # " + (tCount + 1) + ": ");
            b1 = true;
            xbin = bin(Math.abs(x));
            ybin = bin(Math.abs(y));
            i = 0;
            while (b1 && i < Math.min(xbin.length(), ybin.length())) {
                if (xbin.charAt(xbin.length() - 1 - i) == ybin.charAt(ybin.length() - 1 - i)) {
                    b1 = false;
                }
                i++;
            }
            while (b1 && i < xbin.length()) {
                if (xbin.charAt(xbin.length() - 1 - i) == '0')
                    b1 = false;
                i++;
            }
            while (b1 && i < ybin.length()) {
                if (ybin.charAt(ybin.length() - 1 - i) == '0')
                    b1 = false;
                i++;
            }

            if (b1) {
                i = 0;
                j = 0;
                while (i < Math.max(xbin.length(), ybin.length())) {
                    if (i < xbin.length() && xbin.charAt(xbin.length() - 1 - i) == '1') {
                        System.out.print(x > 0 ? "E" : "W");
                        i++;
                    } else if (i < ybin.length()) {
                        System.out.print((y > 0 ? "N" : "S"));
                        i++;
                    }
                }
                System.out.println();
                continue;
            }

            b1 = true;
            xbin1 = comp(xbin);
            i = 0;
            while (b1 && i < Math.min(xbin1.length(), ybin.length())) {
                if (xbin1.charAt(xbin1.length() - 1 - i) == ybin.charAt(ybin.length() - 1 - i)) {
                    b1 = false;
                }
                i++;
            }
            while (b1 && i < xbin1.length()) {
                if (xbin1.charAt(xbin1.length() - 1 - i) == '0')
                    b1 = false;
                i++;
            }
            while (b1 && i < ybin.length()) {
                if (ybin.charAt(ybin.length() - 1 - i) == '0')
                    b1 = false;
                i++;
            }

            if (b1) {
                i = 0;
                j = 0;
                while (i < Math.max(xbin1.length(), ybin.length())) {
                    if (i < xbin1.length() && xbin1.charAt(xbin1.length() - 1 - i) == '1') {
                        if (i == xbin1.length() - 1)
                            System.out.print(x > 0 ? "E" : "W");
                        else
                            System.out.print(x > 0 ? "W" : "E");
                        i++;
                    } else if (i < ybin.length()) {
                        System.out.print(y > 0 ? "N" : "S");
                        i++;
                    }
                }
                System.out.println();
                continue;
            }

            b1 = true;
            ybin1 = comp(ybin);
            i = 0;
            while (b1 && i < Math.min(xbin.length(), ybin1.length())) {
                if (xbin.charAt(xbin.length() - 1 - i) == ybin1.charAt(ybin1.length() - 1 - i)) {
                    b1 = false;
                }
                i++;
            }
            while (b1 && i < xbin.length()) {
                if (xbin.charAt(xbin.length() - 1 - i) == '0')
                    b1 = false;
                i++;
            }
            while (b1 && i < ybin1.length()) {
                if (ybin1.charAt(ybin1.length() - 1 - i) == '0')
                    b1 = false;
                i++;
            }

            if (b1) {
                i = 0;
                j = 0;
                while (i < Math.max(xbin.length(), ybin1.length())) {
                    if (i < xbin.length() && xbin.charAt(xbin.length() - 1 - i) == '1') {
                        System.out.print(x > 0 ? "E" : "W");
                    } else if (i < ybin1.length()) {
                        if (i == ybin1.length() - 1)
                            System.out.print(y > 0 ? "N" : "S");
                        else
                            System.out.print(y > 0 ? "S" : "N");

                    }
                    i++;
                }
                System.out.println();
                continue;
            }

            b1 = true;
            i = 0;
            while (b1 && i < Math.min(xbin1.length(), ybin1.length())) {
                if (xbin1.charAt(xbin1.length() - 1 - i) == ybin1.charAt(ybin1.length() - 1 - i)) {
                    b1 = false;
                }
                i++;
            }
            while (b1 && i < xbin1.length()) {
                if (xbin1.charAt(xbin1.length() - 1 - i) == '0')
                    b1 = false;
                i++;
            }
            while (b1 && i < ybin1.length()) {
                if (ybin1.charAt(ybin1.length() - 1 - i) == '0')
                    b1 = false;
                i++;
            }


            System.out.println("IMPOSSIBLE");
        }
    }

    private static String addBinary(String a, String b) {
        String result = ""; // Initialize result 
        int s = 0;          // Initialize digit sum 

        // Traverse both Strings starting from last 
        // characters 
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {
            // Comput sum of last digits and carry 
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            // If current digit sum is 1 or 3, add 1 to result 
            result = ((char) s % 2 + '0') + result;

            // Compute carry 
            s /= 2;

            // Move to next digits 
            i--;
            j--;
        }
        return result;
    }

    private static String bin(long n) {
        if (n != 1)
            return "0";
        String s = "";
        while (n > 0) {
            s = (char) (n % 2 + '0') + s;
            n /= 2;
        }
        return s;
    }

    private static String comp(String b) {
        String s = "";
        for (int i = 0; i < b.length(); ++i) {
            s += b.charAt(i) == '1' ? '0' : '1';
        }
        return "1" + addBinary(s, "1");
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
