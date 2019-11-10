
class Solution:
    def myPow(self, x: float, n: int) -> float:
        pow = 1
        if n < 0:
            x = 1/x
            for i in range(abs(n)):
                pow = pow * x
            return pow
        elif n == 0:
            return pow
        else:
            for i in range(n):
                pow = pow * x
            return pow

class Solution:
    def fastPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n%2 == 0:
            return self.fastPow(x * x, n//2)
        else:
            return self.fastPow(x * x, n//2)*x

    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n = -n
        return self.fastPow(x, n)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        judge = True
        if n < 0:
            n = -n
            judge = False
        final = 1
        while n > 0:
            if n % 2==0:
                x *= x
                n //= 2
            final *= x
            n -= 1
        return final if judge else 1/final