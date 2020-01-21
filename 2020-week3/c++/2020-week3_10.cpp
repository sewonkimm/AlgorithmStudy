#include <iostream>
#include <vector>
#include <tuple>
#include <string>
#include <algorithm>

using namespace std;

int main(int argc, char **argv)
{
    int n;
    scanf("%d", &n);

    vector<tuple<int, int, string>> cus;

    for (int i = 0; i < n; i++)
    {
        int age;
        string name;
        scanf("%d", &age);
        cin >> name;
        cus.push_back(make_tuple(age, i, name));
    }

    sort(cus.begin(), cus.end());
    for (int i = 0; i < n; i++)
    {
        cout << get<0>(cus[i]) << " " << get<2>(cus[i]) << "\n";
    }
    return 0;
}