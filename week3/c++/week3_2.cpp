#include <string>
#include <vector>

using namespace std;

int answer = 0;

void set(int n, int i, vector<int> x, vector<int> y, vector<int> slash_one, vector<int> slash_two)
{

    for (int j = 0; j < n; j++)
    {

        if (!x[j] && !slash_one[i + j] && !slash_two[j - i + (n - 1)])
        {
            y[i] = j;

            // 모든 열에 퀸 배치하면 종료
            if (i == n - 1)
            {
                answer++;
            }
            else
            {
                // 다음 열에도 배치
                x[j] = slash_one[i + j] = slash_two[j - i + (n - 1)] = 1;
                set(n, i + 1, x, y, slash_one, slash_two);

                // 다음 행에 배치하기 위해 원상복구
                x[j] = slash_one[i + j] = slash_two[j - i + (n - 1)] = 0;
            }
        }
    }
}

int solution(int n)
{
    // 각 행에 퀸을 배치했는지 체크
    vector<int> x(n, 0);
    // 각 열에서 퀸의 위치
    vector<int> y(n, 0);
    // 각 대각선 / 방향에 퀸을 배치했는지 체크
    vector<int> slash_one(n * n, 0);
    // 각 대각선 \ 방향에 퀸을 배치했는지 체크
    vector<int> slash_two(n * n, 0);

    set(n, 0, x, y, slash_one, slash_two);

    return answer;
}