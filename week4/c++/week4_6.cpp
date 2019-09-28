#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

bool map[51][51];
int d[51][51];

int main(void)
{
    int t;
    cin >> t;

    while (t--)
    {
        int m, n, k;
        cin >> m >> n >> k;

        // 테스트 할 때마다 초기화
        memset(map, false, sizeof(map));
        memset(d, 0, sizeof(d));

        for (int i = 0; i < k; i++)
        {
            int x, y;
            cin >> x >> y;
            map[y][x] = true;
        }

        int count = 1;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (map[i][j] && d[i][j] == 0)
                {
                    queue<pair<int, int>> q;
                    q.push(make_pair(i, j));
                    d[i][j] = count;
                    count++;

                    // BFS
                    while (!q.empty())
                    {
                        int x = q.front().first;
                        int y = q.front().second;
                        q.pop();

                        for (int k = 0; k < 4; k++)
                        {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m)
                            {
                                if (map[nx][ny] && d[nx][ny] == 0)
                                {
                                    q.push(make_pair(nx, ny));
                                    d[nx][ny] = d[x][y];
                                }
                            }
                        }
                    }
                }
            }
        }
        cout << count - 1 << endl;
    }

    return 0;
}