import model.Produto;
import repository.ProdutoRepository;

import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public static void pausar(Scanner sc) {
        System.out.println("Pressione ENTER para continuar...");
        sc.nextLine();
    }

    public static void main(String[] args) throws Exception {
        ProdutoRepository repository = new ProdutoRepository();
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        sc.useLocale(Locale.US);

        int opc;

        do {
            limparTela();

            System.out.println("------------------------------------");
            System.out.println("          ===== MENU =====");
            System.out.println("------------------------------------");
            System.out.println("1 - CADASTRAR ");
            System.out.println("2 - LISTAR ");
            System.out.println("3 - ATUALIZAR ");
            System.out.println("4 - REMOVER ");
            System.out.println("5 - SAIR ");
            System.out.println("------------------------------------");

            System.out.print("Escolha uma opção: ");
            opc = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (opc) {
                case 1 -> {
                    System.out.println("--- [ CADASTRAR PRODUTO ] ---");
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(sc.nextLine());

                    System.out.print("Quantidade: ");
                    int quantidade = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    Produto produto = new Produto(id, nome, preco, quantidade);
                    repository.salvar(produto);

                }
                case 2 -> {
                    System.out.println("--- [ LISTAR PRODUTOS ] ---");
                    List<Produto> produtos = repository.listar();
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                    }
                    System.out.println();

                    pausar(sc);
                }
                case 3 -> {
                    System.out.println("--- [ ATUALIZAR PRODUTO ] ---");
                    System.out.print("Digite o ID: ");
                    int idBusca = Integer.parseInt(sc.nextLine());

                    List<Produto> produtos = repository.listar();
                    boolean encontrado = false;

                    for (Produto produto : produtos) {
                        if (produto.getId() == idBusca) {
                            encontrado = true;
                            System.out.print("Novo Nome: ");
                            String nomeNovo = sc.nextLine();

                            System.out.print("Novo Preço: ");
                            double precoNovo = Double.parseDouble(sc.nextLine());

                            System.out.print("Nova Quantidade: ");
                            int quantidadeNova = Integer.parseInt(sc.nextLine());
                            System.out.println();

                            Produto produtoAtulizado = new Produto(idBusca, nomeNovo, precoNovo, quantidadeNova);
                            repository.atualizar(produtoAtulizado);
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("------------------------------------");
                        System.out.println("     ID não encontrado!");
                        System.out.println("------------------------------------");
                        System.out.println();
                    }

                    pausar(sc);
                }
                case 4 -> {
                    System.out.println("--- [ REMOVER PRODUTO ] ---");
                    System.out.print("Digite o ID: ");
                    int buscaId = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    repository.remover(buscaId);

                    pausar(sc);
                }
            }
        } while (opc != 5);

        limparTela();
        System.out.println("------------------------------------");
        System.out.println("          Saindo...... ");
        System.out.println("------------------------------------");
        System.out.println();

        sc.close();
    }
}