#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int parent[100001];
bool check[100001];
vector<int> a[100001];

int main(int argc, char **argv)
{
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n - 1; i++)
    {
        int n1, n2;
        scanf("%d %d", &n1, &n2);

        a[n1].push_back(n2);
        a[n2].push_back(n1);
    }

    queue<int> q;
    check[1] = true;
    q.push(1);

    while (!q.empty())
    {
        int x = q.front();
        q.pop();

        for (int i = 0; i < a[x].size(); i++)
        {
            int y = a[x][i];
            if (!check[y])
            {
                check[y] = true;
                parent[y] = x;
                q.push(y);
            }
        }
    }

    for (int i = 2; i <= n; i++)
    {
        printf("%d\n", parent[i]);
    }
    return 0;
}