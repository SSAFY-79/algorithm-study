def solution(gems):
    answer = []
    gemset = set(gems)
    kinds = len(gemset)
    gemdict = {}
    start, end = 0, 0
    minVal = 100001
    while (end < len(gems)):
        if(gems[end] not in gemdict):
            gemdict[gems[end]] = 1
        else:
            gemdict[gems[end]] += 1
        if(len(gemdict) == kinds):
            while (gemdict[gems[start]] > 1):
                gemdict[gems[start]] -= 1
                start+=1
            if(minVal > end-start):
                answer = [start+1, end+1]
                minVal = end-start
        end+=1
    return answer