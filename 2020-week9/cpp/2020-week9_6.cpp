#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
int nums[10001];

void go(int num, int index, vector<int> answer)
{
	answer[index] = num;

	// print
	if (index == m - 1)
	{
		for (int i = 0; i < m; i++)
		{
			printf("%d ", answer[i]);
		}
		printf("\n");
		return;
	}

	for (int i = num; i < 10001; i++)
	{
		if (nums[i])
		{
			go(i, index + 1, answer);
		}
	}
}

int main()
{

	scanf("%d %d", &n, &m);

	while (n--)
	{
		int x;
		scanf("%d", &x);
		nums[x] = 1;
	}

	vector<int> answer(m);
	for (int i = 1; i < 10001; i++)
	{
		if (nums[i])
		{
			go(i, 0, answer);
		}
	}

	return 0;
}