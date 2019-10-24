#include <string>
#include <vector>

using namespace std;

int d[60001];
long long int MOD = 1000000007;

int go(int i)
{
    if (d[i] > 0)
    {
        return d[i];
    }

    if (i <= 2)
    {
        return i;
    }

    d[i] = (go(i - 1) + go(i - 2)) % MOD;
    return d[i];
}

int solution(int n)
{

    int answer = go(n);
    return answer;
}