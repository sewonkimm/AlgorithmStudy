#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int stock, vector<int> dates, vector<int> supplies, int k)
{

    priority_queue<int, vector<int>, less<int>> q;

    int answer = 0;
    int j = 0;
    for (int i = 0; i < k; i++)
    {

        // 밀가루를 공급 받을 수 있는 날
        if (dates[j] == i)
        {
            // 큐에 공급 받을 수 있는 양을 추가
            q.push(supplies[j]);

            // 배열의 다음 인덱스 가리키기
            if (j != supplies.size() - 1)
            {
                j++;
            }
        }

        // 밀가루가 다 떨어지면 공급량이 제일 큰 값을 추가
        if (stock == 0)
        {
            stock += q.top();
            q.pop();
            answer++;
        }

        // 하루 지날 때마다 밀가루 양 감소
        stock--;
    }
    return answer;
}