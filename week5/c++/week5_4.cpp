#include <iostream>

using namespace std;

pair<int, int> a[51];

int main(void)
{
    // Input
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int x, y;
        cin >> x >> y;
        a[i] = make_pair(x, y);
    }

    // Brute force
    int rank[51];
    for (int i = 0; i < n; i++)
    {
        int ranking = 1;
        int weight = a[i].first;
        int height = a[i].second;

        for (int j = 0; j < n; j++)
        {
            if (a[j].first > weight && a[j].second > height)
            {
                ranking++;
            }
        }
        rank[i] = ranking;
    }

    for (int i = 0; i < n; i++)
    {
        cout << rank[i] << " ";
    }

    return 0;
}