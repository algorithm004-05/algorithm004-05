class Solution(object):
    def isAnagram(self, s, t):
        sd, td = {}, {}

        for n in s:
            sd[n] = sd.get(n, 0) + 1
        for n in t:
            td[n] = td.get(n, 0) + 1
        return sd == td