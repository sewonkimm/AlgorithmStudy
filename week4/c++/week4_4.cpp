#include <iostream>
#include <queue>

using namespace std;

int main()
{
    int n, k;
    cin >> n >> k;

    queue<int> q;

    for (int i = 1; i <= n; i++)
    {
        q.push(i);
    }

    int count = 1;
    cout << "<";
    while (!q.empty())
    {
        int first = q.front();
        q.pop();

        if (count == k)
        {
            cout << first;
            count = 1;

            if (!q.empty())
            {
                cout << ", ";
            }
        }
        else
        {
            q.push(first);
            count++;
        }
    }
    cout << ">\n";

    return 0;
}
