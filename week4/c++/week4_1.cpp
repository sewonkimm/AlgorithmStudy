#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int k;
	cin >> k;

	vector<int> rope(k, 0);
	for (int i = 0; i < k; i++) {
		cin >> rope[i];
	}
	sort(rope.begin(), rope.end());

	int index = 0;
	int w = 0;
	for (int i = k; i > 0; i--) {
		int temp = rope[k - i] * i;
		w = max(w, temp);
	}

	cout << w << endl;
	return 0;
}