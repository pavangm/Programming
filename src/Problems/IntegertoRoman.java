
package Problems;
import java.util.*;

public class IntegertoRoman {
        
    static String repeat_chars(Character c, int count)
        {
            String result="";
            for(int i=0;i<count;i++)
                result+=c;
            return result;
        }
    
        public static void main(String[] args) {
        // TODO code application logic here
        int number=1596;
        HashMap<Integer, Character> roman_int_to_ch_map = new HashMap<>();
        roman_int_to_ch_map.put(10,'X');
        roman_int_to_ch_map.put(1,'I');
        roman_int_to_ch_map.put(5,'V');
        roman_int_to_ch_map.put(50,'L');
        roman_int_to_ch_map.put(100,'C');
        roman_int_to_ch_map.put(500,'D');
        roman_int_to_ch_map.put(1000,'M');
        
        
        char[] integer_chs=String.valueOf(number).toCharArray();
        
        String result="";
        
        //MDXCVI
        
        for(int i=integer_chs.length-1,dec=10,mid=5;i>=0;i--,dec*=10,mid*=10){
            int cur_digit=((int)(integer_chs[i]-'0'));
            int cur_value=cur_digit*(dec/10);
            if(cur_value>mid)
            {
                if(cur_value==dec-(dec/10))
                {
                    result="" +roman_int_to_ch_map.get(dec/10) + roman_int_to_ch_map.get(dec)+result;
                }
                else
                    result=""+roman_int_to_ch_map.get(mid) + repeat_chars(roman_int_to_ch_map.get(dec/10), cur_digit%5)+result;
            }
            else if(cur_value==mid)
                result=""+roman_int_to_ch_map.get(mid)+result;
            else
            {
                if(cur_value==mid-1)
                {
                    result=""+roman_int_to_ch_map.get(dec/10)+roman_int_to_ch_map.get(mid)+result;
                }
                else
                    result=""+repeat_chars(roman_int_to_ch_map.get(dec/10),cur_digit)+result;
            }

        }
        
        System.out.println("Result = "+result);
        
    }
}
