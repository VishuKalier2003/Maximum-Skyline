/* There is a city composed of n x n blocks, where each block contains a single building shaped like a vertical square prism... You are given a 0-indexed n x n integer matrix grid where grid[r][c] represents the height of the building located in the block at row r and column c... A city's skyline is the the outer contour formed by all the building when viewing the side of the city from a distance... The skyline from each cardinal direction north, east, south, and west may be different... We are allowed to increase the height of any number of buildings by any amount (the amount can be different per building)... The height of a 0-height building can also be increased... However, increasing the height of a building should not affect the city's skyline from any cardinal direction... Return the maximum total sum that the height of the buildings can be increased by without changing the city's skyline from any cardinal direction...
 * Eg 1: skyline = [3,0,8,4]           new Skyline = [8,4,8,7]          Output = 35
 *                 [2,4,5,7]                         [7,4,7,7]
 *                 [9,2,6,3]                         [9,4,8,7]
 *                 [0,3,1,0]                         [3,3,3,3]
 * Eg 2: skyline = [0,0]               new Skyline = [0,0]              Output = 0
 *                 [0,0]                             [0,0]
 * Eg 3: skyline = [4,3,6]             new Skyline = [5,3,6]            Output = 5
 *                 [5,2,8]                           [5,3,8]
 *                 [3,2,7]                           [5,3,8]
 */
import java.util.*;
public class Skyline
{
    public int MaximumIncreasingSkyline(int grid[][])
    {
        int rows[] = new int[grid.length];     // Storing the maximum of every row...
        int cols[] = new int[grid.length];     // Storing the maximum of every column...
        for(int i = 0; i < rows.length; i++)
        {
            for(int j = 0; j < cols.length; j++)
            {
                rows[i] = Math.max(rows[i], grid[i][j]);    // Getting max of every row...
                cols[i] = Math.max(cols[i], grid[j][i]);    // Getting max of every column...
            }
        }
        int sum = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid.length; j++)
                sum = sum + Math.abs(grid[i][j] - Math.min(rows[i], cols[j]));   // Getting the sum of the increase made in every block on the basis of the minimum of the current row and column of the block...
        }
        return sum;    // Returning the total sum increase of the Skyline...
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the value of n : ");
        n = sc.nextInt();
        int heights[][] = new int[n][n];
        for(int i = 0; i < heights.length; i++)
        {
            for(int j = 0; j < heights.length; j++)
            {
                System.out.print("Enter the height of "+(i+1)+" row and "+(j+1)+" height : ");
                heights[i][j] = sc.nextInt();
            }
        }
        Skyline skyline = new Skyline();    // Object creation...
        System.out.println("The Maximum Increase in skyline : "+skyline.MaximumIncreasingSkyline(heights));
        sc.close();
    }
}

// Time Complexity  - O(n^2) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. Since the skyline can be viewed from four cardinal directions, there are four set of subproblems but the subproblems becomes two as we look carefully that the skyline of North and South are same and the Skyline of East and West is also same...
 * 2. Thus we find the maximum of each row and each column of the Skyline, since the maximum increase can be done by the minimum of the row and column skylines of the current block...
 * 3. Then we can simply iterate over every block and calculate the sum of the increase in the height of the block to make the Skyline unchanged...
*/