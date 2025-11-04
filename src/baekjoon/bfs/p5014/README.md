# 적록색약 (5014)

## 🔍 문제 정보

- **출처:** [https://www.acmicpc.net/problem/5014](https://www.acmicpc.net/problem/5014)
- **알고리즘 태그:** #BFS #너비_우선_탐색

## 💡 접근 방법
floor int 배열로 만들어서 방문처리 + 횟수계산 한번에 진행
(⭐핵심) 각각 조건에 맞춰서 큐에 넣는다 (continue로 예외처리대신)
.

## ❗️ 배운 점 / 어려웠던 점
- visited 배열없이 grid 배열만으로 방문처리를 함께 하려고 했다가 수정함(grid를 바꿔버리면 다음 bfs에 영향감)