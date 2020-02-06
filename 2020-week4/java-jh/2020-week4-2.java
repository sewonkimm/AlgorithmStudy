import java.util.*;

class Solution {
    static StringBuffer sb = new StringBuffer();

    static String[] seperator(String p) {
        int left = 0;
        int right = 0;
        int i;
        for (i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else if (p.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                break;
            }
        }
        String[] ps = new String[2];
        ps[0] = p.substring(0, i + 1);
        ps[1] = p.substring(i + 1, p.length());
        return ps;
    }

    static boolean isCorrect(String u) {
        Stack<Character> s = new Stack<Character>();
        int index = 0;
        if (u.charAt(index) == '(') {
            s.push(u.charAt(index++));
        } else {
            return false;
        }
        while (index < u.length()) {
            if (u.charAt(index) == '(') {
                s.push(u.charAt(index++));
            } else if (u.charAt(index) == ')') {
                if (s.isEmpty()) {
                    return false;
                } else {
                    s.pop();
                    index++;
                }
            }
        }
        return true;
    }

    static void rec(String p) {
        if (p.equals("")) {
            return;
        }
        String[] uv = seperator(p);
        if (isCorrect(uv[0])) {
            sb.append(uv[0]);
            rec(uv[1]);
        } else {
            sb.append("(");
            rec(uv[1]);
            sb.append(")");
            StringBuffer newU = new StringBuffer();
            for (int i = 1; i < uv[0].length() - 1; i++) {
                if (uv[0].charAt(i) == '(') {
                    sb.append(")");
                } else if (uv[0].charAt(i) == ')') {
                    sb.append("(");
                }
            }
            sb.append(newU.toString());
            return;
        }
    }

    public static String solution(String p) {
        rec(p);
        return sb.toString();
    }
}