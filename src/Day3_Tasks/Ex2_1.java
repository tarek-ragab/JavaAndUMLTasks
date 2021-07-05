package Day3_Tasks;

import java.util.function.BiPredicate;

public class Ex2_1 {
    public static void main(String[] args) {
        System.out.println(betterString("Ahmed", "Ali", (s1, s2) -> s1.length()>s2.length()));
        System.out.println(betterString("omar", "Tarek", (s1, s2) -> s1.length()>s2.length()));
    }

    public static String betterString(String s1 , String s2 , BiPredicate<String,String> p){
        return p.test(s1,s2) ? s1 : s2 ;
    }
}
