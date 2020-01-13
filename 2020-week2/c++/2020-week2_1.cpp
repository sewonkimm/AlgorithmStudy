#include <iostream>

using namespace std;

int fac(int n)
{
    if (n <= 1)
    {
        return 1;
    }
    return n * fac(n - 1);
}

int main(int argc, char **argv)
{
    int n;
    scanf("%d", &n);

    printf("%d\n", fac(n));
    return 0;
}