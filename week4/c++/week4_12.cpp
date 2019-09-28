#include <iostream>
#include <vector>
#include <functional>
#include <queue>
#include <algorithm>

using namespace std;

int main(void)
{
    int n;
    scanf("%d", &n);

    priority_queue<int, vector<int>, less<int>> max_heap;
    priority_queue<int, vector<int>, greater<int>> min_heap;

    while (n--)
    {
        int num;
        scanf("%d", &num);

        if (max_heap.size() == min_heap.size())
        {
            max_heap.push(num);
        }
        else
        {
            min_heap.push(num);
        }

        // swap
        if (!min_heap.empty() && max_heap.top() > min_heap.top())
        {
            int maxtop = max_heap.top();
            int mintop = min_heap.top();

            max_heap.pop();
            min_heap.pop();

            max_heap.push(mintop);
            min_heap.push(maxtop);
        }

        printf("%d\n", max_heap.top());
    }

    return 0;
}