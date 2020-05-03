package covid19_1.day1_first_bad_version;

class Solution extends VersionControl {
    public static void main(String[] args) {
        int res = firstBadVersion(2126753390);
        System.out.println(res);
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; // to avoid overflow incase (left+right)>2147483647
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

class VersionControl {
    static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}