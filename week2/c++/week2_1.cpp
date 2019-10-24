#include <string>
#include <vector>

using namespace std;

int solution(string arrangement)
{
    // 레이저 위치 표시 0은 레이저, 1은 막대
    vector<int> arr;
    for (int i = 0; i < arrangement.size(); i++)
    {

        if (i == arrangement.size() - 1)
        {
            arr.push_back(1);
        }

        // 연속 2개씩 검사해서 () 인 부분 찾기
        if (arrangement[i] == '(' && arrangement[i + 1] == ')')
        {
            arr.push_back(0);
            i++;
            continue;
        }

        // 막대일 때
        if (arrangement[i] == '(')
        {
            arr.push_back(1);
        }
        else if (arrangement[i] == ')')
        {
            arr.push_back(2);
        }
    }

    // 레이저를 만나기 전 1의 갯수 = 토막난 막대의 수
    // 1을 만났을 때 막대의 수 +1
    // 2를 만났을 때 막대의 수 -1
    int stick = 0;
    int answer = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] == 0)
        {
            answer += stick;
        }
        else if (arr[i] == 1)
        {
            stick++;
        }
        else if (arr[i] == 2)
        {
            stick--;
            answer += 1;
        }
    }

    return answer;
}