# Documentação do Sistema

## 1. Estrutura do Sistema

O sistema é dividido nas seguintes camadas principais:

### **Application**
- **Main.java**: Classe principal que inicializa a aplicação e carrega a tela de login.

### **Model**
- **ItemCardapio**: Representa um item do cardápio, contendo nome, descrição, preço e quantidade.

### **Controller**
- **TelaLoginController**: Controla a tela de login, validando credenciais e abrindo a tela inicial.
- **TelaInicialController**: Gerencia a tela inicial, permitindo seleção de produtos e adição ao carrinho.
- **TelaPedidoConfirmadoController**: Exibe a confirmação do pedido e fecha a aplicação ao pressionar "OK".
- **CarrinhoController**: Controla a exibição e manipulação do carrinho de compras.
- **GerenciadorCardapio**: Gerencia os itens do cardápio, incluindo adição e remoção de itens.
- **ItemManager**: Controla a adição, remoção e manipulação dos itens do cardápio.

### **View (FXML e CSS)**
- Arquivos .fxml para interfaces gráficas (ex: TelaLogin.fxml, TelaInicial.fxml, TelaPedidoConfirmado.fxml e Carrinho.fxml).
- Arquivo de estilos (style.css).

### **Relacionamento entre Classes**
1. `TelaLoginController` abre `TelaInicialController` após a validação do login.
2. `TelaInicialController` interage com `CarrinhoController` para adicionar e remover itens do carrinho.
3. `CarrinhoController` pode abrir a `TelaPedidoConfirmadoController` após a confirmação do pedido e pode abrir a `TelaInicialController` para editar o pedido.
4. `GerenciadorCardapio` gerencia a lista de itens disponíveis no cardápio.
5. `ItemManager` manipula os itens do cardápio e interage com as classes visuais para atualizar a exibição dos produtos.

---

## 2. Configuração e Execução do Projeto

### **Requisitos**
- Java 8 ou superior
- JavaFX instalado
- Maven como gerenciador de dependências
- IDE compatível (IntelliJ IDEA, Eclipse, NetBeans, etc.)

### **Passos para Executar**
1. Clonar ou baixar o repositório do projeto.
2. Abrir o projeto em sua IDE de preferência.
3. Certificar-se de que todas as dependências do Maven estão configuradas corretamente.
4. Executar a classe `Main.java` para iniciar a aplicação.

---

## 3. Funcionalidades Principais

### **3.1 Tela de Login**
- O usuário insere e-mail e senha.
- Se as credenciais forem "emailteste@gmail.com" e "123456", a tela inicial é aberta.
- Caso contrário, exibe mensagem de erro.

### **3.2 Tela Inicial**
- Exibição de diferentes categorias de produtos: Hambúrguer, Pizza, Pastel, Bebidas.
- Usuário pode adicionar e remover itens do carrinho.
- Botão para abrir o carrinho e visualizar os itens adicionados.

### **3.3 Gerenciamento de Itens**
- Adicionar um novo item ao cardápio.
- Remover um item do cardápio.
- Atualizar a quantidade de itens.

### **3.4 Carrinho de Compras**
- Exibição dos itens adicionados.
- Cálculo automático do subtotal e total (incluindo taxa de entrega).
- Possibilidade de editar o pedido ou confirmar a compra.

### **3.5 Gerenciamento de Dados**
- Salvar e carregar itens do cardápio a partir do arquivo `cardapio.txt`.
- Limpar o cardápio removendo todos os itens.

### **3.6 Tela de Confirmação de Pedido**
- Exibição de mensagem de confirmação do pedido.
- Ao pressionar "OK", a aplicação é encerrada.




