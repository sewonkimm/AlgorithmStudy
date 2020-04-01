#include <stdio.h>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int n;
int map[101][101];
int answer = 0;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int getSafe(int h)
{

    vector<vector<int>> visit(n, vector<int>(n, 0));
    queue<pair<int, int>> q;
    int temp = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {

            if (!visit[i][j] && map[i][j] > h)
            {
                q.push(make_pair(i, j));
                visit[i][j] = 1;
                temp++;

                while (!q.empty())
                {
                    int x = q.front().first;
                    int y = q.front().second;
                    q.pop();

                    for (int k = 0; k < 4; k++)
                    {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < n)
                        {
                            if (!visit[nx][ny] && map[nx][ny] > h)
                            {
                                visit[nx][ny] = 1;
                                q.push(make_pair(nx, ny));
                            }
                        }
                    }
                }
            }
        }
    }

    return temp;
}

int main()
{

    scanf("%d", &n);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &map[i][j]);
        }
    }

    for (int i = 0; i <= 100; i++)
    {
        answer = max(answer, getSafe(i));
    }
    printf("%d\n", answer);
    return 0;
}