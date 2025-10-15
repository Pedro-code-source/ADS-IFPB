import random

lista = [-1,0,3,5,9,12]
k = int(input("Qual valor está procurando?"))
print()
inicio = 0
fim = len(lista)

while inicio != fim:
    
    meio = (inicio + fim) // 2
    
    if lista[meio] == k:
        print(f"O valor {k} está na posição {meio}")
        break
    elif lista[meio] < k:
        inicio = meio +1
    elif lista[meio] > k:
        fim = meio -1
