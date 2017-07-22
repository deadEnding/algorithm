package leetcode.L609_FindDuplicateFileInSystem;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] tokens = path.split(" ");
            for (int i = 1; i < tokens.length; i++) {
                int ix = tokens[i].indexOf('(');
                String content = tokens[i].substring(ix + 1, tokens[i].length() - 1);
                String filePath = tokens[0] + "/" + tokens[i].substring(0, ix);
                if (!map.containsKey(content)) {
                    map.put(content, new LinkedList<>());
                }

                map.get(content).add(filePath);
            }
        }

        List<List<String>> result = new LinkedList<>();
        for (String key : map.keySet()) {
            List<String> value = map.get(key);
            if (value.size() > 1) {
                result.add(value);
            }
        }

        return result;
    }
}
