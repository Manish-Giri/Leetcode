class Solution:
    def isHappy(self, n):
        l = []
        while True:
            if n == 1:
                return True
            else:
                tsum = 0
                while n > 0:
                    tsum += (n%10)*(n%10)
                    n = n // 10
                if tsum in l:
                    return False
                l.append(tsum)
                n = tsum

"""
Runtime: 36 ms, faster than 34.48% of Python3 online submissions for Happy Number.
Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Happy Number.
"""