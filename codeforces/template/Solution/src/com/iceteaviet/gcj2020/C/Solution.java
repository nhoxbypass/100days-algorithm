package com.iceteaviet.gcj2020.C;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();

        for (int t = 0; t < numberOfTest; t++) {
            // Input
            int N = sc.nextInt(); // the number of activities to assign

            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                activities.add(new Activity(i, sc.nextInt(), sc.nextInt()));
            }

            solve(activities, N, t + 1);
        }

        /*int N = 2;
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 360, 480));
        activities.add(new Activity(2, 420, 540));
        activities.add(new Activity(3, 600, 660));
        activities.add(new Activity(1, 0, 1440));
        activities.add(new Activity(2, 1, 3));
        activities.add(new Activity(3, 2, 4));
        activities.add(new Activity(1, 99, 150));
        activities.add(new Activity(2, 1, 100));
        activities.add(new Activity(3, 100, 301));
        activities.add(new Activity(4, 2, 5));
        activities.add(new Activity(5, 150, 250));
        activities.add(new Activity(1, 0, 720));
        activities.add(new Activity(2, 720, 1440));
        solve(activities, N, 0);*/
    }

    private static void solve(List<Activity> activities, int N, int testLevel) {
        Collections.sort(activities);

        Activity lastC = null, lastJ = null;
        boolean success = true;
        for (int i = 0; i < N; i++) {
            Activity act = activities.get(i);
            if (lastC == null) {
                act.assignTo("C");
                lastC = act;
                continue;
            }

            if (lastJ == null) {
                act.assignTo("J");
                lastJ = act;
                continue;
            }

            if (lastC.canWorkWith(act)) {
                act.assignTo("C");
                lastC = act;
                continue;
            }

            if (lastJ.canWorkWith(act)) {
                act.assignTo("J");
                lastJ = act;
                continue;
            }

            success = false;
            break;
        }

        if (success) {
            System.out.println("Case #" + testLevel + ": " + generateResultString(activities));
        } else {
            System.out.println("Case #" + testLevel + ": IMPOSSIBLE");
        }
    }

    private static String generateResultString(List<Activity> activities) {
        activities.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return Integer.compare(o1.inputPos, o2.inputPos);
            }
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < activities.size(); i++) {
            result.append(activities.get(i).belongTo);
        }
        return result.toString();
    }

    static class Activity implements Comparable<Activity> {
        int inputPos;
        int start;
        int end;
        String belongTo = "";

        public Activity(int inputPos, int start, int end) {
            this.inputPos = inputPos;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(start, o.start);
        }

        public boolean canWorkWith(Activity act) {
            return end <= act.start;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public void assignTo(String name) {
            belongTo = name;
        }
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
