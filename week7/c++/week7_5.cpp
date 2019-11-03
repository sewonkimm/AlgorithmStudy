#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int T;
    cin >> T;
    for (int test_case = 1; test_case <= T; test_case++)
    {
        // 입력
        int N, B;
        cin >> N >> B;

        vector<int> H(N);
        for (int i = 0; i < N; i++)
        {
            cin >> H[i];
        }

        int ans = 1000000000;

        // N명중 k명 뽑아서 탑 만들기
        for (int k = 1; k <= N; k++)
        {
            // 1. 0과 1을 넣을 조합
            vector<int> com(N, 0);

            // 2. 0을 k번 넣기
            for (int i = 0; i < k; i++)
            {
                com[i] = 1;
            }

            // 3. 정렬
            sort(com.begin(), com.end());

            // 4. 모든 조합 경우의 수 뽑기
            do
            {
                int top = 0;
                for (int j = 0; j < N; j++)
                {
                    if (com[j] == 1)
                    {
                        top += H[j];
                    }
                }

                // B이상인 최솟값 찾기
                if (top >= B)
                {
                    ans = min(ans, top);
                }
            } while (next_permutation(com.begin(), com.end()));
        }

        cout << "#" << test_case << " ";
        cout << ans - B << endl;
    }
    return 0;
}