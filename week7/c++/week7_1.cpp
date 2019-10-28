#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(int argc, char **argv)
{
    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        int count;
        cin >> count;

        vector<int> factors(count);
        for (int i = 0; i < count; i++)
        {
            cin >> factors[i];
        }
        sort(factors.begin(), factors.end());

        int ans;
        if (count == 1)
        {
            ans = factors[0] * factors[0];
        }
        else
        {
            ans = factors[0] * factors[count - 1];
        }

        cout << "#" << test_case << " ";
        cout << ans << endl;
    }
    return 0;
}