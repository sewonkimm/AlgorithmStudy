#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char **argv)
{

    int n, m;
    scanf("%d %d", &n, &m);

    vector<int> num(n + 1, 0);
    vector<int> d(n + 1, 0);
    for (int i = 1; i <= n; i++)
    {
        scanf("%d", &num[i]);

        if (i == 1)
        {
            d[i] = num[i];
        }
        else
        {
            d[i] = d[i - 1] + num[i];
        }
    }

    for (int i = 0; i < m; i++)
    {
        int a, b;
        scanf("%d %d", &a, &b);
        printf("%d\n", d[b] - d[a - 1]);
    }

    return 0;
}