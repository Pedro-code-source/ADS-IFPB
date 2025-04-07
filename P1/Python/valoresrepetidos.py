n = int(input("Quantos valores quer adicionar à lista?\n"))
lista = []
for i in range(n):
    number = int(input("Digite o valor que deseja adicionar à lista: "))
    lista.append(number)

def reps(lista):
    repetidos = []
    for i in lista:
        if lista.count(i) > 1:
            repetidos.append(i) 
                  
    print(f"Esses são os valores que se repetem: {set(repetidos)}")
reps(lista)    
