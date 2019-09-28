#include <iostream>
#include <deque>
#include <vector>

using namespace std;

int getFunc2(deque<int> dq, int x) {
	int count = 0;
	int first = dq.front();

	while (first != x) {
		dq.pop_front();
		dq.push_back(first);
		count++;

		first = dq.front();
	}

	return count;
}

int getFunc3(deque<int> dq, int x) {
	int count = 0;
	int first = dq.front();

	while (first != x) {
		int temp = dq.back();
		dq.pop_back();
		dq.push_front(temp);
		count++;

		first = dq.front();
	}

	return count;
}

int main(void) {
	int n, m;
	cin >> n >> m;

	vector<int> list;
	for (int i = 0; i<m; i++) {
		int num;
		cin >> num;
		list.push_back(num);
	}

	deque<int> dq;
	for (int i = 1; i<=n; i++) {
		dq.push_back(i);
	}

	int index = 0;
	int count = 0;
	while (index < list.size()) {
		int first = dq.front();
		if (first == list[index]) {
			dq.pop_front();
			index++;
			continue;
		}

		// 2번 연산, 3번 연산 횟수 구하기
		int f2, f3;
		f2 = getFunc2(dq, list[index]);
		f3 = getFunc3(dq, list[index]);

		// 둘 중 최소 연산 선택
		if (f2 <= f3) {
			count += f2;
			for (int i = 0; i<f2; i++) {
				int first = dq.front();
				dq.pop_front();
				dq.push_back(first);
			}
		}
		else {
			count += f3;
			for (int i = 0; i<f3; i++) {
				int last = dq.back();
				dq.pop_back();
				dq.push_front(last);
			}
		}
	}

	cout << count << endl;
	return 0;
}