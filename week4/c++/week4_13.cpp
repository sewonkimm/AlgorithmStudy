#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main(void)
{
    int n, m;
    cin >> n >> m;

    vector<vector<int>> com(n + 1, vector<int>());
    while (m--)
    {
        int s, e;
        cin >> s >> e;
        com[s].push_back(e);
        com[e].push_back(s);
    }

    vector<int> d(n + 1, 0);
    queue<int> q;
    d[1] = 1;
    int count = 0;
    for (int i = 0; i < com[1].size(); i++)
    {
        q.push(com[1][i]);
        d[com[1][i]] = 1;
    }

    while (!q.empty())
    {
        int now = q.front();
        q.pop();
        count++;

        for (int i = 0; i < com[now].size(); i++)
        {
            int next = com[now][i];

            if (d[next] == 0)
            {
                d[next] = 1;
                q.push(next);
            }
        }
    }

    cout << count << endl;

    return 0;
}