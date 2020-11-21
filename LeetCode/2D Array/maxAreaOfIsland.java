public class maxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        int area = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, findArea(grid, i, j));
                }
            }
        }
        return area;
    }

    private static int findArea(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        //set the current value to 0 to not repeat
        grid[i][j] = 0;

        //search up down left and right
        return 1 + findArea(grid, i, j - 1) + findArea(grid, i, j + 1) + findArea(grid, i + 1, j) + findArea(grid, i - 1, j);

        //-------------------------------//
//                  Another way
//        int area = 1;
//        //set the current value to 0 to not repeat
//        grid[i][j] = 0;
//
//        area += findArea(grid, i, j - 1);
//        area += findArea(grid, i, j + 1);
//        area += findArea(grid, i + 1, j);
//        area += findArea(grid, i - 1, j);
//        return area;
    }

    public static void main(String[] args) {
        int[][] island = {{1, 1, 1, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(maxAreaOfIsland(island));
    }
}
