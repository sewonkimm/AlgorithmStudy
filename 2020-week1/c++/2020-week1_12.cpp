#include <iostream>
#include <queue>

using namespace std;

bool check[100001];
int d[100001];

int main()
{
    int n, k;
    scanf("%d %d", &n, &k);

    queue<int> q;
    q.push(n);
    while (!q.empty())
    {
        int now = q.front();
        check[now] = 1;
        q.pop();

        if (now - 1 >= 0)
        {
            if (!check[now - 1])
            {
                check[now - 1] = 1;
                q.push(now - 1);
                d[now - 1] = d[now] + 1;
            }
        }

        if (now + 1 < 100001)
        {
            if (!check[now + 1])
            {
                check[now + 1] = 1;
                q.push(now + 1);
                d[now + 1] = d[now] + 1;
            }
        }

        if (2 * now < 100001)
        {
            if (!check[2 * now])
            {
                check[2 * now] = 1;
                q.push(2 * now);
                d[2 * now] = d[now] + 1;
            }
        }
    }

    printf("%d\n", d[k]);
    return 0;
}