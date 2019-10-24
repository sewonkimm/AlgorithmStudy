#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K)
{
    int answer = 0;

    // min heap
    priority_queue<int, vector<int>, greater<int>> pq(scoville.begin(), scoville.end());

    // 모든 지수가 K를 넘는지 확인하려면 top만 K를 넘는지 확인하면 된다.
    while (pq.top() < K)
    {

        // 모든 지수를 K이상으로 만들 수 없는 경우
        if (pq.size() == 1)
        {
            answer = -1;
            return answer;
        }

        // 첫번째로 작은 지수
        int low = pq.top();
        pq.pop();
        // 두번째로 작은 지수
        int lowlow = pq.top();
        pq.pop();

        int newScoville = low + (lowlow * 2);
        pq.push(newScoville);
        answer++;
    }

    return answer;
}