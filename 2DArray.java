import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] hd = {
            {-1,-1}, {-1,0}, {-1,1},
            {1,-1}, {1,0}, {1,1}
        };
        int max = -64;
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                int sum = arr[i][j];
                boolean isH = true;
                for(int k=0;k<6;k++){
                    int x = i + hd[k][0];
                    int y = j + hd[k][1];
                    if(x > -1 && x < 6 && y > -1 && y < 6){
                        sum += arr[x][y];                        
                    }else{
                        isH = false;
                        break;
                    }
                }             
                if(isH && sum > max){
                    max = sum;                    
                }                      
            }
            System.out.println("");
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
