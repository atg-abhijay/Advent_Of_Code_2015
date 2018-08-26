import sys
import math

def main():
    a = 60
    # b = 13
    # c = a & b
    # print int('00110010', 2)
    # inputA = int('0101',2)
    # print "Before shifting " + str(inputA) + " " + bin(inputA)
    # print "After shifting in binary: " + bin(inputA << 1)
    # print "After shifting in decimal: " + str(inputA << 1)
    # binA = bin(inputA)
    # binA = bin(2*inputA)
    # print binA
    # print(type(binA))

def test():
    x = 123
    y = 456
    d = x & y
    e = x | y
    f = x << 2
    print(d)
    print(e)
    print(f)

def convert_to_binary(number):
    temp = math.log(number, 2)
    size = int(math.floor(temp+1))
    # print size
    binary_rep = [None] * size
    counter = 1
    while number != 0:
        binary_rep[size-counter] = number % 2
        number = number/2
        counter += 1

    print(binary_rep)

test()
