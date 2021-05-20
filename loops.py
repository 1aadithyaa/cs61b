a = 17

b = 29

if a < 0:
    a = -1 * a
if b < 0:
    b = -1 * b

while b > 0:
    while b <= a:
        a = a - b
    c = a
    a = b
    b = c


print(a)
