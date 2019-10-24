#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool isPrime(int num)
{
    if (num < 2)
    {
        return false;
    }

    for (int i = 2; i * i <= num; i++)
    {
        if (num % i == 0)
        {
            return false;
        }
    }

    return true;
}

bool isNumber(int num, vector<int> arr)
{

    string n = to_string(num);
    vector<int> m;
    for (int i = 0; i < n.size(); i++)
    {
        m.push_back(n[i] - '0');
    }

    bool check;
    for (int i = 0; i < m.size(); i++)
    {
        check = false;

        for (int j = 0; j < arr.size(); j++)
        {
            if (m[i] == arr[j])
            {
                check = true;
                arr[j] = -1;
                break;
            }
        }

        if (check == false)
        {
            return false;
        }
    }

    return check;
}

int solution(string numbers)
{

    string max;
    max = numbers;
    sort(max.begin(), max.end(), greater<int>());

    int answer = 0;

    vector<int> n;
    for (int i = 0; i < numbers.size(); i++)
    {
        n.push_back(numbers[i] - '0');
    }

    for (int i = 2; i <= stoi(max); i++)
    {
        if (isPrime(i))
        {
            if (isNumber(i, n))
            {
                answer++;
            }
        }
    }

    return answer;
}