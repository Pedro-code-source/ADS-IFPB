import random

def busca(k,n):
    a = []
    cont = 0
    for b in range(1, n+1):
        a.append(random.randint(1,100))
    print(a)
    for j in a:
        cont += 1
        if j == k:
            print(f"O número {k} está na posição {cont}")
            break
        else:
            continue
        
    
busca(15,5)    