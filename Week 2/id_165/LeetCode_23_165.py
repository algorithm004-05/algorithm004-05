class Solution(object):

    def __init__(self):

        self.pn = {'2': 'abc',
                   '3': 'def',
                   '4': 'ghi',
                   '5': 'jkl',
                   '6': 'mno',
                   '7': 'pqrs',
                   '8': 'tuv',
                   '9': 'wxyz'
                   }
        self.cur = ''
        self.res = []
        self.size = 0
        self.digits = None

    def letterSelect(self, digit_idx):
        if len(self.cur) == self.size:
            self.res.append(self.cur)
            return

        for letter in self.pn[self.digits[digit_idx]]:
            self.cur = self.cur + letter
            self.letterSelect(digit_idx + 1)
            self.cur = self.cur[0:-1]

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        self.size = len(digits)
        if not self.size:
            return []
        self.digits = digits
        self.letterSelect(0)

        return self.res
