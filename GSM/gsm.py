import random


random.seed(0)

def get_left_right(n):
    s = bin(n)[2:]
    x = int(len(s)/2)
    return int(s[:x], 2), int(s[x:], 2)

def A3_8(key, rand):
    left_key, right_key = get_left_right(key)
    left_rand, right_rand = get_left_right(rand)

    lhs_xored = left_rand ^ right_key
    rhs_xored = right_rand ^ left_key

    final = lhs_xored ^ rhs_xored

    left, right = get_left_right(final)

    return int(bin(final)[2:][:56], 2), left ^ right

def main():
    key = random.getrandbits(128)
    rand = random.getrandbits(128)
    kc, sres = A3_8(key, rand)
    print(f'Signed Response: {sres} and Session Key: {kc}')

if __name__ == '__main__':
    main()

'''
almond milk, tart cherry juice, banana, whole 1 egg (with shells), 
'''