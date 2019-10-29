#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char **argv)
{
    int test_case;
    int T;
    cin >> T;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        int n, k;
        cin >> n >> k;
        vector<int> m(n);
        for (int i = 0; i < n; i++)
        {
            cin >> m[i];
        }
        sort(m.begin(), m.end(), greater<int>());

        float ans = 0;
        for (int i = (k - 1); i >= 0; i--)
        {
            ans = (ans + m[i]) / 2.0;
        }

        cout << "#" << test_case << " ";
        cout << ans << endl;
    }
    return 0;
}