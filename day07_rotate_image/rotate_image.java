int[][] rotateImage(int[][] m) {
    int a,b,c,d; // O(4) additional memory which equals to O(1)
    for(int i = 0; i < m.length / 2; i++) {
        for(int j = i; j < m.length - 1 - i; j++) {
            // Get the need-to-swap items at 4 side
            a = m[i][j];
            b = m[j][m.length - 1 - i];
            c = m[m.length - 1 - i][m.length - 1 - j];
            d = m[m.length - 1 - j][i];
            
            // Assign new place
            m[i][j] = d; // d -> a
            m[j][m.length - 1 - i] = a; // a -> b
            m[m.length - 1 - i][m.length - 1 - j] = b; // b -> c
            m[m.length - 1 - j][i] = c; // c -> d
        }
    }
    
    return m;
}