# 적록색약 (10026)

## 🔍 문제 정보

- **출처:** [https://www.acmicpc.net/problem/10026](https://www.acmicpc.net/problem/10026)
- **알고리즘 태그:** #BFS #너비_우선_탐색 

## 💡 접근 방법

visited 배열을 만들어 적록색약일 경우와 그렇지 않은 경우 각각 visited를 초기화하여 계산하고, 적록색약인 경우 grid배열에서 G를 R로 바꿔 계산.

(⭐핵심) visited를 초기화해서 main함수에서 색약일 경우와 아닌경우를 각각 구분한다.
.

## ❗️ 배운 점 / 어려웠던 점
- visited 배열없이 grid 배열만으로 방문처리를 함께 하려고 했다가 수정함(grid를 바꿔버리면 다음 bfs에 영향감)