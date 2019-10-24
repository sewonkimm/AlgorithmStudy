#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// d[i][j] = 왼쪽이 i, 오른쪽이 j 일때 최대 점수값
int d[2001][2001];

int size;
vector<int> L;
vector<int> R;

int go(int i, int j)
{
    // 종료 검사
    if (i == size || j == size)
    {
        return 0;
    }

    // memoization
    if (d[i][j] > 0)
    {
        return d[i][j];
    }

    d[i][j] = max(go(i + 1, j + 1), go(i + 1, j));

    if (R[j] < L[i])
    {
        d[i][j] = max(d[i][j], go(i, j + 1) + R[j]);
    }

    return d[i][j];
}

int solution(vector<int> left, vector<int> right)
{

    size = left.size();
    L = left;
    R = right;

    return go(0, 0);
}