def reversao(nome):
    contador = len(nome) -1
    if contador < 0:
        return ""
    contador -= 1
    return nome[contador+1] + reversao(nome)

print(reversao("Pedro"))
