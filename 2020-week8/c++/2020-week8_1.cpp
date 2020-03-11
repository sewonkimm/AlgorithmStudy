#include <iostream>
#include <queue>

using namespace std;

char map[10][10];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int main(int argc, char **argv)
{

    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            scanf("%1s", &map[i][j]);
        }
    }

    int x, y;
    scanf("%d %d", &x, &y);

    if (map[y][x] == '_')
    {
        queue<pair<int, int>> q;
        q.push(make_pair(x, y));
        map[y][x] = '*';

        while (!q.empty())
        {
            int nowx = q.front().first;
            int nowy = q.front().second;
            q.pop();

            for (int i = 0; i < 4; i++)
            {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10)
                {
                    if (map[ny][nx] == '_')
                    {
                        map[ny][nx] = '*';
                        q.push(make_pair(nx, ny));
                    }
                }
            }
        }
    }

    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            printf("%c", map[i][j]);
        }
        printf("\n");
    }
    return 0;
}