// Trie 구현은 해당 블로그를 참고하였습니다.
// https://velog.io/@teihong93/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-Trie-%EA%B5%AC%ED%98%84

class Node {
  constructor() {
    this.count = 0;
    this.children = {};
  }
}

class Trie {
  constructor() {
    this.root = new Node();
  }

  insert(string) {
    let currentNode = this.root;

    for (let i = 0; i < string.length; i++) {
      const currentChar = string[i];

      if (!currentNode.children.hasOwnProperty(currentChar)) {
        currentNode.children[currentChar] = new Node();
      }

      currentNode.count += 1;

      currentNode = currentNode.children[currentChar];
    }
  }

  searchCount(string) {
    let currentNode = this.root;
    let checkLength = 0;
    for (let i = 0; i < string.length; i++) {
      const currentChar = string[i];
      if (currentChar === "?") {
        checkLength = string.length - i;
        break;
      }
      if (currentNode.children[currentChar]) {
        currentNode = currentNode.children[currentChar];
      } else return 0;
    }

    return currentNode.count;
  }
}

function solution(words, queries) {
  var answer = [];

  const trie = {};
  const inverseTrie = {};

  words.forEach((word) => {
    const len = word.length;

    if (!trie.hasOwnProperty(len)) {
      trie[len] = new Trie();
    }
    trie[len].insert(word);

    if (!inverseTrie.hasOwnProperty(len)) {
      inverseTrie[len] = new Trie();
    }
    inverseTrie[len].insert(word.split("").reverse().join(""));
  });

  queries.forEach((query) => {
    const len = query.length;
    if (query[0] !== "?") {
      if (!trie.hasOwnProperty(len)) answer.push(0);
      else answer.push(trie[len].searchCount(query) || 0);
    } else {
      if (!inverseTrie.hasOwnProperty(len)) answer.push(0);
      else
        answer.push(
          inverseTrie[len].searchCount(query.split("").reverse().join("") || 0)
        );
    }
  });

  return answer;
}