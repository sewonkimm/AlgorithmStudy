#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n, m;
int map[101][101];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int main(int argc, char **argv)
{

    scanf("%d %d", &m, &n);

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &map[i][j]);
        }
    }

    // on - 0 to 1
    vector<vector<int>> visit1(m, vector<int>(n, 0));
    int cnt1 = 0;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (map[i][j] == 0 && visit1[i][j] == 0)
            {

                cnt1++;

                // dfs
                queue<pair<int, int>> q;
                q.push(make_pair(i, j));

                while (!q.empty())
                {
                    int x = q.front().first;
                    int y = q.front().second;
                    visit1[x][y] = 1;
                    q.pop();

                    for (int i = 0; i < 4; i++)
                    {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx >= 0 && nx < m && ny >= 0 && ny < n)
                        {
                            if (map[nx][ny] == 0 && visit1[nx][ny] == 0)
                            {
                                q.push(make_pair(nx, ny));
                            }
                        }
                    }
                }
            }
        }
    }

    // off - 1 to 0
    vector<vector<int>> visit2(m, vector<int>(n, 0));
    int cnt2 = 0;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (map[i][j] == 1 && visit2[i][j] == 0)
            {

                cnt2++;

                // dfs
                queue<pair<int, int>> q;
                q.push(make_pair(i, j));

                while (!q.empty())
                {
                    int x = q.front().first;
                    int y = q.front().second;
                    visit2[x][y] = 1;
                    q.pop();

                    for (int i = 0; i < 4; i++)
                    {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx >= 0 && nx < m && ny >= 0 && ny < n)
                        {
                            if (map[nx][ny] == 1 && visit2[nx][ny] == 0)
                            {
                                q.push(make_pair(nx, ny));
                            }
                        }
                    }
                }
            }
        }
    }

    printf("%d %d\n", cnt1, cnt2);
    return 0;
}