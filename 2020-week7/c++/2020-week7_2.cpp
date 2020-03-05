#include <iostream>
#include <queue>

using namespace std;

int map[7][7];
int visit[7][7];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

bool dfs(int x, int y, int num)
{
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));

    int cnt = 0;
    while (!q.empty())
    {
        int nowx = q.front().first;
        int nowy = q.front().second;
        q.pop();
        visit[nowx][nowy] = 1;
        cnt++;

        for (int k = 0; k < 4; k++)
        {
            int nx = nowx + dx[k];
            int ny = nowy + dy[k];

            if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7)
            {
                if (map[nx][ny] == num && visit[nx][ny] == 0)
                {
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }

    if (cnt >= 3)
        return 1;
    else
        return 0;
}

int main(int argc, char **argv)
{

    for (int i = 0; i < 7; i++)
    {
        for (int j = 0; j < 7; j++)
        {
            scanf("%d", &map[i][j]);
        }
    }

    int ans = 0;
    for (int i = 0; i < 7; i++)
    {
        for (int j = 0; j < 7; j++)
        {
            if (!visit[i][j])
            {
                if (dfs(i, j, map[i][j]))
                {
                    ans++;
                }
            }
        }
    }

    printf("%d\n", ans);

    return 0;
}