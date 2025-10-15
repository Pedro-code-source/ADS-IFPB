def somaDosDigitos(numero):
    if numero == 0:
        return 0
    
    return (numero % 10) + somaDosDigitos(numero // 10)

print(somaDosDigitos(55555))