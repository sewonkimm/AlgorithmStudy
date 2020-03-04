// 백트래킹으로 구현
// 시간초과

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int map[11][11];
int ans;

void candy(int x, int y, int n, vector<int> visit, int sum)
{

    if (y == n)
    {

        ans = max(ans, sum);
        return;
    }

    for (int i = 0; i < n; i++)
    {
        if (!visit[i])
        {

            visit[i] = 1;
            candy(i, y + 1, n, visit, sum + map[y][i]);
            visit[i] = 0;
            candy(i, y + 1, n, visit, sum);
        }
    }
}

int main(int argc, char **argv)
{

    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &map[i][j]);
        }
    }

    for (int i = 0; i < n; i++)
    {
        vector<int> visit(n, 0);
        visit[i] = 1;
        int sum = map[0][i];
        candy(i, 1, n, visit, sum);
    }
    printf("%d\n", ans);

    return 0;
}