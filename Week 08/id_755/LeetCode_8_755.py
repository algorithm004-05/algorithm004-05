class Solution:
    def myAtoi(self, str: str) -> int:
        space_removed = str.lstrip()
        if not space_removed:
            return 0
        
        sign = 1
        start_index = 0
        start_char = space_removed[start_index]
        
        if start_char == "-":
            sign = -1
            start_index = 1
        elif start_char == "+":
            sign = 1
            start_index = 1
        if start_index >= len(space_removed):
            return 0
        if not space_removed[start_index].isnumeric():
            return 0
        value = 0
        for char in space_removed[start_index:]:
            if not char.isnumeric():
                break
            else:
                value = value * 10 + int(char)
        if sign * value < -1 * 2**31:
            return -1 * 2**31
        if sign * value > 2 ** 31 - 1:
            return 2 ** 31 - 1
        return sign * value
