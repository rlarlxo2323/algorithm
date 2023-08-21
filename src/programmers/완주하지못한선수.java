package programmers;

import java.util.*;
public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String part : participant) {
            if (map.containsKey(part)) {
                map.put(part, map.get(part)+1);
            } else {
                map.put(part, 1);
            }
        }

        for (String com : completion) {
            if (map.get(com) == 1) {
                map.remove(com);
            } else {
                map.put(com, map.get(com)-1);
            }
        }

        for (String key : map.keySet()) {
            answer = key;
        }

        return answer;
    }
}
