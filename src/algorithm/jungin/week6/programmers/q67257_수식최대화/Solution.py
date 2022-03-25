import itertools
import copy
def solution(expression):
    answer = 0
    numList = []
    opList = []
    start, end = 0, 0
    op = []
    index = 1
    for i in range(len(expression)):
        if(expression[i] == '+' or expression[i] == '-' or expression[i] == '*' or expression[i] == '/'):
            numList.append(expression[start:i])
            opList.append(expression[i])
            start=i+1
            index+=1
    numList.append(expression[start:])

    if('+' in opList): op.append('+')
    if('-' in opList): op.append('-')
    if('*' in opList): op.append('*')
    if('/' in opList): op.append('/')
    
    comb = itertools.permutations(op, len(op))
    list = []
    
    for case in comb:
        cnt = 0
        numCopy = copy.deepcopy(numList)
        opCopy = copy.deepcopy(opList)
        for i in case:
            index = 0
            for j in range(len(opCopy)):
                if(i == '+' and opCopy[j-index] == i):
                    tmp = int(numCopy[j-index]) + int(numCopy[j-index+1])
                    cnt += tmp
                    numCopy.insert(j-index, tmp)
                    del numCopy[j-index+1:j-index+3]
                    del opCopy[j-index]
                    index+=1
                elif(i == '-' and opCopy[j-index] == i):
                    tmp = int(numCopy[j-index]) - int(numCopy[j-index+1])
                    cnt += tmp
                    numCopy.insert(j-index, tmp)
                    del numCopy[j-index+1:j-index+3]
                    del opCopy[j-index]
                    index+=1
                elif(i == '*' and opCopy[j-index] == i):
                    tmp = int(numCopy[j-index]) * int(numCopy[j-index+1])
                    cnt += tmp
                    numCopy.insert(j-index, tmp)
                    del numCopy[j-index+1:j-index+3]
                    del opCopy[j-index]
                    index+=1
                elif(i == '/' and opCopy[j-index] == i):
                    tmp = int(numCopy[j-index]) / int(numCopy[j-index+1])
                    cnt += tmp
                    numCopy.insert(j-index, tmp)
                    del numCopy[j-index+1:j-index+3]
                    del opCopy[j-index]
                    index+=1
        answer = max(answer, abs(numCopy[0]))
            
    return answer