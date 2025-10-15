# def fatorial(n):
#     fatorial = 1
#     for i in range(n,0,-1):
#         fatorial *= i
#     print(fatorial)
        
# fatorial(5)

def fatorial(n):
    i = n
    fatorial = 1
    if i < n:
        return fatorial
    else:
        fatorial *= i
        i -= 1
        return fatorial()
    
print(fatorial(5))
        
        
    