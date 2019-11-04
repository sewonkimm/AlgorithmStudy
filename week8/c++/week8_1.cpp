#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> baseball)
{
    string num;
    string inputNum;

    int answer = 0;

    for (int i = 123; i <= 987; i++)
    {
        num = to_string(i);

        // 같은 숫자 중복되는 경우, 0 쓰는 경우 제외
        if (num[0] == num[1] || num[0] == num[2] || num[1] == num[2])
        {
            continue;
        }
        if (num[0] == '0' || num[1] == '0' || num[2] == '0')
        {
            continue;
        }

        // 탐색 시작
        bool flag = true;
        for (int j = 0; j < baseball.size(); j++)
        {
            inputNum = to_string(baseball[j][0]);
            int strike = 0;
            int ball = 0;

            // 탐색 숫자와 baseball 배열 숫자 비교
            for (int x = 0; x < 3; x++)
            {
                for (int y = 0; y < 3; y++)
                {
                    if (num[x] == inputNum[y])
                    {
                        if (x == y)
                        {
                            strike++;
                        }
                        else if (x != y)
                        {
                            ball++;
                        }
                    }
                }
            }

            // strike와 ball 갯수가 일치하는지 확인
            if (strike != baseball[j][1] || ball != baseball[j][2])
            {
                flag = false;
                break;
            }
        }

        // 모든 배열을 검사하고 살아남으면 카운트
        if (flag)
        {
            answer++;
        }
    }
    return answer;
}