# Claire Jaja
# 11/4/2014
#
# Project Euler
# Problem 5
# Smallest multiple
#
# 2520 is the smallest number that can be divided by each of the numbers
# from 1 to 10 without any remainder.
# What is the smalelst positive number that is evenly divisible
# by all the numbers from 1 to 20?

def main():
    smallest_multiple_found = False
    current_num = 2520
    while not smallest_multiple_found:
        if is_evenly_divisible_to_twenty(current_num):
            smallest_multiple_found = True
            print(current_num)
        else:
            current_num += 20

def is_evenly_divisible_to_twenty(x):
    for i in range(20,0,-1):
        if x % i != 0:
            return False
    return True

if __name__ == "__main__":
    main()
