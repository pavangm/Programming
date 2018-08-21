/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Pavan
 */
public class SortEvenAscSortOddDesc {

    /**
     * @param args the command line arguments
     */
    
    //All indexes after the returned value are odd.
    static int separate_odd_even(int a[])
    {
        int i=-1, j=a.length;
        while(j-i>1){
            while(i+1<a.length && a[i+1]%2==0)
                i++;
            while(j-1>=0 && Math.abs(a[j-1])%2==1)
                j--;
            
            //swap
            if(i+1<j-1 && i+1<a.length && j-1>=0)
            {
                int temp=a[i+1];
                a[i+1]=a[j-1];
                a[j-1]=temp;
                i++;j--;
            }
        }
        return i;
    }
    
    static int separate_odd_even(Integer a[])
    {
        int i=-1, j=a.length;
        while(j-i>1){
            while(i+1<a.length && a[i+1]%2==0)
                i++;
            while(j-1>=0 && Math.abs(a[j-1])%2==1)
                j--;
            
            //swap
            if(i+1<j-1 && i+1<a.length && j-1>=0)
            {
                int temp=a[i+1];
                a[i+1]=a[j-1];
                a[j-1]=temp;
                i++;j--;
            }
        }
        return i;
    }
    
    static void print_array(int a[])
    {
        for(int c:a)
            System.out.print(c + " ");
        System.out.println();
    }
    
    static void print_array(Integer a[])
    {
        for(int c:a)
            System.out.print(c + " ");
        System.out.println();
    }
    
    static void reverse(int a[], int start_index, int end_index)
    {
        int i=start_index, j=end_index;
        
        while(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;j--;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Integer a[] = {-25,-56,-10,12,-5,17,6,12,52,67,-1,-6};
        print_array(a);
        int last_even_index = separate_odd_even(a);
        print_array(a);
        Arrays.sort(a, 0, last_even_index+1);
        print_array(a);
        Arrays.sort(a,last_even_index+1, a.length, Collections.reverseOrder());
        print_array(a);
    }
    
}
