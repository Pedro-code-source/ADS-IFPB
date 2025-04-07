N1, N2, N3, N4 = map(float, input().split())

media = (N1 * 2 + N2 * 3 + N3 * 4 + N4 * 1) / 10

if media >= 7.0:
    print(f"Media: {media:.1f}")
    print("Aluno aprovado.")
    
elif media < 5:
    print(f"Media: {media:.1f}")
    print("Aluno reprovado.")
    
elif media <= 6.9:
    print(f"Media: {media:.1f}")
    print("Aluno em exame.")
    nota = float(input("Nota do exame: "))
    media2 = (nota + media) / 2
    if media2 >= 5:
        print("Aluno aprovado.")
    else:
        print("Aluno reprovado.")        
    print(f"Media final: {media2:.1f}")
    