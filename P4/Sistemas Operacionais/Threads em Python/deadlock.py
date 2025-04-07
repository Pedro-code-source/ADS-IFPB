import threading
import time

# Simular uma situação de deadlock onde quatro processos competem por dois recursos
recurso1 = threading.Lock()
recurso2 = threading.Lock()

def processo1():
    with recurso1:  # Primeiro bloqueia o recurso 1
        print("O recurso 1 está sendo utilizado pelo processo 1!")
        time.sleep(1)

        print("Recurso 2 solicitado pelo processo 1!")
        with recurso2:  # Depois bloqueia o recurso 2
            print("Processo 1 termina de utilizar os 2 recursos!")

def processo2():
    with recurso1:  # Todos os processos bloqueiam na mesma ordem
        print("O recurso 1 está sendo utilizado pelo processo 2!")
        time.sleep(1)

        print("Recurso 2 solicitado pelo processo 2!")
        with recurso2:
            print("Processo 2 termina de utilizar os 2 recursos!")

def processo3():
    with recurso1:
        print("O recurso 1 está sendo utilizado pelo processo 3!")
        time.sleep(1)

        print("Recurso 2 solicitado pelo processo 3!")
        with recurso2:
            print("Processo 3 termina de utilizar os 2 recursos!")

def processo4():
    with recurso1:
        print("O recurso 1 está sendo utilizado pelo processo 4!")
        time.sleep(1)

        print("Recurso 2 solicitado pelo processo 4!")
        with recurso2:
            print("Processo 4 termina de utilizar os 2 recursos!")

def main():
    t1 = threading.Thread(target=processo1)
    t2 = threading.Thread(target=processo2)
    t3 = threading.Thread(target=processo3)
    t4 = threading.Thread(target=processo4)

    t1.start()
    t2.start()
    t3.start()
    t4.start()

    t1.join()
    t2.join()
    t3.join()
    t4.join()

main()
