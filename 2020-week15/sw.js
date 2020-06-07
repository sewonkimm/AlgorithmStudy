class Node {
  constructor() {
    this.count = 0;
    this.child = {};
  }
}

class Trie {
  constructor(word) {
    this.root = new Node();
  }

  // Trie에 삽입
  insert(string) {
    let currentNode = this.root;

    for (let i = 0; i < string.length; i++) {
      const currentChar = string[i];

      if (currentNode.child[currentChar] === undefined) {
        currentNode.child[currentChar] = new Node();
      }

      currentNode.count += 1;
      currentNode = currentNode.child[currentChar];
    }
  }

  // 검색
  search(string) {
    let currentNode = this.root;

    for (let i = 0; i < string.length; i++) {
      const currentChar = string[i];

      if (currentChar === "?") {
        break;
      }

      if (currentNode.child[currentChar] !== undefined) {
        currentNode = currentNode.child[currentChar];
      } else {
        return 0;
      }
    }
    return currentNode.count;
  }
}

function solution(words, queries) {
  const answer = [];

  const trie = {};
  const reverseTrie = {};

  // trie 생성
  words.forEach((word) => {
    if (trie[word.length] === undefined) {
      trie[word.length] = new Trie();
      reverseTrie[word.length] = new Trie();
    }

    trie[word.length].insert(word);
    reverseTrie[word.length].insert(word.split("").reverse().join(""));
  });

  // queries 탐색
  queries.forEach((query) => {
    // 접두사일 때 => trie 탐색
    if (query[0] === "?") {
      if (reverseTrie[query.length] === undefined) {
        answer.push(0);
      } else {
        answer.push(
          reverseTrie[query.length].search(query.split("").reverse().join(""))
        );
      }
    }
    // 접미사일 때 => reverseTrie 탐색
    else {
      if (trie[query.length] === undefined) {
        answer.push(0);
      } else {
        answer.push(trie[query.length].search(query));
      }
    }
  });

  return answer;
}

const words = ["frodo", "front", "frost", "frozen", "frame", "kakao"];
const queries = ["fro??", "????o", "fr???", "fro???", "pro?"];
console.log(solution(words, queries));
