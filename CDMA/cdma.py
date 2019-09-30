def inner_product(a, b):
    return sum(map(lambda x, y: x*y, a, b))

if __name__ == '__main__':
    a = list(map(int, input('Enter vector a: ').strip().split()))
    b = list(map(int, input('Enter vector b: ').strip().split()))

    print(f'Autocorrelation of a: {inner_product(a, a)}')
    print(f'Autocorrelation of b: {inner_product(b, b)}')
    print(f'Orthogonality: {inner_product(a, b)}')