def soma(a, b):
    soma = a + b
    print(soma)
def sub(a, b):
    sub = a - b
    print(sub)
def mult(a, b):
    mult = a * b
    print(mult)
def div(a, b):
    div = a / b
    print(div)
                
while True:
    print("*" * 20)
    op = int(input("Digite um número para realizar a operação:\n1 - Soma\n2 - Subtração\n3 - Multiplicação\n4 - Divisão\n5 - Sair\n"))
    print("*" * 20)
    match op:
        case 1:
            a = float(input("Digite o primeiro valor: "))
            b = float(input("Digite o segundo valor: "))
            soma(a, b)   
        case 2:
            a = float(input("Digite o primeiro valor: "))
            b = float(input("Digite o segundo valor: "))
            sub(a, b) 
        case 3:
            a = float(input("Digite o primeiro valor: "))
            b = float(input("Digite o segundo valor: "))
            mult(a, b)   
        case 4:
            a = float(input("Digite o primeiro valor: "))
            b = float(input("Digite o segundo valor: "))
            div(a, b)  
        case 5:
            break     
        case _:
            continue                
