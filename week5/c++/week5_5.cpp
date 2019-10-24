#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main(void)
{

    int t;
    cin >> t;

    while (t--)
    {
        int n, m;
        cin >> n >> m;

        queue<pair<int, int>> q;
        priority_queue<int> pq;
        for (int i = 0; i < n; i++)
        {
            int importance;
            cin >> importance;

            q.push(make_pair(i, importance));
            pq.push(importance);
        }

        int count = 0;
        while (!q.empty())
        {
            int index = q.front().first;
            int val = q.front().second;
            q.pop();

            if (pq.top() == val)
            {
                pq.pop();
                count++;
                if (index == m)
                {
                    cout << count << endl;
                    break;
                }
            }
            else
            {
                // 큐 맨 뒤에 다시 집어넣음
                q.push(make_pair(index, val));
            }
        }
    }

    return 0;
}