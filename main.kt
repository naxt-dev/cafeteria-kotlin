import java.util.Scanner

val estoque: MutableList<MutableMap<String, Any>> = mutableListOf(
    mutableMapOf("nome" to "Café", "preco" to 4.50, "quantidade" to 10),
    mutableMapOf("nome" to "Pão de Queijo", "preco" to 3.00, "quantidade" to 15),
    mutableMapOf("nome" to "Bolo", "preco" to 6.00, "quantidade" to 8)
)

fun main() {
    val scanner = Scanner(System.`in`)
    var opcao: Int

    do {
        println("\n--- Sistema de Gerenciamento de Cafeteria ---")
        println("1 - Listar produtos")
        println("2 - Adicionar novo produto")
        println("3 - Realizar venda")
        println("4 - Repor estoque de produto existente")
        println("0 - Sair")
        print("Escolha uma opção: ")

        opcao = scanner.nextInt()
        scanner.nextLine()

        when (opcao) {
            1 -> listarProdutos()
            2 -> adicionarProduto(scanner)
            3 -> realizarVenda(scanner)
            4 -> reporEstoque(scanner)
            0 -> println("Saindo do sistema...")
            else -> println("Opção inválida.")
        }

    } while (opcao != 0)
}

fun listarProdutos() {
    println("\n--- Produtos no Estoque ---")

    if (estoque.isEmpty()) {
        println("O estoque está vazio.")
        return
    }

    for (produto in estoque) {
        val nome = produto["nome"] as String
        val preco = produto["preco"] as Double
        val quantidade = produto["quantidade"] as Int

        println(
            "Produto: $nome | Preço: R$%.2f | Estoque: $quantidade unidades"
                .format(preco)
        )
    }
}

fun adicionarProduto(scanner: Scanner) {

    println("\n--- Adicionar Novo Produto ---")

    print("Nome do produto: ")
    val nome = scanner.nextLine()

    print("Preço: ")
    val preco = scanner.nextDouble()

    print("Quantidade inicial: ")
    val quantidade = scanner.nextInt()

    val novoProduto = mutableMapOf<String, Any>(
        "nome" to nome,
        "preco" to preco,
        "quantidade" to quantidade
    )

    estoque.add(novoProduto)

    println("Produto adicionado com sucesso.")
}

fun realizarVenda(scanner: Scanner) {

    println("\n--- Realizar Venda ---")

    print("Nome do produto: ")
    val nomeBusca = scanner.nextLine()

    val produto = estoque.find {
        (it["nome"] as String).equals(nomeBusca, ignoreCase = true)
    }

    if (produto != null) {

        print("Quantidade vendida: ")
        val qtdVendida = scanner.nextInt()

        val qtdAtual = produto["quantidade"] as Int

        if (qtdAtual >= qtdVendida) {

            produto["quantidade"] = qtdAtual - qtdVendida

            println(
                "Venda realizada. Novo estoque de ${produto["nome"]}: ${produto["quantidade"]}"
            )

        } else {
            println("Estoque insuficiente.")
        }

    } else {
        println("Produto não encontrado.")
    }
}

fun reporEstoque(scanner: Scanner) {

    println("\n--- Repor Estoque ---")

    print("Nome do produto: ")
    val nomeBusca = scanner.nextLine()

    val produto = estoque.find {
        (it["nome"] as String).equals(nomeBusca, ignoreCase = true)
    }

    if (produto != null) {

        print("Quantidade adicionada: ")
        val qtdReposta = scanner.nextInt()

        val qtdAtual = produto["quantidade"] as Int

        produto["quantidade"] = qtdAtual + qtdReposta

        println(
            "Estoque atualizado. Novo estoque de ${produto["nome"]}: ${produto["quantidade"]}"
        )

    } else {

        println("Produto não encontrado.")

        print("Deseja adicionar como novo produto? (S/N): ")
        val resposta = scanner.nextLine()

        if (resposta.equals("S", ignoreCase = true)) {
            adicionarProduto(scanner)
        }
    }
}