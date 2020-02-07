import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1)
            return 1;
        for (int i = 1; i <= s.length() / 2; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            String pat = "";
            int index;
            for (index = 0; index <= s.length() - i;) {
                if (count == 0) {
                    pat = s.substring(index, index + i);
                    index += i;
                    count++;
                } else {
                    if (s.substring(index, index + i).equals(pat)) {
                        index += i;
                        count++;
                    } else {
                        if (count == 1) {
                            sb.append(pat);
                            pat = s.substring(index, index + i);
                            count = 1;
                            index += i;
                        } else {
                            sb.append(count + pat);
                            pat = s.substring(index, index + i);
                            count = 1;
                            index += i;
                        }
                    }
                }
            }
            if (count > 1) {
                sb.append(count + pat);
            } else {
                sb.append(pat);
            }
            sb.append(s.substring(index, s.length()));
            if (sb.length() < answer)
                answer = sb.length();
        }
        return answer;
    }
}