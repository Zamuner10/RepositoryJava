import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opc;
        
        do {    
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("6 - Sair");
            System.out.print("x: ");
            opc = sc.nextInt();
            System.out.println("\n");
            
            switch(opc){
                case 1 -> {
                        System.out.println("=== CADASTRAR ===");
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
 
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                
                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();
       
                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();

                        Produto produto  = new Produto(id, nome, preco, quantidade);
                        produtos.add(produto);

                        System.out.println("\n");

                }
                case 2 -> {
                    System.out.println("=== LISTAR ===");
                    if (produtos.isEmpty()){
                        System.out.println("Lista vazia, nenhum produto cadastrado !");
                    }else {
                    for (Produto produto: produtos) {
                    System.out.println(produto);
                    }
                    }
                    System.out.println("\n");
                }

                case 3 -> {
                    System.out.println("=== BUSCAR ===");
                    boolean encontrado = false;
                    System.out.print("Digite o ID: ");
                    int idBusca = sc.nextInt();
                    
                    for(Produto produto: produtos){
                        if (idBusca == produto.getId()){
                            System.out.println(produto);
                            encontrado = true;
                            break;
                        } 
                    }
                    System.out.println("\n");
                    if (!encontrado){
                        System.out.println("ID não encontrado");
                        System.out.println("\n");
                    }
                   
                    
                }

                case 4 -> {
                    System.out.println("=== ATUALIZAR ===");
                    boolean encontrou = false;
                    
                    System.out.print("Digite o ID: ");
                    int idBusca = sc.nextInt();
                    sc.nextLine();

                    for (int i =0; i < produtos.size(); i++){
                        Produto produto = produtos.get(i);

                        
                        if (idBusca == produto.getId()){
    
                        System.out.print("Nome: ");
                        String nomeNovo = sc.nextLine();
                
                        System.out.print("Preço: ");
                        double precoNovo = sc.nextDouble();
       
                        System.out.print("Quantidade: ");
                        int quantidadeNovo = sc.nextInt();

                        produto.setNome(nomeNovo);
                        produto.setPreco(precoNovo);
                        produto.setQuantidade(quantidadeNovo);

                        System.out.println("Produto atualizado com sucesso!");
                        System.out.println(produto);

                        System.out.println("\n");
                        encontrou = true;
                        break;
                        }
                    }

                        if (!encontrou){
                            System.out.println("ID não encontrado");
                            System.out.println("\n");
                        }
                }

                case 5 ->{
                    System.out.println("=== REMOVER ===");
                    boolean encontrado = false;

                    System.out.print("Digite o ID: ");
                    int idBusca = sc.nextInt();

                    for (int i = 0; i < produtos.size(); i++){
                        Produto produto = produtos.get(i);

                        if (idBusca == produto.getId()){
                            produtos.remove(produto);
                            encontrado = true;
                            break;
                        }
                    }
                    System.out.println("\n");
                    System.out.println("\n");
                    if (!encontrado ){
                        System.out.println("ID não encontrado");
                        System.out.println("\n");
                    }
                }

              
                default -> System.out.println("Opção Inválida !!\n");
               
            }
        }while (opc != 6);
            System.out.println("SAINDO.................");
            System.out.println("\n");
           
        sc.close();
    }

    
}
