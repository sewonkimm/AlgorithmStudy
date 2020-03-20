#include <iostream>

using namespace std;

int nums[10001];

int main()
{
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
    {
        int x;
        scanf("%d", &x);
        nums[x]++;
    }

    for (int i = 0; i < 10001; i++)
    {

        if (nums[i] > 0)
        {
            for (int j = 0; j < nums[i]; j++)
            {
                printf("%d\n", i);
            }
        }
    }

    return 0;
}