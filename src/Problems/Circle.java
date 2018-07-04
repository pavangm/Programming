
package Problems;

import java.util.Arrays;
import java.util.Scanner;


public class Circle {

    /**
     * @param args the command line arguments
     */
    
    static void update_map(int radius, char[][]map, double increment, int center_x, int center_y){
        for(double i=0; i<=6.2; i+=increment)
        {
            int x = center_x + (int)Math.round(radius * Math.cos(i));
            int y = center_y + (int)Math.round(radius * Math.sin(i));
            map[(int)Math.round(x*1.0/2)][y]='*';
        }
    }
    
    static void DrawCircle(int[] radii, int radius){
        int center_x = radius;
        int center_y = radius;
        
        double pi2 = 6.2;
        double increment = 0.1;
        int size = (int)(radius*2) + 1;
        
        char map[][]=new char[size][size];
        for(int s=0;s<size;s++)
            Arrays.fill(map[s], ' ');
        
        for(int j=0;j<radii.length;j++)
        update_map(radii[j], map, increment, center_x, center_y);
        
        for(int i=0;i<size/2+1;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter number of circles :");
        int circles = scan.nextInt();
        int[] radii = new int[circles];
        int max_radius = -1;
        for(int i=0;i<circles; i++)
        {
            System.out.print("Enter radius of Circle " + (i+1) + ":");
            radii[i] = scan.nextInt();
            if(radii[i]>max_radius)
                max_radius=radii[i];
        }
        
        DrawCircle(radii, max_radius);
        
    }
    
}
