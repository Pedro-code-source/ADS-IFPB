list = []
while True:
    primos = 0
    cont = 1
    while primos < 20:
            cont += 1
            if cont % 2 == 0 and cont != 2:
                continue
            elif cont % 3 == 0 and cont != 3:
                continue
            elif cont % 5 == 0 and cont != 5:
                continue
            elif cont % 7 == 0 and cont != 7:
                continue
            elif cont % 9 == 0 and cont != 9:
                continue
            else:  
                primos += 1
                print(f"Valor atual: {cont}") 
                list.append(cont)
           
                
                
    print(f"numeros primos: {primos}")        
    print(f"soma {sum(list)}")
    break
