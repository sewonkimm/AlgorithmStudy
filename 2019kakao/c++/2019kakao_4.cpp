// 정확성 통과, 효율성 실패

#include <string>
#include <vector>
#include <map>

using namespace std;

map<long, long> m;

long long find(long long x)
{
    if (!m[x])
    {
        return x;
    }
    return find(m[x]);
}
vector<long long> solution(long long k, vector<long long> room_number)
{
    vector<long long> answer;

    for (int num : room_number)
    {

        // 빈 방 있는 경우 즉시 방 배정
        if (!m[num])
        {
            answer.push_back(num);
            m[num] = find(num + 1);
        }
        // 빈 방이 없는 경우
        else
        {
            long long temp = find(num);
            answer.push_back(temp);
            m[temp] = temp + 1;
        }
    }
    return answer;
}