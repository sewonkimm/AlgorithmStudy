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

int main(void)
{
    int n;
    cin >> n;

    vector<vector<int>> times(n + 1, vector<int>(2, 0));
    for (int i = 0; i < n; i++)
    {
        cin >> times[i][0] >> times[i][1];
    }
    sort(times.begin(), times.end(), cmp);

    int count = 1;
    int nextTime = times[1][1];
    for (int i = 2; i <= n; i++)
    {

        if (nextTime <= times[i][0])
        {

            count++;
            nextTime = times[i][1];
        }
    }
    cout << count << endl;
    return 0;
}