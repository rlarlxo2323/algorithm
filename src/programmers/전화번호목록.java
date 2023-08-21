package programmers;

import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        int length = phone_book.length;

        if (phone_book[0].startsWith(phone_book[1])) {
            return false;
        }

        for (int i=1; i<length-1; i++) {
            if (phone_book[i].startsWith(phone_book[i+1]) || phone_book[i].startsWith(phone_book[i-1])) {
                return false;
            }
        }

        if (phone_book[length-1].startsWith(phone_book[length-2])) {
            return false;
        }

        return answer;
    }

}
