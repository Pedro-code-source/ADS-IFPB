lista = []
n = int(input("Quantos valores deseja adicionar à lista?\n")) 
cont = 0
for j in range(n):
    cont += 1
    var = int(input(f"Digite o {cont}° valor: "))
    lista.append(var)
    lista.sort()
print(lista)
def limite(LI, LS, lista):
    sublist = []
    for i in lista:
        if LI <= i <= LS:
            sublist.append(i)
    print(sublist)        
    
LI = int(input("Insira o limite inferior da lista: ")) 
LS = int(input("Agora, o superior: "))   
limite(LI, LS, lista)        
    