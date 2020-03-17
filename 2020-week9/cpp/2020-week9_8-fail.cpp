// 틀렸습니다

#include <iostream>
#include <vector>

using namespace std;

int n;
int m;
int a, b;
int answer = -1;
int d[101][101];
int visit[101][101];

void calculate(int x, int count)
{

    if (x == b)
    {
        answer = count;
        return;
    }

    if (d[x][b])
    {
        answer = count + 1;
        return;
    }

    for (int i = 1; i <= n; i++)
    {
        if (d[x][i] && !visit[x][i])
        {
            visit[x][i] = 1;
            calculate(i, count + 1);
        }
    }

    return;
}

int main()
{

    // input
    scanf("%d", &n);
    scanf("%d %d", &a, &b);
    scanf("%d", &m);

    while (m--)
    {
        int x, y;
        scanf("%d %d", &x, &y);

        d[x][y] = 1;
        d[y][x] = 1;
    }

    calculate(a, 0);

    printf("%d\n", answer);

    return 0;
}