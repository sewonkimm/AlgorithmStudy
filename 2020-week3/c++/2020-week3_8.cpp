#include <iostream>
#include <queue>

using namespace std;

int n, m, h;
int map[101][101][101];
int dist[101][101][101];

int dx[6] = {-1, 1, 0, 0, 0, 0};
int dy[6] = {0, 0, -1, 1, 0, 0};
int dz[6] = {0, 0, 0, 0, -1, 1};

void bfs(queue<pair<pair<int, int>, int>> q)
{

    while (!q.empty())
    {
        int x = q.front().first.first;
        int y = q.front().first.second;
        int z = q.front().second;
        q.pop();

        for (int i = 0; i < 6; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nz = z + dz[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h)
            {
                if (map[nx][ny][nz] == 0 && dist[nx][ny][nz] == -1)
                {
                    q.push(make_pair(make_pair(nx, ny), nz));
                    dist[nx][ny][nz] = dist[x][y][z] + 1;
                }
            }
        }
    }
}

void init(int n, int m, int h)
{
    for (int k = 0; k < h; k++)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                dist[i][j][k] = -1;
            }
        }
    }
}

int main(int argc, char **argv)
{

    cin >> m >> n >> h;
    init(n, m, h);
    queue<pair<pair<int, int>, int>> q;

    for (int k = 0; k < h; k++)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                cin >> map[i][j][k];
                if (map[i][j][k] == 1)
                {
                    dist[i][j][k] = 0;
                    q.push(make_pair(make_pair(i, j), k));
                }
            }
        }
    }

    bfs(q);

    int ans = 0;
    for (int k = 0; k < h; k++)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (map[i][j][k] == 0 && dist[i][j][k] == -1)
                {
                    cout << "-1\n";
                    return 0;
                }

                if (dist[i][j][k] > ans)
                {
                    ans = dist[i][j][k];
                }
            }
        }
    }
    cout << ans << endl;
    return 0;
}