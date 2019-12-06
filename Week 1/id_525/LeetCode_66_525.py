from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        digits = ''.join(map(str, digits))
        return list(map(int, str(int(digits)+1)))