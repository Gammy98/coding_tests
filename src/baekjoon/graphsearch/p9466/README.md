# 텀 프로젝트 (9466)

## 🔍 문제 정보

- **출처:** [https://www.acmicpc.net/problem/9466](https://www.acmicpc.net/problem/9466)
- **알고리즘 태그:** #DFS #재귀

## 💡 접근 방법
- visited[] : 방문중이거나 방문이 완료됨을 표시
- finished[] : 해당 노드에서 시작된 모든 탐색이 완전히 종료됨을 표시(사이클 확인용)
- vistied == true && finished == false : 현재 dfs 경로상의 노드 (이 노드 만나면 사이클 인)
- vistied == true && finished == true : 이미 검사가 끝난 노드

(⭐핵심) 재귀를 활용한 dfs로 순환구조 파악이 핵심
.

## ❗️ 배운 점 / 어려웠던 점
- 자식이 하나인 경우이기 때문에 dfs bfs의 개념을 헷갈렸으나 이런경우 자료구조 빼곤는 dfs bfs모두 동일
- 자료구조에서 재귀가 유리함(지나온 순환구조를 모두 알아야하기때문에 큐는 불리)
- finished 배열을 하나 더 두어서 방문처리에 그치는것이 아니라 순환구조 끝처리도 해주는것이 중요