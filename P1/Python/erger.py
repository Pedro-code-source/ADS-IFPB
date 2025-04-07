#Informações do dia de inicio do evento
nome_inicial, dia_inicial = map(str, input().split())
dia_inicial = int(dia_inicial)
hhi, mmi, ssi = map(int, input().split(":"))
#Informações do dia final do evento
nome_final, dia_final = map(str, input().split())
dia_final = int(dia_final)
hhf, mmf, ssf = map(int, input().split(":"))
#Lógica aplicada
W = 0
X = 0
Y = 0
Z = 0
if hhi > hhf:
    W = (dia_final - dia_inicial) -1
if hhi <= hhf:
    W = dia_final - dia_inicial       
if hhi > hhf:    
    X = (24 - hhi) + hhf
if hhi < hhf:
    X = hhf - hhi    
if mmi <= mmf:
    Y = mmf - mmi
if mmi > mmf:
    Y = (60 - mmi) + mmf    
if ssi <= ssf:
    Z = ssf - ssi
if ssi > ssf:
    Z = (60 - ssi) + ssf      

print(f"{W} dia (s)\n{X} hora (s)\n{Y} minuto (s)\n{Z} segundo (s)")