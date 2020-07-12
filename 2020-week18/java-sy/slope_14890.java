import java.util.Scanner;

public class slope_14890 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		
		// 青
		for(int i=0; i<n; i++) {
			int cur;
			int index = 0;
			boolean result = true;
			while(index<n-1) {
				cur = map[i][index];
				
				int next = map[i][index+1];
				
				if(cur == next) {
					index+=1;
					continue;
				}
				
				// 2 3 老 锭
				else if(next-cur == 1) {
					int preIndex = index-1;
					int count = 1;
					while(preIndex>=0) {
						int pre = map[i][preIndex];
						
						if(pre == cur) {
							preIndex-=1;
							count+=1;
							continue;
						}else {
							break;
						}
					}
					
					if(count>=l) {
						index +=1;
						continue;
					} else {
						result = false;
						break;
					}
				}
				
				// 3 2 老 锭
				else if(next-cur == -1) {
					int nextIndex = index+2;
					int count = 1;
					while(nextIndex<n) {
						int nextNext = map[i][nextIndex];
						
						if(nextNext == next) {
							nextIndex+=1;
							count+=1;
							continue;
						}else {
							break;
						}
					}
					
					if(nextIndex>=n) {
						if(count < l) {
							result = false;
						}
						break;
					}
					
					if(map[i][nextIndex] > next) {
						if(map[i][nextIndex]-next == 1 && count >= 2*l) {
							index = nextIndex;
							continue;
						}else {
							result = false;
							break;
						}
					} else {
						if(count >= l) {
							index = nextIndex-1;;
							continue;
						}
						else {
							result = false;
							break;
						}
					}
				} else {
					result = false;
					break;
				}
			}
			if(result) {
				answer += 1;
			}
		}
		
		// 凯
		for(int i=0; i<n; i++) {
			int cur;
			int index = 0;
			boolean result = true;
			while(index<n-1) {
				cur = map[index][i];
				
				int next = map[index+1][i];
				
				if(cur == next) {
					index+=1;
					continue;
				}
				
				// 2 3 老 锭
				else if(next-cur == 1) {
					int preIndex = index-1;
					int count = 1;
					while(preIndex>=0) {
						int pre = map[preIndex][i];
						
						if(pre == cur) {
							preIndex-=1;
							count+=1;
							continue;
						}else {
							break;
						}
					}
					
					if(count>=l) {
						index +=1;
						continue;
					} else {
						result = false;
						break;
					}
				}
				
				// 3 2 老 锭
				else if(next-cur == -1) {
					int nextIndex = index+2;
					int count = 1;
					while(nextIndex<n) {
						int nextNext = map[nextIndex][i];
						
						if(nextNext == next) {
							nextIndex+=1;
							count+=1;
							continue;
						}else {
							break;
						}
					}
					
					if(nextIndex>=n) {
						if(count < l) {
							result = false;
						}
						break;
					}
					
					if(map[nextIndex][i] > next) {
						if(map[nextIndex][i]-next == 1 && count >= 2*l) {
							index = nextIndex;
							continue;
						}else {
							result = false;
							break;
						}
					} else {
						if(count >= l) {
							index = nextIndex-1;;
							continue;
						}
						else {
							result = false;
							break;
						}
					}
				} else {
					result = false;
					break;
				}
			}
			
			if(result) {
				answer += 1;
			}
		}
		
		System.out.println(answer);
	}
}
