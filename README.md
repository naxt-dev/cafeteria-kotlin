# ☕ Gerenciador de Cafeteria em Kotlin

Um sistema de gerenciamento de estoque para uma cafeteria executado via console. Este projeto foi desenvolvido para consolidar os fundamentos da linguagem **Kotlin**, incluindo estruturas de controle de fluxo, laços de repetição, funções e manipulação de coleções.

## 🚀 Funcionalidades

O sistema permite que o gerente da cafeteria controle os produtos vendidos através de um menu interativo com as seguintes opções:

1. **Listar produtos**: Visualiza todos os produtos cadastrados com nome, preço e quantidade disponível.
2. **Adicionar novo produto**: Cadastra um novo item informando nome, preço e estoque inicial.
3. **Realizar venda**: Subtrai a quantidade vendida do estoque (com validação de limite de itens).
4. **Repor estoque**: Adiciona unidades a um produto já existente ou redireciona para a criação de um novo, caso não seja encontrado.
0. **Sair**: Encerra a execução do sistema.

## 🛠️ Tecnologias e Estruturas Utilizadas

- **Linguagem:** Kotlin
- **Coleções:** Uso de `MutableList` contendo `MutableMap` para armazenar dinamicamente as propriedades dos produtos (Nome, Preço e Quantidade).
- **Controle de Fluxo:** Implementação de menus interativos com `do-while` e roteamento de opções com `when`.
- **Interação no Console:** Leitura de dados de entrada utilizando `java.util.Scanner`.

## 📦 Estrutura de Dados Inicial

O sistema é inicializado com os seguintes produtos em memória:
- **Café:** R$ 4,50 (10 unidades)
- **Pão de Queijo:** R$ 3,00 (15 unidades)
- **Bolo:** R$ 6,00 (8 unidades)

## ⚙️ Como Executar

1. Certifique-se de ter o [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/downloads/) e o [Kotlin Compiler](https://kotlinlang.org/docs/command-line.html) instalados em sua máquina.
2. Clone este repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/cafeteria-kotlin.git](https://github.com/SEU_USUARIO/cafeteria-kotlin.git)
