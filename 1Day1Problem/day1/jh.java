// 풀이: https://jaehyeonkim19.github.io/codingtest/programmers-lock-and-key/2020-08-24%2009:00:00%20+0900

class Solution {
	private int[][] getRotatedKey(int[][] key, int rotateCount) {
		int m = key.length;
		int[][] rotatedKey = new int[m][m];
		for(int x = 0; x < m; x++) {
			for(int y = 0; y < m; y++) {
				int [] rotatedCoordinate = rotateCoordiante(x, y, rotateCount, m);
				rotatedKey[rotatedCoordinate[0]][rotatedCoordinate[1]] = key[x][y];
			}
		}
		return rotatedKey;
	}
	
	private int[] rotateCoordiante(int x, int y, int rotateCount, int m) {
		int[] coordinate = new int[2];
		if(rotateCount == 0) {
			coordinate[0] = x;
			coordinate[1] = y;
			return coordinate;
		}
		coordinate[0] = y;
		coordinate[1] = - x + m - 1;
		if(rotateCount == 1) {
			return coordinate;
		}
		return rotateCoordiante(coordinate[0], coordinate[1], rotateCount - 1, m);
	}
	
	private boolean isOverlap(int m, int i, int j, int x, int y) {
		return m - 1 - i + x >= 0 
				&& m - 1 - i + x < m
				&& m - 1 - j + y >= 0
				&& m - 1 - j + y < m;
	}
	
	private boolean isCorrect(int[][] rotatedKey, int[][] lock, int i, int j) {
		int m = rotatedKey.length;
    	int n = lock.length;
    	
		for(int x = 0; x < n; x++) {
			for(int y = 0; y < n; y++) {
				if(isOverlap(m, i, j, x, y)) {
					if(lock[x][y] + rotatedKey[m - 1 - i + x][m - 1 - j + y] != 1) {
						return false;
					}
				}else {
					if(lock[x][y] == 0) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	private boolean isCorrectKey(int[][] rotatedKey, int[][] lock) {
		int m = rotatedKey.length;
    	int n = lock.length;
    	
		for(int i = 0; i < m + n - 1; i++) {
			for(int j = 0; j < m + n - 1; j++) {
				if(isCorrect(rotatedKey, lock, i, j)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
    public boolean solution(int[][] key, int[][] lock) {
    	int m = key.length;
    	int n = lock.length;
    	int[][] rotatedKey;
    	
    	for(int rotateCount = 0; rotateCount < 4; rotateCount++) {
    		rotatedKey = getRotatedKey(key, rotateCount);
    		if (isCorrectKey(rotatedKey, lock)) {
    			return true;
    		}
    	}
    	
        return false;
    }
}