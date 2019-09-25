#include <vector>
using namespace std;

int visit[200001];
int solution(vector<int> nums)
{
    int n = nums.size();

    int count = 0;
    int index = 0;
    while (count < n / 2 && index < n)
    {
        if (visit[nums[index]] == 0)
        {
            visit[nums[index]] = 1;
            count++;
        }
        index++;
    }

    return count;
}