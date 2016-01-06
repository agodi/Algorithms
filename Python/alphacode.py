def alpha_count(memo, code):
    if code in memo:
        return memo[code]
    else:
        memo[code] = is_valid(code[:1]) * alpha_count(memo, code[1:]) + \
        is_valid(code[:2]) * alpha_count(memo, code[2:])
        return memo[code]


def is_valid(code):
    if code[0] != '0' and int(code) > 0 and int(code) < 27:
        return 1
    return 0

dp_table = {}
dp_table[''] = 1
dp_table['0'] = 0
dp_table['1'] = 1
dp_table['2'] = 1
dp_table['3'] = 1
dp_table['4'] = 1
dp_table['5'] = 1
dp_table['6'] = 1
dp_table['7'] = 1
dp_table['8'] = 1
dp_table['9'] = 1


print((alpha_count(dp_table, '1111')))# - 5
print((alpha_count(dp_table, '25144')))# - 4
print((alpha_count(dp_table, '2262')))# - 3
print((alpha_count(dp_table, '22621')))# - 6
print((alpha_count(dp_table, '226210')))# - 3
print((alpha_count(dp_table, '2203')))# - 1
print((alpha_count(dp_table, '2020')))# - 1
print((alpha_count(dp_table, '2022')))# - 2
print((alpha_count(dp_table, '136517')))# - 4