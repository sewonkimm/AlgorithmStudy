#include <iostream>

using namespace std;

int money[6] = {500, 100, 50, 10, 5, 1};
int chk[6];

int main(int argc, char **argv)
{

    int n;
    scanf("%d", &n);

    // 500 > 100 > 50 > 10 > 5 > 1
    n = 1000 - n;

    int i = 0;
    while (n > 0)
    {
        if (n / money[i] > 0)
        {
            chk[i] = n / money[i];
        }
        n %= money[i];
        i++;
    }

    int ans = 0;
    for (int i = 0; i < 6; i++)
    {
        if (chk[i])
            ans += chk[i];
    }
    printf("%d\n", ans);
    return 0;
}