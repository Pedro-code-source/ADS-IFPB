#Dupla: Pedro Pereira da Silva e Jhonata Leonardo da Silva
import os

print(f"{"*"*46}\n***** SEJA BEM-VINDO AO CAIXA ELETRÔNICO *****\n{"*"* 46}")
nome = input("Digite seu nome:\n")
cpf = int(input("Digite seu CPF:\n"))
saldo = 1000
nome_pix = []
chaves_cadastradas = []

while True:
    entrada = int(input(f" {"_"*36}\n| Digite o número equivalente para:  |\n| 1- Depositar {" " *22}|\n| 2- Sacar{" " * 27}|\n| 3- Transferir{" " *22}|\n| 4- Cadastrar Pix{" " * 6}Saldo atual: |\n| 5- Chaves Cadastradas{" " *1}{saldo:^12.2f} |\n| 6- Sair{" "*28}|\n {"‾"*36}\n"))  
    match entrada:
        case 1:
            deposito = float(input("Digite o valor que deseja depositar:\n"))
            saldo += deposito   
            print("Depósito feito.") 
                    
        case 2:
            saque = float(input("Digite o valor de saque:\n"))   
            if saque <= saldo and saque > 0:
                saldo -= saque
            else:
                print("Saldo atual abaixo do desejado.")
                
        case 3:
            transferencia = float(input("Qual o valor da transferência?\n"))
            if transferencia <= saldo and transferencia > 0:
                print("Modo de transferência: PIX")
                saldo -= transferencia
                cpf_usuario = int(input("Digite a chave pix:\n"))
                if cpf_usuario in chaves_cadastradas:
                    print("Transferência realizada com Sucesso!")
                else:
                    print("Chave PIX não cadastrada!")                    
            else:
                print("Saldo insuficiente.")     
              
        case 4:
            nome_cadastro = input("Digite o nome do Usuário:\n")
            chave = int(input("Digite a chave pix para concluir o cadastro:\n"))  
            nome_pix.append(nome_cadastro)       
            chaves_cadastradas.append(chave)
            saldo_inicial = 1000
        case 5:
            print(f"{nome_pix}\n{chaves_cadastradas}")            

        case 6:
            break          
        
def limpar():                  
    return os.system("cls")
limpar()
