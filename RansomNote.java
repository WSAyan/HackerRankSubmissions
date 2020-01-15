import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> ransMap = new HashMap<>();
        HashMap<String, Integer> magMap = new HashMap<>();

        for(String word: note){
            updateMap(ransMap, word);            
        }

        for(String word: magazine){
            if(ransMap.get(word) != null){
                updateMap(magMap, word);    
            }
        }

        System.out.println(detectRansomNote(ransMap, magMap));                
    }

    private static String detectRansomNote(HashMap<String, Integer> ransMap, HashMap<String, Integer> magMap){
        for (Map.Entry<String, Integer> entry : ransMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(magMap.get(key) == null){
                return "No";
            }

            if(magMap.get(key) < value){
                return "No";
            }
        }

        return "Yes";
    }

    private static HashMap<String,Integer> updateMap(HashMap<String,Integer> map, String word){
        if(map.get(word) != null){
            map.put(word, map.get(word) + 1);    
        }else{
            map.put(word, 1);
        }
        return map;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
