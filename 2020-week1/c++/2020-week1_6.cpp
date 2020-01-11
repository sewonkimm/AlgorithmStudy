#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char **argv)
{
    int n;
    scanf("%d", &n);

    vector<vector<int>> cost(n + 1, vector<int>(3, 0));
    for (int i = 1; i <= n; i++)
    {
        int r, g, b;
        scanf("%d %d %d", &r, &g, &b);
        cost[i][0] = r;
        cost[i][1] = g;
        cost[i][2] = b;
    }

    vector<vector<int>> d(n + 1, vector<int>(3, 0));
    for (int i = 1; i <= n; i++)
    {
        d[i][0] = min(d[i - 1][1], d[i - 1][2]) + cost[i][0];
        d[i][1] = min(d[i - 1][0], d[i - 1][2]) + cost[i][1];
        d[i][2] = min(d[i - 1][0], d[i - 1][1]) + cost[i][2];
    }

    printf("%d\n", min(min(d[n][0], d[n][1]), d[n][2]));
    return 0;
}