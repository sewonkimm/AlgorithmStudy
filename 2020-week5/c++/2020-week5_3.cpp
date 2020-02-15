// BFS랑 DFS랑 헷갈렸다...
// BFS = queue
// DFS = 재귀

#include <iostream>
#include <vector>

using namespace std;

int n;
int map[101][101];
bool visit[101];
bool ans[101][101];

void dfs(int i, int cnt)
{
    for (int j = 0; j < n; j++)
    {
        if (map[i][j] == 1 && !visit[j])
        {
            visit[j] = 1;
            cnt++;
            dfs(j, cnt);
        }
    }
}

int main(int argc, char **argv)
{

    // input
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &map[i][j]);
        }
    }

    // 경로 탐색
    for (int i = 0; i < n; i++)
    {

        fill_n(visit, n, false);
        dfs(i, 0);

        for (int j = 0; j < n; j++)
        {
            if (visit[j])
            {
                ans[i][j] = 1;
            }
        }
    }

    //print
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            printf("%d ", ans[i][j]);
        }
        printf("\n");
    }
    return 0;
}