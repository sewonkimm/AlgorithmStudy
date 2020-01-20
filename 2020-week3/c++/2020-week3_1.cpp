#include <iostream>
#include <queue>

using namespace std;

int main(int argc, char **argv)
{
    int t;
    scanf("%d", &t);
    while (t--)
    {
        int n, m;
        scanf("%d %d", &n, &m);

        queue<pair<int, int>> q;
        priority_queue<int> pq;
        for (int i = 0; i < n; i++)
        {
            int importance;
            scanf("%d", &importance);

            q.push(make_pair(i, importance));
            pq.push(importance);
        }

        int cnt = 0;
        while (!q.empty())
        {
            int i = q.front().first;
            int val = q.front().second;
            q.pop();

            if (pq.top() == val)
            {
                pq.pop();
                cnt++;
                if (i == m)
                {
                    printf("%d\n", cnt);
                    break;
                }
            }
            else
            {
                q.push(make_pair(i, val));
            }
        }
    }
    return 0;
}