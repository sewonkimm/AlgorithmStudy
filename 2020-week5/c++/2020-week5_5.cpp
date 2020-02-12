#include <iostream>

using namespace std;

int createNum(int i)
{
    int num = i;
    while (i > 0)
    {
        num += i % 10;
        i /= 10;
    }

    return num;
}
int main(int argc, char **argv)
{

    int n;
    scanf("%d", &n);

    bool printzero = true;
    for (int i = 1; i <= n; i++)
    {
        if (createNum(i) == n)
        {
            printf("%d\n", i);
            printzero = false;
            break;
        }
    }

    if (printzero)
    {
        printf("0\n");
    }
    return 0;
}