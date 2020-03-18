#include <iostream>
#include <vector>

using namespace std;

int n, m;
vector<int> answer;

void go(int count)
{

    // print
    if (count == m)
    {
        for (int i = 0; i < m; i++)
        {
            printf("%d ", answer[i]);
        }
        printf("\n");
        return;
    }

    // 숫자 고르기
    for (int i = 1; i <= n; i++)
    {
        answer.push_back(i);
        go(count + 1);
        answer.pop_back();
    }
}
int main()
{

    scanf("%d %d", &n, &m);

    go(0);

    return 0;
}