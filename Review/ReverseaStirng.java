import java.util.*;
public class ReverseaStirng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        String ans = "";
        for(int i = ch.length - 1; i >= 0; i--) {
            ans += ch[i];  
        }
        System.out.println(ans);
    }
}
