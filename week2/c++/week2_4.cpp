#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// mininum cost sapanning tree 만들기
// kruskal algorithm

// d[i] = 노드 i의 부모 노드를 가리킨다.
int d[101];

// 최상위 노드를 찾는 함수 (Union-find)
int getParent(int node)
{
    if (node == d[node])
    {
        return node;
    }
    else
        return d[node] = getParent(d[node]);
}

// 간선의 가중치를 기준으로 오름차순 정렬
bool cmp(const vector<int> &a, const vector<int> &b)
{
    return a[2] < b[2];
}

int solution(int n, vector<vector<int>> costs)
{
    int answer = 0;

    for (int i = 0; i < n; i++)
    {
        d[i] = i;
    }

    // 1. 간선의 가중치를 기준으로 오름차순으로 정렬(krustal 2)
    sort(costs.begin(), costs.end(), cmp);

    // 2. 모든 간선을 검사
    for (int i = 0; i < costs.size(); i++)
    {
        int start = getParent(costs[i][0]);
        int end = getParent(costs[i][1]);
        int cost = costs[i][2];

        // start와 end가 아직 연결되지 않았을 때
        if (start != end)
        {
            // start를 end의 parent로 설정
            d[start] = end;

            // 간선 가중치 값 더해주기
            answer += cost;
        }
    }

    return answer;
}