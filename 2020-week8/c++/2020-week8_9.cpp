#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// sort
int comp(const pair<int, int> &n1, const pair<int, int> &n2)
{
    return n1.second > n2.second;
}

int main(int argc, char **argv)
{

    // 숫자 입력
    int n;
    scanf("%d", &n);

    vector<int> num(n + 1, 0);
    vector<pair<int, int>> nums;
    for (int i = 1; i <= n; i++)
    {
        scanf("%d", &num[i]);

        nums.push_back(make_pair(i, num[i]));
    }

    // nums 두번째 값 기준으로 정렬
    sort(nums.begin(), nums.end(), comp);

    // 질문 입력
    int m;
    scanf("%d", &m);

    vector<int> ans;
    while (m--)
    {
        int a, b;
        scanf("%d %d", &a, &b);

        // nums 탐색
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i].first >= a && nums[i].first <= b)
            {
                ans.push_back(nums[i].second);
                break;
            }
        }
    }

    for (int i = 0; i < ans.size(); i++)
    {
        printf("%d ", ans[i]);
    }

    return 0;
}