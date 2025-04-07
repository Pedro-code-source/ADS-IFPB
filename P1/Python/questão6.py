linhas = 2
colunas = 2
matriz = []
au = 1
for i in range(linhas):
    linha = [au] * colunas
    matriz.append(linha)
    au += 1

for j in matriz:
    print(j)    
    
matriz[0] = 5
matriz[1] = 4
matriz[2] = 7
matriz[3] = 9
print(matriz)
for j in matriz:
    print(j)   




# linhas = int(input("Digite o numero de linhas que sua matriz terá:\n"))
# colunas = int(input("Digite o número de colunas que sua matriz terá:\n"))
# matriz = []
# cont = 0
# for i in range(linhas * colunas):
#     cont += 1
#     valores = int(input(f"Digite o {cont}° valor da matriz:\n"))
#     matriz.append(valores)
# for j in matriz:
#     print(j)    
    