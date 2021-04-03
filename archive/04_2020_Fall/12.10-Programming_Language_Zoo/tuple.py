print("Hello, World!")

def factorial(i):
    if i <= 0:
        return 1
    return i * factorial(i - 1)

print(factorial(5))     # 120

try:
    print(factorial("ASDF"))
except Exception as e:
    print(e)

class myPair:
    # python style is to use double underscore __
    # to indicate a special function
    def __init__(self, left, right):
        self._left = left
        self._right = right
    
    # self parameter is explicit
    def getLeft(self):
        return self._left

    def getRight(self):
        return self._right

pair = myPair(5, 10)
print("{},{}".format(pair.getLeft(), pair.getRight()))

# python be python
# private variables? nah
pair._left = 99
print("{},{}".format(pair.getLeft(), pair.getRight()))

myTuple = (5, 10, 15, 20)
print(myTuple)

try:
    myTuple[0] = 5
except Exception as e:
    print(e)

myList = list(myTuple)
myList[0] = 99
print(myList)   # [99, 10, 15, 20]
print(myTuple)  # [5, 10, 15, 20]

someTuples = ((1, 2), (3, 4), (5, 6), (1, 2))
mySet = set(someTuples)
print(mySet)    # {(1, 2), (3, 4), (5, 6)}

# fun python features
def stars(count):
    for i in range(count):
        print("*" * i)

stars(10)

myList = [5, 10, 15, 20, 25]
print(myList[-1])
print(myList[:2])
print(myList[1:3])

myVector = (((1, 2), (3, 4), (5, 6)),
            ((7, 8), (9, 8), (7, 6)),
            ((5, 4), (3, 2), (1, 0)))
print(myVector)