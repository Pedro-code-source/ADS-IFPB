#Primeiro importamos a biblioteca "random" para podermos utilizar o método de escolha aleatória da máquina (choice).
import random
#Depois criamos a função de criptografia.
def criptografar(mensagem):
#Em seguida criamos uma lista com todas as letras do alfabeto para ter uma maior quantidade de letras para a criptografia.    
    maquina = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
#Agora vamos percorrer cada letra da palavra escrita pelo usuáro e fazer a substituição da antiga palavra pela palavra criptografada.
    for i in mensagem:
        a = random.choice(maquina)
        mensagem = mensagem.replace(i,a)

    return print(mensagem)
#Por fim, é só passar a palavra desejada dentro da função *criptografar*.
criptografar("amora")
