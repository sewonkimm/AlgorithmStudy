#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long int d[100001];
long long int MOD = 1234567;

int go(int i)
{
    if (d[i] > 0)
    {
        return d[i] % MOD;
    }

    if (i < 2)
    {
        return i;
    }

    d[i] = go(i - 1) + go(i - 2);
    return d[i] % MOD;
}

int solution(int n)
{
    int answer = go(n);
    return answer;
}