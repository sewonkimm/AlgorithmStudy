#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char **argv)
{

    // input
    int n;
    scanf("%d", &n);

    // d[i] = 3*i일때 경우의 수
    vector<int> d(n + 1, 0);

    // initial
    d[0] = 1; // 특수케이스
    d[2] = 3;

    // bottom-up
    for (int i = 4; i <= n; i += 2)
    {
        // d[i] = d[i-2]*d[2] (기본 케이스)
        // d[i] = d[i-2]의 특수케이스*d[2]
        // d[i] = d[i]의 특수 케이스

        for (int j = 2; j <= i; j += 2)
        {
            int standard;
            j == 2 ? (standard = 3) : (standard = 2);

            d[i] += standard * d[i - j];
        }
    }

    printf("%d\n", d[n]);

    return 0;
}