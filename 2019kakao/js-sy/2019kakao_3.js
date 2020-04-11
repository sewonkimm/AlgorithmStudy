function solution(s) {
  const answer = [];

  let str = s.split("{").join("[");
  str = str.split("}").join("]");
  str = JSON.parse(str);

  for (let i = 1; i <= str.length; i++) {
    for (let j = 0; j < str.length; j++) {
      if (i == str[j].length) {
        for (let k = 0; k < str[j].length; k++) {
          if (!answer.includes(str[j][k])) {
            answer.push(str[j][k]);
            break;
          }
          if (k == str[j].length - 1) {
            answer.push(str[j][k]);
          }
        }
      }
    }
  }

  console.log(answer);
  return answer;
}