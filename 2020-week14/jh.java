import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
    	int answer = 0;
    	ArrayList<String> cacheList = new ArrayList<String>();
    	
    	for(int i = 0; i < cities.length; i++) {
    		boolean isHit = false;
    		int searchIndex = cacheList.size() <= cacheSize? cacheList.size(): cacheSize;
    		for(int j = 0; j < searchIndex; j++) {
    			if(cacheList.get(j).equalsIgnoreCase(cities[i])) {
    				isHit = true;
    				answer += 1;
    				cacheList.add(0, cacheList.remove(j));
    				break;
    			}
    		}
    		if(!isHit) {
    			answer += 5;
    			cacheList.add(0, cities[i]);
    		}
    	}
    	
        return answer;
    }
}