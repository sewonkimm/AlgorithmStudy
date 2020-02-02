#include <iostream>

using namespace std;

int arr[1000001];

void sort(int L, int R)
{

    if (L >= R)
    {
        return;
    }

    // pivot
    int x = arr[(L + R) / 2];
    int pl = L;
    int pr = R;

    do
    {
        while (arr[pl] < x)
        {
            pl++;
        }
        while (arr[pr] > x)
        {
            pr--;
        }

        if (pl <= pr)
        {
            swap(arr[pl], arr[pr]);
            pl++;
            pr--;
        }
    } while (pl <= pr);

    if (L < pl)
    {
        sort(L, pr);
    }
    if (R > pr)
    {
        sort(pl, R);
    }
}

int main(int argc, char **argv)
{

    int N;
    scanf("%d", &N);

    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
    }

    sort(0, N - 1);

    for (int i = 0; i < N; i++)
    {
        printf("%d\n", arr[i]);
    }

    return 0;
}