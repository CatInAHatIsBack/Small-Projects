import java.util.Map;
import java.util.HashMap;

class Two_Sums{
    static int[] solution(int[] input, int target){
        Map<Integer,Integer> storedValues = new HashMap<Integer,Integer>();
        for (int i = 0; i < input.length; i++) {
            int current = input[i];
            int val = target - input[i]; 
            if(storedValues.containsKey(current)){
                int[] temp = {storedValues.get(current), i};
                return temp;
            }
            storedValues.put(val,i);
        }
        return null;
    }
    public static void main(String[] args) {
        int[] in = {3,3};
        int[] out = solution(in, 6);
        for (int i: out) {
            System.out.print("val" + i);
        }
        
    }
}