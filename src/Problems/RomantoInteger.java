
package Problems;
import java.util.*;

public class RomantoInteger {
    
        public static void main(String[] args) {
        // TODO code application logic here
        String roman="CMIC";
        HashMap<Character, Integer> roman_ch_to_int_map = new HashMap<>();
        roman_ch_to_int_map.put('X',10);
        roman_ch_to_int_map.put('I', 1);
        roman_ch_to_int_map.put('V', 5);
        roman_ch_to_int_map.put('L',50);
        roman_ch_to_int_map.put('C', 100);
        roman_ch_to_int_map.put('D', 500);
        roman_ch_to_int_map.put('M', 1000);
        
        char[] roman_chs=roman.toCharArray();
        
        int result=0;
        int prev=Integer.MAX_VALUE,cur=-1;
        //CMIC
        for(int i=0;i<roman_chs.length;i++){
            cur=roman_ch_to_int_map.get(roman_chs[i]);
            if(cur>prev)
                result-=(prev*2);
            
            result+=cur;
            prev=cur;
        }
        
        System.out.println("Result = "+result);
        
    }
}
