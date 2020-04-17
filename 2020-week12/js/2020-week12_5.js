function solution(budgets, M) {
  let left = 0;
  let right = M;

  let max = 0;
  let sum = 0;
  for (let i = 0; i < budgets.length; i++) {
    sum += budgets[i];
    max = Math.max(max, budgets[i]);
  }

  if (sum <= M) return max;

  while (left <= right) {
    let mid = Math.floor((left + right) / 2);

    let sum = 0;
    for (let i = 0; i < budgets.length; i++) {
      if (budgets[i] <= mid) sum += budgets[i];
      else sum += mid;
    }

    if (sum <= M) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return right;
}