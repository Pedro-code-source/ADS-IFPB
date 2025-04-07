notas = [73,67,38,33]
for i in range(len(notas)):
    armazenaValor = notas[i] // 5
    if notas[i] < 38:
        continue
    else:
        if ((armazenaValor +1) * 5) - notas[i] < 3:
            notas[i] = ((armazenaValor +1) * 5)
print(notas)        