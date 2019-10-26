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
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; i++)
        {
            cin >> a[i];
        }

        sort(a.begin(), a.end());
        int answer = 0;
        for (int i = 0; i < n; i++)
        {
            answer += a[i];
        }
        answer = answer + n + a[n - 1];

        cout << "#" << test_case << " ";
        cout << answer << endl;
    }
    return 0;
}