import random
import os

vencedor = None
PontosMaquina = 0
PontosUsuario = 0

def clear():
    return os.system("cls")
while PontosMaquina < 3 and PontosUsuario < 3:   
    opcoes = ["pedra","papel","tesoura"]
    pc = random.choice(opcoes)
    entrada = input(f"{"=" * 25}\nEscolha:\npedra, papel ou tesoura?\n{"=" * 25}\n")
    
    if pc == "pedra" and entrada == "papel":
        clear()
        vencedor = entrada
        PontosUsuario += 1
        print("VENCEDOR DA RODADA: Usuário")
        
    elif pc == "papel"  and entrada == "tesoura":
        clear()
        vencedor = entrada
        PontosUsuario += 1
        print("Vencedor da rodada: Usuário")
        
    elif pc == "tesoura" and entrada == "pedra":
        clear()
        vencedor = entrada
        PontosUsuario += 1
        print("Vencedor da rodada: Usuário")
        
    elif entrada == "pedra" and pc == "papel":
        clear()
        vencedor = pc
        PontosMaquina += 1
        print("Vencedor da rodada: PC")
        
    elif entrada == "papel"  and pc == "tesoura":
        clear()
        vencedor = pc
        PontosMaquina += 1
        print("Vencedor da rodada: PC")
        
    elif entrada == "tesoura" and pc == "pedra":
        clear()
        vencedor = pc 
        PontosMaquina += 1
        print("Vencedor da rodada: PC")     
                          
    else:
        clear() 
        print("Empate")      
         
        
print(f"Placar final:PC {PontosMaquina} x {PontosUsuario} Usuário")        
