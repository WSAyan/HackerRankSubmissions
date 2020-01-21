import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String,Integer> subsMap = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
           for(int j = i+1; j<=s.length(); j++){
               String subs = s.substring(i, j);
               if(!subs.isEmpty() && subs.length() < s.length()){
                    char[] x = subs.toCharArray();
                    Arrays.sort(x);
                    String sSubs = new String(x);
                    if(subsMap.get(sSubs) != null){
                        subsMap.put(sSubs, subsMap.get(sSubs) + 1);
                    }else{
                        subsMap.put(sSubs, 1);
                    }
               }               
           } 
        }

        int total = 0;
        for (Map.Entry<String, Integer> entry : subsMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            total += ((value * (value - 1)) / 2);
        }

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
