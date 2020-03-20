// 백 트래킹

#include <iostream>
#include <algorithm>

using namespace std;

int n;
int s[21][21];
int team[21];
int answer = 1000000;

void go(int count, int index)
{

    if (count == n / 2)
    {
        // 능력치 차이 최솟값
        int teamA, teamB;
        teamA = 0;
        teamB = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {

                if (team[i] && team[j])
                {
                    teamA += s[i][j];
                }
                else if (!team[i] && !team[j])
                {
                    teamB += s[i][j];
                }
            }
        }

        int temp = teamA - teamB;
        if (temp < 0)
        {
            temp *= -1;
        }

        answer = min(answer, temp);
        return;
    }

    if (index < n)
    {
        team[index] = 1;
        go(count + 1, index + 1);
        team[index] = 0;
        go(count, index + 1);
    }
}

int main()
{
    // input
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &s[i][j]);
        }
    }

    go(0, 0);

    printf("%d\n", answer);

    return 0;
}