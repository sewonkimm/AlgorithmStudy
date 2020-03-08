#include <iostream>
#include <algorithm>

using namespace std;

int d[60];
int num[6] = { 10, -10, 5, -5, 1, -1 };

void go(int a, int b, int cnt){
	
	if(a == b){
		d[b] = min(d[b], cnt);
		return;
	}
	
	for(int i=0; i<6; i++){
		int x = a + num[i];
		if(x >= 0 && x <= 60){
			if(d[x] == 1000){
				d[x] = cnt+1;
				go(x, b, cnt+1);
			}
			else if(d[x] > cnt+1) {
				d[x] = cnt+1;
				go(x, b, cnt+1);
			}
			
		}
	}
}

int main(int argc, char **argv)
{
	int a, b;
	scanf("%d %d", &a, &b);
	
	fill_n(d, 60, 1000);
	
	go(a, b, 0);
	printf("%d\n", d[b]);
	
    return 0;
}