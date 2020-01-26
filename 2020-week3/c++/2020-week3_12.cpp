#include <iostream>

using namespace std;

int main(int argc, char **argv)
{

    // testcase input
    int t;
    cin >> t;

    while (t--)
    {
        // input
        int n, m;
        cin >> n >> m;

        for (int i = 0; i < m; i++)
        {
            int a, b;
            cin >> a >> b;
        }

        // 모든 도시를 여행하기 위해서는 n-1번 타야한다. (가중치가 1로 모두 같기 때문에)
        cout << n - 1 << endl;
    }

    return 0;
}