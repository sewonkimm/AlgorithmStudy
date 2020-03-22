#include <iostream>
#include <tuple>
#include <queue> 

using namespace std;

int map[51][51];
int visit[51][51];

int answer = 0;

// 0 : ↑ [0] (0, -1) [3] (1, 0)
// 1 : → [1] (-1, 0) [0] (0, -1)
// 2 : ↓ [2] (0, 1)  [1] (-1, 0)
// 3 : ← [3] (1, 0)  [2] (0, 1)

// 0 > 3 > 2 > 1

int dx[4] = { 0, -1, 0, 1 };
int dy[4] = { -1, 0, 1, 0 };

bool canGo(int x, int y){
	
	for(int i=0; i<4; i++){
		int nx = x+dx[i];
		int ny = y+dy[i];
		
		if(!visit[nx][ny] && !map[nx][ny]){
			return true;
		}
	}
	
	return false;
}

bool isWall(int x, int y, int d){
	int bd = d-1;
	if(bd == -1){
		bd = 3;
	}
	
	int bx = x + dx[bd];
	int by = y + dy[bd];
	if(map[bx][by]){
		return true;
	}
	
	return false;
}

int main(int argc, char **argv){
	
	// input
	int n, m;
	int r, c, d;
	scanf("%d %d", &n, &m);
	scanf("%d %d %d", &r, &c, &d);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			scanf("%d", &map[i][j]);
		}
	}
	
	// clean start
	queue< tuple<int, int, int> > q;
	q.push(make_tuple(r, c, d));
	
	while(!q.empty()){
		int x = get<0>(q.front());
		int y = get<1>(q.front());
		int direction = get<2>(q.front());
		q.pop();
		
		if(!visit[x][y]){
			visit[x][y] = 1;
			answer++;
		}
		
		// 네 방향 모두 청소가 이미 되어있거나 벽인가? 
		if(!canGo(x, y)){
			// 뒤쪽 방향이 벽인가?
			if(isWall(x, y, direction)){
				printf("%d\n", answer);
				return 0;
			} 
			else {
				// 바라보는 방향을 유지한 채로 한 칸 후진
				int bd = direction-1;
				if(bd == -1){
					bd = 3;
				}
				
				int bx = x + dx[bd];
				int by = y + dy[bd];
	
				q.push(make_tuple(bx, by, direction));
			}
		} 
		else {
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			direction -= 1;
			if(direction == -1){
				direction = 3;
			}

			// 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 
			// 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
			if(!visit[nx][ny] && !map[nx][ny]){
				q.push(make_tuple(nx, ny, direction));
			}
			
			// 왼쪽 방향에 청소할 공간이 없다면, 
			// 그 방향으로 회전하고 2번으로 돌아간다
			else {
				q.push(make_tuple(x, y, direction));
			}

		} 
	}
	
	return 0;
}