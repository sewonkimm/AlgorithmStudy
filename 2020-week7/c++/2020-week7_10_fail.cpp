// bfs로 풀이 시도했으나 틀렸습니다!!
// 풀이시간 60분

// 반례 https://www.acmicpc.net/board/view/23658

#include <iostream>
#include <queue>

using namespace std;

char map[101][101];
int d[3][101][101];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

void bfs(int ver, int x, int y, int w, int h)
{

    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    d[ver][x][y] = 0;

    while (!q.empty())
    {
        int nowx = q.front().first;
        int nowy = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = nowx + dx[i];
            int ny = nowy + dy[i];

            if (nx >= 0 && nx <= h && ny >= 0 && ny <= w && d[ver][nx][ny] == -1)
            {
                if (map[nx][ny] == '*')
                {
                    continue;
                }
                else if (map[nx][ny] == '.' || map[nx][ny] == '$')
                {
                    d[ver][nx][ny] = d[ver][nowx][nowy];
                    q.push(make_pair(nx, ny));
                }
                else if (map[nx][ny] == '#')
                {
                    d[ver][nx][ny] = d[ver][nowx][nowy] + 1;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
}
int main(int argc, char **argv)
{

    int t;
    scanf("%d", &t);

    while (t--)
    {
        int h, w;
        scanf("%d %d", &h, &w);

        // initialize
        for (int i = 0; i < 101; i++)
        {
            for (int j = 0; j < 101; j++)
            {
                map[i][j] = '.';
            }
        }
        for (int k = 0; k < 3; k++)
        {
            for (int i = 0; i < 101; i++)
            {
                for (int j = 0; j < 101; j++)
                {
                    d[k][i][j] = -1;
                }
            }
        }

        // input
        queue<pair<int, int>> door;
        for (int i = 1; i <= h; i++)
        {
            for (int j = 1; j <= w; j++)
            {
                scanf("%1s", &map[i][j]);

                // 문 위치 저장
                if (map[i][j] == '#')
                {
                    door.push(make_pair(i, j));
                }
                // 테두리 위치 저장
                else if (i == 1 || i == h || j == 1 || j == w)
                {
                    door.push(make_pair(i, j));
                }
            }
        }

        // 상근이 bfs
        int ver = 0;
        bfs(ver, 0, 0, w, h);
        ver++;

        // 죄수1, 2 bfs
        for (int i = 1; i <= h; i++)
        {
            for (int j = 1; j <= w; j++)
            {
                if (map[i][j] == '$')
                {
                    bfs(ver, i, j, w, h);
                    ver++;
                }
            }
        }

        // 문 위치에서 3개의 합이 최소인 부분
        int ans = 1000;
        while (!door.empty())
        {
            int x = door.front().first;
            int y = door.front().second;
            door.pop();

            int sum = 0;
            for (int i = 0; i < 3; i++)
            {
                sum += d[i][x][y];
            }

            if (sum >= 0 && sum < ans)
            {
                ans = sum;
            }
        }

        ans -= 2;
        if (ans < 0)
        {
            ans = 0;
        }
        printf("%d\n", ans);
    }

    return 0;
}