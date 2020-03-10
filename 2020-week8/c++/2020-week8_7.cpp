// 풀이 시간 10분
// next_permutatio 아용해서 풀이

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool desc(int a, int b)
{
    return a < b;
}

int main(int argc, char **argv)
{

    int tall[9];
    for (int i = 0; i < 9; i++)
    {
        scanf("%d", &tall[i]);
    }

    vector<int> com(9, 0);
    for (int i = 0; i < 7; i++)
    {
        com[i] = 1;
    }
    sort(com.begin(), com.end());

    vector<int> ans;
    do
    {
        int sum = 0;
        for (int i = 0; i < 9; i++)
        {
            if (com[i])
            {
                sum += tall[i];
            }
        }

        if (sum == 100)
        {
            for (int i = 0; i < 9; i++)
            {
                if (com[i])
                {
                    ans.push_back(tall[i]);
                }
            }
            break;
        }
    } while (next_permutation(com.begin(), com.end()));

    sort(ans.begin(), ans.end(), desc);
    for (int i = 0; i < 7; i++)
    {
        printf("%d\n", ans[i]);
    }

    return 0;
}