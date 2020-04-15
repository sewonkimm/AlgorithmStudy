function solution(genres, plays) {
  var answer = [];

  let music = {};

  genres.forEach((genre, index) => {
    if (music.hasOwnProperty(genre)) {
      music[genre].sum += plays[index];
      const temp = { index: index, count: plays[index] };
      music[genre].element.push(temp);
    } else {
      const temp = { index: index, count: plays[index] };
      music[genre] = { sum: plays[index], element: [temp] };
    }
  });

  const sortedGenres = Object.keys(music).sort((a, b) => {
    return music[b].sum - music[a].sum;
  });

  sortedGenres.forEach((genre) => {
    music[genre].element.sort((a, b) => {
      return b.count - a.count;
    });

    music[genre].element.forEach((element, index) => {
      if (index <= 1) answer.push(element.index);
    });
  });

  return answer;
}