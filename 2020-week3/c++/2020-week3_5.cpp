#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(const vector<int> &a, const vector<int> &b)
{
    if (a[1] == b[1])
    {
        return (a[0] < b[0]);
    }
    return (a[1] < b[1]);
}

int main(int argc, char **argv)
{
    int n;
    scanf("%d", &n);

    vector<vector<int>> times(n, vector<int>(2, 0));
    for (int i = 0; i < n; i++)
    {
        scanf("%d %d", &times[i][0], &times[i][1]);
    }
    sort(times.begin(), times.end(), cmp);

    int ans = 1;
    int nt = times[0][1];
    for (int i = 1; i < n; i++)
    {
        if (nt <= times[i][0])
        {
            ans++;
            nt = times[i][1];
        }
    }
    printf("%d\n", ans);
    return 0;
}