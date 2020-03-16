#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

char board[51][51];

string situation1[8] = {"BWBWBWBW",
                        "WBWBWBWB",
                        "BWBWBWBW",
                        "WBWBWBWB",
                        "BWBWBWBW",
                        "WBWBWBWB",
                        "BWBWBWBW",
                        "WBWBWBWB"};
string situation2[8] = {"WBWBWBWB",
                        "BWBWBWBW",
                        "WBWBWBWB",
                        "BWBWBWBW",
                        "WBWBWBWB",
                        "BWBWBWBW",
                        "WBWBWBWB",
                        "BWBWBWBW"};

int getNum(int x, int y)
{

    int s1, s2;
    s1 = 0;
    s2 = 0;

    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if (situation1[i][j] != board[x + i][y + j])
            {
                s1++;
            }

            if (situation2[i][j] != board[x + i][y + j])
            {
                s2++;
            }
        }
    }

    return min(s1, s2);
}

int main()
{

    // input
    int n, m;
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%1s", &board[i][j]);
        }
    }

    // get minimum
    int answer = 1000000;
    for (int i = 0; i <= n - 8; i++)
    {
        for (int j = 0; j <= m - 8; j++)
        {
            answer = min(answer, getNum(i, j));
        }
    }

    // print
    printf("%d\n", answer);
    return 0;
}