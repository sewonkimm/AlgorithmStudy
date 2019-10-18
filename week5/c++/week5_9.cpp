#include <iostream>
#include <queue>

using namespace std;

int main(void)
{
    int n;
    cin >> n;

    deque<int> dq;
    for (int i = 1; i <= n; i++)
    {
        dq.push_back(i);
    }

    while (dq.size() != 1)
    {
        dq.pop_front();
        int temp = dq.front();
        dq.pop_front();
        dq.push_back(temp);
    }

    cout << dq.front();

    return 0;
}