import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(9,13)));
    }
     public static int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            String result = String.valueOf(i);
            int a = result.charAt(0);
            int b = result.charAt(result.length()-1);
            if (a==b){
                list.add(i);
            }
        }
        int [] arr = new int[list.size()];
         for (int i = 0; i < arr.length; i++) {
             arr[i]=list.get(i);
         }
        return arr;
    }
}