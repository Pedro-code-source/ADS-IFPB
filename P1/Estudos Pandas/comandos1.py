import pandas as pd
vendas = {"data":["15/02/2021","16/02/2021","15/06/2021","17/06/1898","21/10/1990"],
          "valor":[500,300,400,250,600],
          "produto":["feijão","arroz","trigo","milho","ervilha"],
          "qtdd":[50,70,60,45,80]
}

tabelaDeVendas = pd.DataFrame(vendas)
print(tabelaDeVendas)

# testando ferramentas:
quantidadesDeProdutos = int(input("Quantos produtos deseja adicionar á tabela?\n"))
for i in range(quantidadesDeProdutos):
    data = input("data: ")
    valor = float(input("valor: "))
    produto = input("produto: ")
    quantidade = float(input("quantidade: "))
    
    novosValores = pd.DataFrame({"data":[data],
                    "valor":[valor],
                    "produto":[produto],
                    "qtdd":[quantidade]})
    tabelaDeVendas = pd.concat([tabelaDeVendas,novosValores], ignore_index = True)
    print(f"Produto {i+1} adicionado á tabela.")
print (tabelaDeVendas)    
df = pd.read_excel("Vendas.xlsx")
print(df.head())