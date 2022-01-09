package netflix;

import java.util.*;

public class GroupSimilarTitles {

    public static List<List<String>> groupTitles(String[] titleList){
        if(titleList.length == 0){
            return new ArrayList<List<String>>();
        }

        Map<String, List<String>> results = new HashMap<String, List<String>>();

        int[] charCount = new int[26];
        for(String title : titleList){
            Arrays.fill(charCount, 0);
            for(char character : title.toCharArray()){
                int idx = character - 'a';
                charCount[idx]++;
            }

            StringBuilder delimitedString = new StringBuilder("");
            for(int x = 0; x < 26; x++){
                delimitedString.append('#');
                delimitedString.append(charCount[x]);
            }

            String key = delimitedString.toString();
            if(!results.containsKey(key)){
                results.put(key, new ArrayList<String>());
            }
            results.get(key).add(title);
        }

        return new ArrayList<List<String>>(results.values());
    }


    public static void main(String args[]){
        String titles[] = {"duel", "dule", "speed", "spede", "deul", "cars"};

        List<List<String>> groupedTitles = groupTitles(titles);
        System.out.println(groupedTitles);
        String query = "cars";

        for(List<String> group : groupedTitles){
            if(group.contains(query))
                System.out.println(group);
        }
    }

}
