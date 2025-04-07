linguas = "portugues","chines","espanhol"
portugues = 0
chines = 0
espanhol = 0
N = int(input())
for i in range(N):
    K = int(input())
    for j in range(K):
        S = input().lower()
        if S == "espanhol":
            espanhol += 1
        if S == "portugues":
            portugues += 1
        if S == "chines":
            chines += 1
    if portugues >= 1 and chines >= 1 or portugues >= 1 and espanhol >= 1 or chines >= 1 and espanhol >= 1:
        print("ingles")
    elif portugues == 0 and chines == 0:
        print("espanhol")
    elif portugues == 0 and espanhol == 0:
        print("chines")
    elif chines == 0 and espanhol == 0:
        print("portugues")
    portugues = 0
    chines = 0
    espanhol = 0        
        