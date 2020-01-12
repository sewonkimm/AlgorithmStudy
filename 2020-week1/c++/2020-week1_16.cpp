#include <iostream>
#include <queue>
#include <stdlib.h>

using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	
	priority_queue< pair<int, int>, vector< pair<int, int> >, greater< pair<int, int> > > pq;
	for(int i=0; i<n; i++){
		int x;
		scanf("%d", &x);
		
		if(x != 0){
			pq.push(make_pair(abs(x), x));
		}
		else{
			if(pq.empty()){
				printf("0\n");
			}		
			else{
				printf("%d\n", pq.top().second);
				pq.pop();
			}
		}
	}
	return 0;
}