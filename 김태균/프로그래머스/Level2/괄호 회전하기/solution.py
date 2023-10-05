def solution(s):
    answer = -1
    cnt = 0
    for i in range(len(s)):
        tmp = s[i:]+s[:i]
        stack = []
        for j in tmp:
            if len(stack) == 0:
                stack.append(j)
            else:
                if stack[-1] == '{' and j == '}':
                    stack.pop()
                elif stack[-1] == '(' and j == ')':
                    stack.pop()
                elif stack[-1] == '[' and j == ']':
                    stack.pop()
                else:
                    stack.append(j)
        if len(stack) == 0:
            cnt += 1

    return cnt
