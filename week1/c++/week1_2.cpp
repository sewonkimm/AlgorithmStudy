#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit)
{

    // 정렬
    sort(people.begin(), people.end());

    int answer = 0; // 구명보트의 갯수

    int left = 0;
    int right = people.size() - 1;

    while (left <= right)
    {
        if (left == right)
        {
            answer++;
            return answer;
        }

        if (people[left] + people[right] > limit)
        {
            answer++;
            right--;
        }
        else
        {
            answer++;
            left++;
            right--;
        }
    }

    return answer;
}