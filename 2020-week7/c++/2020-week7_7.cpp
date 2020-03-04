#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n;
int map[26][26];
int visit[26][26];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int dfs(int x, int y)
{
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    visit[x][y] = 1;

    int cnt = 0;
    while (!q.empty())
    {

        int nowx = q.front().first;
        int nowy = q.front().second;
        q.pop();
        cnt++;

        for (int i = 0; i < 4; i++)
        {
            int nextx = nowx + dx[i];
            int nexty = nowy + dy[i];

            if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < n)
            {
                if (visit[nextx][nexty] == 0 && map[nextx][nexty] == 1)
                {
                    q.push(make_pair(nextx, nexty));
                    visit[nextx][nexty] = 1;
                }
            }
        }
    }

    return cnt;
}

int main(int argc, char **argv)
{

    scanf("%d", &n);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%1d", &map[i][j]);
        }
    }

    vector<int> ans;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (map[i][j] == 1 && visit[i][j] == 0)
            {
                ans.push_back(dfs(i, j));
            }
        }
    }

    sort(ans.begin(), ans.end());
    printf("%d\n", ans.size());
    for (int i = 0; i < ans.size(); i++)
    {
        printf("%d\n", ans[i]);
    }

    return 0;
}