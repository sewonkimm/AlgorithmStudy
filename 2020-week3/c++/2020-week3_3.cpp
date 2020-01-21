#include <iostream>

using namespace std;

int num[10];
bool check[10];

void go(int index, int n, int m)
{
    if (index == m)
    {
        for (int i = 0; i < m; i++)
        {
            printf("%d ", num[i]);
        }
        printf("\n");
        return;
    }

    for (int i = 1; i <= n; i++)
    {
        if (check[i])
        {
            continue;
        }

        check[i] = true;
        num[index] = i;
        go(index + 1, n, m);
        check[i] = false;
    }
}

int main(int argc, char **argv)
{
    int n, m;
    scanf("%d %d", &n, &m);

    go(0, n, m);
    return 0;
}