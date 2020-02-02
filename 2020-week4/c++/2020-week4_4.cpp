#include <iostream>
#include <vector>

using namespace std;

void sort(vector<int> arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        for (int j = i + 1; j < arr.size(); j++)
        {

            if (arr[i] > arr[j])
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    for (int i = 0; i < arr.size(); i++)
    {
        printf("%d\n", arr[i]);
    }
}

int main(int argc, char **argv)
{

    int N;
    scanf("%d", &N);

    vector<int> arr(N, 0);
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
    }

    sort(arr);

    return 0;
}