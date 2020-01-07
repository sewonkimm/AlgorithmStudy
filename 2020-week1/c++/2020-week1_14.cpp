#include <iostream>
#include <vector>

using namespace std;

// Max heap

vector<int> heap(1, 0);

void insertheap(int num)
{
    heap.push_back(num);

    int i = heap.size() - 1;
    while (i != 1)
    {
        if (heap[i] > heap[i / 2])
        {
            int temp = heap[i];
            heap[i] = heap[i / 2];
            heap[i / 2] = temp;

            i /= 2;
        }
        else
        {
            break;
        }
    }
}

void deleteheap()
{

    if (heap.size() == 2)
    {
        heap.erase(heap.begin() + 1, heap.begin() + 2);
    }
    else
    {
        heap[1] = heap[heap.size() - 1];
        heap.erase(heap.begin() + heap.size() - 1, heap.begin() + heap.size());
    }

    int parent = 1;
    int child = 2;
    int temp = heap[parent];

    while (child < heap.size())
    {
        if (heap[child] < heap[child + 1])
        {
            child++;
        }

        if (temp >= heap[child])
        {
            break;
        }
        else
        {
            heap[parent] = heap[child];
            heap[child] = temp;

            parent = child;
            child = parent * 2;
        }

        temp = heap[parent];
    }
}

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
            if (heap.size() > 1)
            {
                printf("%d\n", heap[1]);
                deleteheap();
            }
            else
            {
                printf("%d\n", 0);
            }
        }
        else
        {
            // 삽입
            insertheap(x);
        }
    }
    return 0;
}