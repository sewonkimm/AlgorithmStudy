#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> heights)
{
    vector<int> answer(heights.size());

    // 뒤에서 부터 앞으로 검사
    for (int i = heights.size() - 1; i >= 0; i--)
    {
        int now = heights[i];

        int receive = 0;
        for (int j = i - 1; j >= 0; j--)
        {
            if (heights[j] > now)
            {
                receive = j + 1;
                break;
            }
        }

        answer[i] = receive;
    }
    return answer;
}