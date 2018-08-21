/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

import java.util.*;
import javafx.util.Pair;

/**
 *
 * @author Pavan
 */
class Node implements Comparable<Node>
{
    int sum;
    int a_index;
    int b_index;

    public Node(int sum, int i, int j)
    {
        this.sum=sum;
        this.a_index=i;
        this.b_index=j;
    }
    
    @Override
    public int compareTo(Node t) {
        return this.sum-t.sum;
    }
}

public class NthiteminSumofTwoArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //(1+6), (1+7), (2+6), (1+8), (2+7), (3+6)...
        
        int a[] = {1,2,3,4,5};
        int b[] = {6,7,8};
        
        int n=7;
        
        PriorityQueue<Node> min_heap = new PriorityQueue<>();
        HashSet<Pair<Integer,Integer>> seen_index_pairs = new HashSet<>();
        min_heap.add(new Node(a[0]+b[0], 0, 0));
        
        int i=0;
        seen_index_pairs.add(new Pair<>(0,0));
        Node cur_node = null;
        while(i<n)
        {
            cur_node = min_heap.poll();
            
            Pair p1 = new Pair(cur_node.a_index, cur_node.b_index+1);
            if(!seen_index_pairs.contains(p1) && cur_node.b_index+1<b.length)
            {
                seen_index_pairs.add(p1);
                min_heap.add(new Node(a[cur_node.a_index] + b[cur_node.b_index+1], cur_node.a_index, cur_node.b_index+1));
            }
            
            Pair p2 = new Pair(cur_node.a_index +1 , cur_node.b_index);
            if(!seen_index_pairs.contains(p2) && cur_node.a_index+1 <a.length)
            {
                seen_index_pairs.add(p2);
                min_heap.add(new Node(a[cur_node.a_index +1] + b[cur_node.b_index], cur_node.a_index+1, cur_node.b_index));
            }
            
            i++;
        }
        
        System.out.println("The nth item is " + cur_node.sum);
    }
    
}
