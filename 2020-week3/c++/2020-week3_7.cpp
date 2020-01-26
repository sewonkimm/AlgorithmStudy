#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

vector<vector<int>> bfs(queue<pair<int, int>> q, vector<vector<int>> map, vector<vector<int>> dist)
{

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m)
            {
                if (map[nx][ny] == 0 && dist[nx][ny] == -1)
                {
                    q.push(make_pair(nx, ny));
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
    }

    return dist;
}

int main(int argc, char **argv)
{

    cin >> m >> n;
    vector<vector<int>> map(n, vector<int>(m));
    vector<vector<int>> dist(n, vector<int>(m, -1));
    queue<pair<int, int>> q;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> map[i][j];
            if (map[i][j] == 1)
            {
                dist[i][j] = 0;
                q.push(make_pair(i, j));
            }
        }
    }

    dist = bfs(q, map, dist);

    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {

            if (map[i][j] == 0 && dist[i][j] == -1)
            {
                cout << "-1\n";
                return 0;
            }

            if (dist[i][j] > ans)
            {
                ans = dist[i][j];
            }
        }
    }
    cout << ans << endl;
    return 0;
}