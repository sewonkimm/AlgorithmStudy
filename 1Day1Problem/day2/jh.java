class Solution {
	private boolean[][] isColumn;
	private boolean[][] isBeam;
	private int column = 0;
	private int beam = 1;
	
	private int[] getStructureInfoArray(int x, int y, int structure) {
		int[] buildFrame = {x, y, structure};
		return buildFrame;
	}
	
	private boolean canRemove(int[] currentBuildFrame) {
		removeBuildFrame(currentBuildFrame);
		
		for(int i = 0; i < isColumn.length; i++) {
			for(int j = 0; j < isColumn[0].length; j++) {
				if(isColumn[i][j]) {
					if(!isValid(getStructureInfoArray(i, j, column))) {
						installBuildFrame(currentBuildFrame);
						return false;
					}
				}
			}
		}
		
		for(int i = 0; i < isBeam.length; i++) {
			for(int j = 0; j < isBeam[0].length; j++) {
				if(isBeam[i][j]) {
					if(!isValid(getStructureInfoArray(i, j, beam))) {
						installBuildFrame(currentBuildFrame);
						return false;
					}
				}
			}
		}
		
		installBuildFrame(currentBuildFrame);
		return true;
	}
	
	private boolean isValid(int[] currentBuildFrame) {
		if(isColumn(currentBuildFrame)) {
			if(currentBuildFrame[1] == 0) {
				return true;
			}
			if(isBeam[currentBuildFrame[0]][currentBuildFrame[1]] || (currentBuildFrame[0] - 1 >= 0 && isBeam[currentBuildFrame[0] - 1][currentBuildFrame[1]])) {
				return true;
			}
			if(isColumn[currentBuildFrame[0]][currentBuildFrame[1] - 1]) {
				return true;
			}
			return false;
		}
		if(isColumn[currentBuildFrame[0]][currentBuildFrame[1] - 1] || isColumn[currentBuildFrame[0] + 1][currentBuildFrame[1] - 1]) {
			return true;
		}
		if(currentBuildFrame[0] - 1 >= 0 && isBeam[currentBuildFrame[0] - 1][currentBuildFrame[1]] && isBeam[currentBuildFrame[0] + 1][currentBuildFrame[1]]) {
			return true;
		}
		return false;
	}
	
	private boolean isInstallationCommand(int[] currentBuildFrame) {
		return currentBuildFrame[3] == 1;
	}
	
	private void installBuildFrame(int[] currentBuildFrame) {
		if(isColumn(currentBuildFrame)) {
			isColumn[currentBuildFrame[0]][currentBuildFrame[1]] = true;
			return;
		}
		isBeam[currentBuildFrame[0]][currentBuildFrame[1]] = true;
	}
	
	private void removeBuildFrame(int[] currentBuildFrame) {
		if(isColumn(currentBuildFrame)) {
			isColumn[currentBuildFrame[0]][currentBuildFrame[1]] = false;
			return;
		}
		isBeam[currentBuildFrame[0]][currentBuildFrame[1]] = false;
	}
	
	private boolean isColumn(int[] currentBuildFrame) {
		return currentBuildFrame[2] == column;
	}
	
    public int[][] solution(int n, int[][] build_frame) {
    	isColumn = new boolean[n + 1][n + 1];
    	isBeam = new boolean[n + 1][n + 1];
    	int structureCount = 0;
    	
    	for(int i = 0; i < build_frame.length; i++) {
    		int[] currentBuildFrame = build_frame[i];
    		if(isInstallationCommand(currentBuildFrame)) {
    			if(isValid(currentBuildFrame)) {
    				installBuildFrame(currentBuildFrame);
    				structureCount++;
    				continue;
    			}
    			continue;
    		}
    		if(canRemove(currentBuildFrame)) {
    			removeBuildFrame(currentBuildFrame);
    			structureCount--;
    			continue;
    		}
    	}
    	
    	int[][] currentStructureArray = new int[structureCount][3];
    	int currentStructureArrayIndex = 0;
    	
    	for(int i = 0; i < isBeam.length; i++) {
    		for(int j = 0; j < isBeam[0].length; j++) {
    			if(isColumn[i][j]) {
    				currentStructureArray[currentStructureArrayIndex++] = getStructureInfoArray(i, j, column);
    			}
    			if(isBeam[i][j]) {
    				currentStructureArray[currentStructureArrayIndex++] = getStructureInfoArray(i, j, beam);
    			}
    		}
    	}
        
        return currentStructureArray;
    }
}
