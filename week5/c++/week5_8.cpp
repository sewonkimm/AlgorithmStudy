#include <iostream>
#include <algorithm>

using namespace std;

char a[51][51];

//(0, 0)이 W인 체스보드
string whiteFirst[8] = {
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"}};

//(0, 0)이 B인 체스보드
string blackFirst[8] = {

    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"}};

int whiteFirstChange(int y, int x)
{
    int cnt = 0;

    for (int i = y; i < y + 8; i++)
    {
        for (int j = x; j < x + 8; j++)
        {
            if (a[i][j] != whiteFirst[i - y][j - x])
            {
                cnt++;
            }
        }
    }

    return cnt;
}

int balckFirstChange(int y, int x)
{
    int cnt = 0;

    for (int i = y; i < y + 8; i++)
    {
        for (int j = x; j < x + 8; j++)
        {
            if (a[i][j] != blackFirst[i - y][j - x])
            {
                cnt++;
            }
        }
    }

    return cnt;
}

int main(void)
{

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> a[i][j];
        }
    }

    int res = 1000000000;
    for (int i = 0; i + 7 < n; i++)
    {
        for (int j = 0; j + 7 < m; j++)
        {
            res = min(res, min(whiteFirstChange(i, j), balckFirstChange(i, j)));
        }
    }
    cout << res << endl;

    return 0;
}