def contadorDoisEmDois(numero):
    if numero < 0:
        return 0
    print(numero)
    return contadorDoisEmDois(numero -2)

contadorDoisEmDois(10)