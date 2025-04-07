import time
import threading


lock = threading.Lock()
def contagemDeNumeros():
    for i in range(1,11):
        print(i)
        time.sleep(1.5)

def contagemLetras():
    letras = ["A","B","C","D","E","F","G","H","I","J"]
    for i  in letras:
        print(i)    
        time.sleep(1.5)
           
def contagemDeNumerosInversa():
    for i in range(10,0,-1):
        print(i)
        time.sleep(1.5)    
        
def contagemLetrasInversa():
    letras = ["A","B","C","D","E","F","G","H","I","J"] 
    for i in letras[len(letras):0:-1]:
        print(i)
        time.sleep(1.5)
        
        
thread1 = threading.Thread(target = contagemDeNumeros)
thread2 = threading.Thread(target = contagemLetras)
thread3 = threading.Thread(target = contagemDeNumerosInversa)
thread4 = threading.Thread(target = contagemLetrasInversa)

thread1.start()
thread2.start()
thread3.start()
thread4.start()

thread1.join()
thread2.join()
thread3.join()
thread4.join()

print("Programa finalizado!")  