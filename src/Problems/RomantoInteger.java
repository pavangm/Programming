
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
        int n=roman_chs.length;
        int result=roman_ch_to_int_map.get(roman_chs[n-1]);
        int prev=result;
        for(int i=n-2;i>=0;i--)
        {
            int cur = roman_ch_to_int_map.get(roman_chs[i]);
            if(cur<prev)
                result-=cur;
            else
                result+=cur;
            prev=cur;
        }
        
        System.out.println("Result = "+result);
        
    }
}
