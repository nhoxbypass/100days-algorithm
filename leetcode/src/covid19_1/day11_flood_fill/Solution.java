package covid19_1.day11_flood_fill;

class Solution {
    public static void main(String[] args) {
        int[][] res = floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1);
        System.out.println(res);
    }

    public static int[][] floodFill(int[][] image, int row, int col, int newColor) {
        if (image == null || image.length == 0 || image[row][col] == newColor)
            return image;

        travel(image, row, col, newColor, image[row][col]);

        return image;
    }

    /**
     * DFS
     */
    public static int[][] travel(int[][] image, int row, int col, int newColor, int targetColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length)
            return image;

        // Take the color to compare
        int oldColor = image[row][col];

        if (oldColor != targetColor) {
            return image;
        }

        // Fill color
        image[row][col] = newColor;

        travel(image, row + 1, col, newColor, targetColor);
        travel(image, row - 1, col, newColor, targetColor);
        travel(image, row, col + 1, newColor, targetColor);
        travel(image, row, col - 1, newColor, targetColor);

        return image;
    }
}