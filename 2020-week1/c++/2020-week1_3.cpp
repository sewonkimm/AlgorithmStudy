#include <iostream>
#include <vector>

using namespace std;

int cnt = 0;
vector<pair<int, int>> arr;

void move(int n, int x, int y)
{

    if (n > 1)
    {
        move(n - 1, x, 6 - x - y);
    }

    cnt++;
    arr.push_back(make_pair(x, y));

    if (n > 1)
    {
        move(n - 1, 6 - x - y, y);
    }
}

int main(int argc, char **argv)
{
    int n;
    scanf("%d", &n);

    move(n, 1, 3);

    printf("%d\n", cnt);

    for (int i = 0; i < arr.size(); i++)
    {
        printf("%d %d\n", arr[i].first, arr[i].second);
    }
    return 0;
}