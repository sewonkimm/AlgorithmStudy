import java.util.*;

class Solution {
    public int[] solution(String msg) {
    	ArrayList<Integer> answers = new ArrayList<Integer>();
    	HashMap<String, Integer> dic = new HashMap<String, Integer>();
    	int index = 27;
    	for(int i = 65; i <= 90; i++) {
    		dic.put(Character.toString((char)i), i - 64);
    	}
    	
    	String[] msgs = msg.split("");
    	for(int i = 0; i < msgs.length; i++) {
    		String temp = "";
    		int tempIndex = 0;
    		for(int j = i; j < msgs.length; j++) {
    			temp += msgs[j];
    			if(dic.containsKey(temp)) {
    				if(j == msgs.length - 1) {
    					answers.add(dic.get(temp));
    					i = j;
    					break;
    				}
    				tempIndex = dic.get(temp);
    				continue;
    			}
    			dic.put(temp, index++);
    			answers.add(tempIndex);
    			i = j - 1;
    			break;
    		}
    	}
    	
        int[] answer = new int[answers.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = answers.get(i);
        }
        return answer;
    }
}