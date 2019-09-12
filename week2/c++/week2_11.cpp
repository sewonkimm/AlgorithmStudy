#include <string>
#include <vector>

using namespace std;

int MOD = 1234567;

long long solution(int n)
{
    long long answer = 0;

    vector<int> d(n + 1, 0);

    d[1] = 1;
    d[2] = 2;
    for (int i = 3; i <= n; i++)
    {
        d[i] = (d[i - 1] + d[i - 2]) % MOD;
    }
    answer = d[n];

    return answer;
}