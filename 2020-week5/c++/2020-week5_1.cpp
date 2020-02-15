#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char **argv)
{

    int n;
    scanf("%d", &n);

    vector<int> d(n + 1, 0);
    d[1] = 1;
    d[2] = 2;
    for (int i = 3; i <= n; i++)
    {
        d[i] = (d[i - 1] + d[i - 2]) % 10007;
    }

    printf("%d\n", d[n]);
    return 0;
}
