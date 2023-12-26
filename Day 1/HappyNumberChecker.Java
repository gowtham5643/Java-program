package placement_training;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Scanner;
public class HappyNumberChecker {

    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        num = sc.nextInt();
        System.out.println(function(num));
    }
    static boolean function(int num){ 
        if(num<10){
            if(num==1 || num==7) return true;
            return false;
        }
        int a = num;
        int sum=0;
        while(a>0){
            int b=a%10;
            sum+=(b*b);
            a/=10;
        }
        return function(sum);
    }
    
}
