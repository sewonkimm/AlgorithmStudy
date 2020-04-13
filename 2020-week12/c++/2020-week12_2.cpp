#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b)
{
    if (a.first == b.first)
    {
        return a.second < b.second;
    }
    return a.first > b.first;
}

vector<int> solution(vector<string> genres, vector<int> plays)
{

    // 1. 장르별 재생 횟수
    map<string, int> songs;
    for (int i = 0; i < genres.size(); i++)
    {
        songs[genres[i]] += plays[i];
    }

    // 정렬
    vector<pair<int, string>> sortedArr;
    for (auto it = songs.begin(); it != songs.end(); it++)
    {
        sortedArr.push_back(make_pair(it->second, it->first));
    }
    sort(sortedArr.begin(), sortedArr.end(), greater<pair<int, string>>());

    // 2개씩 앨범에 수록
    // 2. 장르 내에서 많이 재생된 횟수
    vector<int> answer;
    for (int i = 0; i < sortedArr.size(); i++)
    {
        string now = sortedArr[i].second;

        vector<pair<int, int>> playCount;
        for (int j = 0; j < genres.size(); j++)
        {
            if (genres[j] == now)
            {
                playCount.push_back(make_pair(plays[j], j));
            }
        }
        sort(playCount.begin(), playCount.end(), cmp);

        if (playCount.size() == 1)
        {
            answer.push_back(playCount[0].second);
        }
        else
        {
            answer.push_back(playCount[0].second);
            answer.push_back(playCount[1].second);
        }
    }

    return answer;
}