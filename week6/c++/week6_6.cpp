#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

int main(int argc, char **argv)
{
    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        int k;
        cin >> k;
        vector<vector<int>> num(k + 1, vector<int>());
        for (int i = 0; i < pow(2, k); i++)
        {
            int n;
            cin >> n;
            num[k].push_back(n);
        }

        int sum = 0;
        for (int i = k; i > 0; i--)
        {
            for (int j = 0; j < pow(2, i); j = j + 2)
            {
                int diff, next;
                if (num[i][j] >= num[i][j + 1])
                {
                    diff = num[i][j] - num[i][j + 1];
                    next = num[i][j];
                }
                else
                {
                    diff = num[i][j + 1] - num[i][j];
                    next = num[i][j + 1];
                }
                sum += diff;
                num[i - 1].push_back(next);
            }
        }

        cout << "#" << test_case << " ";
        cout << sum << endl;
    }
}