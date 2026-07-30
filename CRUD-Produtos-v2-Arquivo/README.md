# 📦 Sistema de Gerenciamento de Produtos

Sistema de gerenciamento de produtos desenvolvido em **Java**, utilizando conceitos de **Programação Orientada a Objetos (POO)**, manipulação de arquivos e estrutura de dados `ArrayList`.

O projeto implementa um **CRUD completo**, permitindo cadastrar, listar, atualizar e remover produtos através de um menu interativo no terminal.

Os dados são armazenados no arquivo `produtos.txt`, permitindo que os produtos continuem disponíveis mesmo após o encerramento da aplicação.

---

## 🚀 Funcionalidades

O sistema possui as seguintes operações:

* **Cadastrar produto**
* **Listar produtos**
* **Atualizar produto**
* **Remover produto**
* **Validar ID duplicado**
* **Persistir os dados em arquivo `.txt`**
* **Limpar a tela do terminal**
* **Pausar a execução entre as operações**

---

## 🛠️ Tecnologias utilizadas

* **Java**
* `ArrayList`
* `List`
* `Scanner`
* `BufferedReader`
* `BufferedWriter`
* `FileReader`
* `FileWriter`
* Programação Orientada a Objetos
* Persistência de dados em arquivo de texto

---

## 📂 Estrutura do projeto

```text
src/
├── Main.java
│
├── model/
│   └── Produto.java
│
└── repository/
    └── ProdutoRepository.java

produtos.txt
```

### `Produto.java`

Classe responsável por representar um produto.

Cada produto possui:

* `id`
* `nome`
* `preco`
* `quantidade`

---

### `ProdutoRepository.java`

Classe responsável pela manipulação dos produtos e pela persistência dos dados.

Possui os seguintes métodos principais:

```java
salvar(Produto produto)
listar()
atualizar(Produto produtoAtualizado)
remover(int id)
```

O Repository é responsável por ler e escrever os produtos no arquivo `produtos.txt`.

---

### `Main.java`

Classe responsável pela execução da aplicação e pela interação com o usuário.

Possui um menu no terminal:

```text
------------------------------------
          ===== MENU =====
------------------------------------
1 - CADASTRAR
2 - LISTAR
3 - ATUALIZAR
4 - REMOVER
5 - SAIR
------------------------------------
```

---

## 🔄 Funcionamento do sistema

### 1. Cadastrar produto

O usuário informa:

* ID
* Nome
* Preço
* Quantidade

Um objeto `Produto` é criado e enviado para o método `salvar()` do `ProdutoRepository`.

Antes de salvar, o sistema verifica se já existe um produto com o mesmo ID.

Exemplo:

```text
ID: 1
Nome: Teclado
Preço: 150.00
Quantidade: 10
```

O produto é então armazenado no arquivo:

```text
1;Teclado;150.0;10
```

---

### 2. Listar produtos

O método `listar()` abre o arquivo `produtos.txt` e lê cada linha.

Cada linha é separada utilizando `;`:

```java
String[] partes = linha.split(";");
```

Depois disso, os dados são convertidos novamente para os tipos correspondentes e um novo objeto `Produto` é criado.

Os produtos são armazenados em uma `ArrayList` e retornados para o programa.

---

### 3. Atualizar produto

Primeiro, o usuário informa o ID do produto:

```text
Digite o ID: 1
```

O sistema procura o produto correspondente.

Caso o ID seja encontrado, o usuário informa os novos dados:

```text
Novo Nome: Teclado Mecânico
Novo Preço: 250.00
Nova Quantidade: 5
```

O `ProdutoRepository` atualiza os dados do objeto e depois reescreve o arquivo `produtos.txt` com as informações atualizadas.

---

### 4. Remover produto

O usuário informa o ID do produto que deseja remover.

O sistema percorre a lista procurando pelo ID.

Quando encontra o produto:

```java
produtos.remove(i);
```

O produto é removido da lista e o arquivo `produtos.txt` é reescrito sem aquele registro.

Caso o ID não exista, o sistema informa:

```text
Erro: Não existe nenhum produto com o ID informado!
```

---

## 💾 Persistência de dados

O projeto utiliza um arquivo de texto chamado:

```text
produtos.txt
```

Cada produto ocupa uma linha e seus dados são separados por `;`.

Exemplo:

```text
1;Teclado;150.0;10
2;Mouse;80.0;20
3;Monitor;1200.0;5
```

### Salvando dados

Para adicionar um produto sem apagar os registros existentes, é utilizado:

```java
new FileWriter("produtos.txt", true)
```

O parâmetro `true` permite adicionar o novo registro ao final do arquivo.

### Atualizando e removendo

Nas operações de atualização e remoção, o arquivo é reescrito:

```java
new FileWriter("produtos.txt")
```

A lista atualizada é percorrida e todos os registros são gravados novamente.

---

## 🧠 Conceitos de Java praticados

Este projeto foi desenvolvido para colocar em prática conceitos fundamentais da linguagem Java.

### Programação Orientada a Objetos

* Classes
* Objetos
* Atributos
* Métodos
* Construtores
* Encapsulamento
* Getters e Setters

### Coleções

Utilização de:

```java
List<Produto>
ArrayList<Produto>
```

### Estruturas de controle

* `if`
* `else`
* `for`
* `while`
* `do while`
* `switch`

### Entrada de dados

Utilização da classe:

```java
Scanner
```

### Manipulação de arquivos

Utilização de:

```java
FileReader
FileWriter
BufferedReader
BufferedWriter
```

### Tratamento de exceções

Utilização de:

```java
try
catch
```

para tratar possíveis erros durante a leitura e escrita do arquivo.

---

## 📋 Exemplo de utilização

Ao iniciar o programa:

```text
------------------------------------
          ===== MENU =====
------------------------------------
1 - CADASTRAR
2 - LISTAR
3 - ATUALIZAR
4 - REMOVER
5 - SAIR
------------------------------------

Escolha uma opção: 1
```

Cadastro:

```text
--- [ CADASTRAR PRODUTO ] ---
ID: 1
Nome: Teclado
Preço: 150
Quantidade: 10

------------------------------------
    Produto salvo com sucesso!
------------------------------------
```

Ao listar:

```text
--- [ LISTAR PRODUTOS ] ---

Produto{id=1, nome='Teclado', preco=150.0, quantidade=10}
```

---

## ▶️ Como executar

### Pré-requisitos

É necessário ter instalado:

* **JDK**
* Uma IDE Java, como IntelliJ IDEA, Eclipse ou VS Code

### Execução

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto na sua IDE.

3. Compile o projeto.

4. Execute a classe:

```text
Main.java
```

5. Utilize o menu apresentado no terminal.

> O arquivo `produtos.txt` será utilizado para armazenar os dados dos produtos.

---

## 🎯 Objetivo do projeto

O principal objetivo deste projeto foi desenvolver um sistema simples de gerenciamento de produtos para praticar os fundamentos de **Java**, principalmente **Programação Orientada a Objetos**, **coleções** e **persistência de dados em arquivos**.

A implementação de um CRUD permitiu colocar em prática o fluxo completo de:

```text
CREATE → READ → UPDATE → DELETE
```

Além disso, o projeto ajudou a compreender como os dados podem ser mantidos em um arquivo e posteriormente carregados novamente para a aplicação.

---

## 🔮 Possíveis melhorias futuras

Algumas funcionalidades que podem ser implementadas em versões futuras:

* [ ] Utilizar banco de dados
* [ ] Implementar validação dos dados de entrada
* [ ] Melhorar o tratamento de exceções
* [ ] Impedir valores negativos para preço e quantidade
* [ ] Criar busca de produtos por nome
* [ ] Adicionar categorias de produtos
* [ ] Implementar controle de estoque
* [ ] Criar interface gráfica
* [ ] Implementar testes automatizados
* [ ] Separar a aplicação utilizando uma arquitetura como MVC

---

## 👨‍💻 Autor

**Vinicius Klocke Z**

Projeto desenvolvido para fins de estudo e prática de desenvolvimento em **Java**.
