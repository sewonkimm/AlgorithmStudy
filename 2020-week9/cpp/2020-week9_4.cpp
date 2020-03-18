#include <iostream>
// 백트래킹

#include <vector>

using namespace std;

int n, m;
int answer[10];

void go(int count, int index)
{
    if (count == m)
    {
        for (int i = 0; i < m; i++)
        {
            cout << answer[i] << " ";
        }
        cout << endl;
        return;
    }

    if (index <= n)
    {
        answer[count] = index;

        go(count + 1, index + 1);
        go(count, index + 1);
    }
}
int main()
{

    cin >> n >> m;

    go(0, 1);

    return 0;
}