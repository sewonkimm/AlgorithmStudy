#include <iostream>
#include <queue>

using namespace std;

// Min heap
priority_queue<int, vector<int>, greater<int>> heap;

int main()
{
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
    {
        int x;
        scanf("%d", &x);

        if (x == 0)
        {
            // 루트 값 출력 후 삭제
            printf("%d\n", (heap.empty() ? 0 : heap.top()));

            if (!heap.empty())
            {
                heap.pop();
            }
        }
        else
        {
            // 삽입
            heap.push(x);
        }
    }
    return 0;
}