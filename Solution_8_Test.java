/**
 * 测试类 Solution8Test
 *
 * 测试用例设计原则：
 * - 等价类划分：将输入数据划分为功能上等价的类，如空网格、全水网格、全陆地网格、单个岛屿和多个岛屿等。
 * - 边界值分析：测试输入数据的边界条件，如空数组、最大尺寸的网格、只有一行或一列的网格等。
 * - 特殊情况：测试非正方形网格、岛屿在网格边缘的情况等。
 *
 * 每个测试方法都针对 numIslands 方法的特定方面进行测试，确保全面覆盖。
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class Solution_8_Test {

    /**
     * 测试空网格
     * 目的：验证方法在输入为空或空数组时的行为。
     * 测试用例：
     * - grid = null
     * - grid = new char[0][]
     */
    @Test
    public void testEmptyGrid() {
        Solution8 solution = new Solution8();

        // 测试 null 网格
        assertEquals(0, solution.numIslands(null));

        // 测试空网格
        assertEquals(0, solution.numIslands(new char[0][]));
    }

    /**
     * 测试全水网格
     * 目的：当网格仅包含水时，验证方法的行为。
     * 测试用例：
     * - grid = [['0', '0'], ['0', '0']]
     */
    @Test
    public void testGridWithNoLand() {
        Solution8 solution = new Solution8();

        char[][] grid = {
                {'0', '0'},
                {'0', '0'}
        };

        assertEquals(0, solution.numIslands(grid));
    }

    /**
     * 测试全陆地网格
     * 目的：当网格仅包含陆地时，验证方法的行为。
     * 测试用例：
     * - grid = [['1', '1'], ['1', '1']]
     */
    @Test
    public void testGridWithAllLand() {
        Solution8 solution = new Solution8();

        char[][] grid = {
                {'1', '1'},
                {'1', '1'}
        };

        assertEquals(1, solution.numIslands(grid));
    }

    /**
     * 测试只有一个岛屿的网格
     * 目的：验证方法能正确识别单个岛屿。
     * 测试用例：
     * - 使用题目描述中的示例 1
     */
    @Test
    public void testGridWithOneIsland() {
        Solution8 solution = new Solution8();

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        assertEquals(1, solution.numIslands(grid));
    }

    /**
     * 测试有多个岛屿的网格
     * 目的：验证方法能正确识别多个独立的岛屿。
     * 测试用例：
     * - 使用题目描述中的示例 2
     */
    @Test
    public void testGridWithMultipleIslands() {
        Solution8 solution = new Solution8();

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        assertEquals(3, solution.numIslands(grid));
    }

    /**
     * 测试最大尺寸的网格
     * 目的：在最大网格尺寸下测试方法的性能和正确性。
     * 测试用例：
     * - 尺寸为 300x300 的网格，交替填充 '1' 和 '0'
     */
    @Test
    public void testGridWithMaximumSize() {
        Solution8 solution = new Solution8();

        int m = 300;
        int n = 300;
        char[][] grid = new char[m][n];

        // 以棋盘格模式填充网格
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = ((i + j) % 2 == 0) ? '1' : '0';
            }
        }

        // 因为 '1' 不相邻，所以岛屿数量约为网格单元数的一半
        int expectedIslands = (m * n + 1) / 2;

        assertEquals(expectedIslands, solution.numIslands(grid));
    }

    /**
     * 测试只有一行的网格
     * 目的：验证方法在只有一行的网格中的行为。
     * 测试用例：
     * - grid = [['1','0','1','0','1']]
     */
    @Test
    public void testGridWithOneRow() {
        Solution8 solution = new Solution8();

        char[][] grid = {
                {'1','0','1','0','1'}
        };

        assertEquals(3, solution.numIslands(grid));
    }

    /**
     * 测试只有一列的网格
     * 目的：验证方法在只有一列的网格中的行为。
     * 测试用例：
     * - grid = [['1'], ['0'], ['1'], ['1'], ['0']]
     */
    @Test
    public void testGridWithOneColumn() {
        Solution8 solution = new Solution8();

        char[][] grid = {
                {'1'},
                {'0'},
                {'1'},
                {'1'},
                {'0'}
        };

        assertEquals(2, solution.numIslands(grid));
    }

    /**
     * 测试岛屿在网格边缘的情况
     * 目的：验证岛屿在网格边缘时能被正确计数。
     * 测试用例：
     * - grid = [['1','1','1'], ['1','0','1'], ['1','1','1']]
     */
    @Test
    public void testGridWithIslandsTouchingEdges() {
        Solution8 solution = new Solution8();

        char[][] grid = {
                {'1','1','1'},
                {'1','0','1'},
                {'1','1','1'}
        };

        assertEquals(1, solution.numIslands(grid));
    }

    /**
     * 测试非正方形网格
     * 目的：验证方法在非正方形网格中的行为。
     * 测试用例：
     * - grid = [['1','0'], ['1','0'], ['0','1'], ['1','1']]
     */
    @Test
    public void testGridWithDifferentShapes() {
        Solution8 solution = new Solution8();

        char[][] grid = {
                {'1','0'},
                {'1','0'},
                {'0','1'},
                {'1','1'}
        };

        assertEquals(2, solution.numIslands(grid));
    }
}