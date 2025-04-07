while True:
    base = float(input("Informe o valor base da indenização por um plano de saúde: "))
    idade = int(input("Informe a idade do paciente: "))
    nome = input("Diga o nome completo do paciente: ")
  
    if idade <= 12:
        base += (base * 0.3)
    elif idade <= 49:
        base += (base * 0.1)
    elif idade <= 65:
        base += (base * 0.15)
    elif idade > 65:
        base += (base * 0.35)     
    print("*" *30)    
    print(f"Nome: {nome}\nIdade: {idade}\nNovo valor pós Reajuste: {base}")
    print("*" *30)                
    cont = input("Deseja continuar o cadastro de novas pessoas? sim ou não: ")
    if cont == "sim":
        continue
    elif cont == "não":
        break
    break
