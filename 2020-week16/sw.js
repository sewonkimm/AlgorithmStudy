// 정확성 통과 & 효율성 실패

function findNext(food_tiems, turn) {
  for (let i = 0; i < food_tiems.length; i++) {
    if (food_tiems[turn] !== 0) {
      return turn;
    }

    turn += 1;
    turn %= food_tiems.length;
  }

  return -1;
}

function solution(food_times, k) {
  let turn = 0;

  for (let i = 0; i < k; i++) {
    // 1. 현재 turn이 0인지 아닌지 확인
    // 2. 0이 아니면 현재 turn 식사후 다음 음식 탐색
    // 3. 0이면 다음 음식 탐색 후 식사

    if (food_times[turn] !== 0) {
      food_times[turn] -= 1;
      turn = findNext(food_times, (turn + 1) % food_times.length);
    } else {
      turn = findNext(food_times, (turn + 1) % food_times.length);

      // 더 이상 먹을 음식이 없는 경우
      if (turn === -1) {
        return -1;
      }
      // 먹을 음식이 있는 경우
      food_times[turn] -= 1;
    }
  }

  let answer = findNext(food_times, turn);
  if (answer !== -1) {
    return answer + 1;
  }
  return answer;
}
