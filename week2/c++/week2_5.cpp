#include <string>
#include <vector>

using namespace std;

long long f[81];

long long fibo(int i)
{
    if (f[i] > 0)
    {
        return f[i];
    }

    if (i < 2)
    {
        return 1;
    }

    f[i] = fibo(i - 1) + fibo(i - 2);
    return f[i];
}

long long solution(int N)
{
    long long answer = (fibo(N - 1) + fibo(N)) * 2;
    return answer;
}