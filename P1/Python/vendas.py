lista = []
ranger = 0
primeiro = 0
segundo = 0
terceiro = 0
quarto = 0
quinto = 0
sexto = 0
setimo = 0
oitavo = 0
nono = 0
decimo = 0

for j in range(3):
    valorFixo = float(input("Digite o valor fixo do seu salário:\n"))
    totalVendas = float(input("Diga quanto (em R$) você vendeu:\n"))
    valorFinal = valorFixo + (totalVendas * 0.09)
    lista.append(valorFinal)
    
for i in lista:
    armazenaString = str(i)
    for j in armazenaString[0]:
        range = int(j)
        match range:
            case 2:
                primeiro += 1
            case 3:
                segundo += 1
            case 4:
                terceiro += 1
            case 5:
                quarto += 1
            case 6:
                quinto += 1
            case 7:
                sexto += 1
            case 8:
                setimo += 1
            case 9:
                oitavo += 1
            case 10:
                nono += 1                                                        
        
print(f"{primeiro} pessoas receberam 200-299R$")