package com.iceteaviet;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();

        for (int i = 0; i < numberOfTest; i++) {
            // Input
            int n = sc.nextInt();
            int k1 = sc.nextInt();
            int k2 = sc.nextInt();

            int[] p1Cards = new int[k1];
            int[] p2Cards = new int[k2];

            for (int j = 0; j < k1; j++) {
                p1Cards[j] = sc.nextInt();
            }
            for (int j = 0; j < k2; j++) {
                p2Cards[j] = sc.nextInt();
            }

            // Process
            int p1Max = max(p1Cards);
            int p2Max = max(p2Cards);

            // Result
            if (p1Max > p2Max)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static int max(int[] t) {
        int maximum = t[0];   // start with the first value
        for (int i = 1; i < t.length; i++) {
            if (t[i] > maximum) {
                maximum = t[i];   // new maximum
            }
        }
        return maximum;
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
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
                    // TODO Auto-generated catch block
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
