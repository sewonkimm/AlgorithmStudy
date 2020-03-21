// test case

// 11 10
// 7 4 0
// 1 1 1 1 1 1 1 1 1 1
// 1 0 0 0 0 0 0 0 0 1
// 1 0 0 0 1 1 1 1 0 1
// 1 0 0 1 1 0 0 0 0 1
// 1 0 1 1 0 0 0 0 0 1
// 1 0 0 0 0 0 0 0 0 1
// 1 0 0 0 0 0 0 1 0 1
// 1 0 0 0 0 0 1 1 0 1
// 1 0 0 0 0 0 1 1 0 1
// 1 0 0 0 0 0 0 0 0 1
// 1 1 1 1 1 1 1 1 1 1

// result : 57
// my result : 54

#include <iostream>
#include <queue>

using namespace std;

int n, m;
int r, c, direction;

int dx[4] = {0, -1, 0, 1};
int dy[4] = {-1, 0, 1, 0};

int bx[4] = {-1, 0, 1, 0};
int by[4] = {0, -1, 0, 1};

int map[51][51];
int visit[51][51];
int answer;

int noWay(int x, int y)
{

    bool isWay = false;

    // 네 방향 확인
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (!visit[nx][ny] && !map[nx][ny])
        {
            isWay = true;
            break;
        }
    }

    if (!isWay)
    {
        int backx = x + bx[direction];
        int backy = y + by[direction];

        if (map[backx][backy])
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
    else
    {
        return 2;
    }
}

int main()
{

    // input
    scanf("%d %d", &n, &m);
    scanf("%d %d %d", &r, &c, &direction);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%d", &map[i][j]);
        }
    }

    queue<pair<int, int>> q;
    q.push(make_pair(r, c));

    while (!q.empty())
    {
        int nowx = q.front().first;
        int nowy = q.front().second;
        q.pop();

        // 1. 현재 위치를 청소한다.
        if (!visit[nowx][nowy])
        {
            visit[nowx][nowy] = 1;
            answer++;
        }

        int check = noWay(nowx, nowy);

        // 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 종료한다.
        if (check == 0)
        {
            break;
        }
        // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
        else if (check == 1)
        {
            int backx = nowx + bx[direction];
            int backy = nowy + by[direction];
            q.push(make_pair(backx, backy));
        }
        // 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행
        else if (check == 2)
        {

            int nextx = nowx + dx[direction];
            int nexty = nowy + dy[direction];

            direction -= 1;
            if (direction < 0)
            {
                direction = 3;
            }

            if (!visit[nextx][nexty] && !map[nextx][nexty])
            {
                // a. 청소할 곳 이 있다.
                // 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
                q.push(make_pair(nextx, nexty));
            }
            else
            {
                // b. 청소할 곳이 없다.
                // 그 방향으로 회전하고 2번으로 돌아간다.
                q.push(make_pair(nowx, nowy));
            }
        }
    }

    printf("%d\n", answer);

    return 0;
}