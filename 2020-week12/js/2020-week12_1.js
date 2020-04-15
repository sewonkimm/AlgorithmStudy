function solution(clothes) {
  var answer = 1;

  let closet = {};
  clothes.forEach((element) => {
    if (closet.hasOwnProperty(element[1])) {
      closet[element[1]].push(element[0]);
    } else {
      closet[element[1]] = [element[0]];
    }
  });

  const keys = Object.keys(closet);

  if (keys.length === 1) answer = closet[clothes[0][1]].length;
  else {
    keys.forEach((key) => {
      answer *= closet[key].length + 1;
    });
    answer -= 1;
  }

  return answer;
}
