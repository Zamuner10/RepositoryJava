package repository;

import model.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    public void salvar(Produto produto){

        List<Produto> produtosExistentes = listar();
        for (Produto p : produtosExistentes) {
            if (p.getId() == produto.getId()) {
            System.out.println("------------------------------------");
            System.out.println(" Erro: Já existe um produto com o ID " + produto.getId() + "!");
            System.out.println("------------------------------------");
            System.out.println();
            return;
        }

        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("produtos.txt", true))){
            String linha = produto.getId() + ";" +
                    produto.getNome() + ";" +
                    produto.getPreco() + ";" +
                    produto.getQuantidade();

            bw.write(linha);
            bw.newLine();

            System.out.println("------------------------------------");
            System.out.println("    Produto salvo com sucesso!");
            System.out.println("------------------------------------");
            System.out.println();

        }catch (IOException e){
            System.out.println("------------------------------------");
            System.out.println("    Erro ao salvar produto: " + e.getMessage());
            System.out.println("------------------------------------");
            System.out.println();
        }

    }

    public List<Produto> listar(){
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("produtos.txt"))){
            String linha;
            while ((linha = br.readLine())!= null){
                String [] partes = linha.split(";");

                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                double preco = Double.parseDouble(partes[2]);
                int quantidade = Integer.parseInt(partes[3]);

                Produto produto = new Produto(id, nome, preco, quantidade);
                produtos.add(produto);

            }
            System.out.println();
        }catch(IOException e){
            System.out.println("------------------------------------");
            System.out.println("    Erro ao listar: " + e.getMessage());
            System.out.println("------------------------------------");
            System.out.println();
        }
        return produtos;
    }

    //-- Atualizar --//
    public void atualizar(Produto produtoAtualizado){
        List<Produto> produtos = listar();

        for (Produto produto : produtos) {
            if (produto.getId() == produtoAtualizado.getId()) {
                produto.setNome(produtoAtualizado.getNome());
                produto.setPreco(produtoAtualizado.getPreco());
                produto.setQuantidade(produtoAtualizado.getQuantidade());
            }
        }
        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter("produtos.txt"))){

            for (Produto produto: produtos){
                String linha = produto.getId() + ";" + produto.getNome() + ";" + produto.getPreco() + ";" + produto.getQuantidade();
                bw.write(linha);
                bw.newLine();
            }

            System.out.println("------------------------------------");
            System.out.println("    Produto atualizado com sucesso!");
            System.out.println("------------------------------------");
            System.out.println();

        }catch (IOException e){
            System.out.println("------------------------------------");
            System.out.println("    Erro ao atualizar: " + e.getMessage());
            System.out.println("------------------------------------");
            System.out.println();
        }

    }

    //-- remover --//
    public void remover (int id){
        List<Produto> produtos = listar();

        boolean encontrado = false;
        for(int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getId() == id){
                produtos.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("------------------------------------");
            System.out.println("    Erro: Não existe nenhum produto com o ID " + id + "!");
            System.out.println("------------------------------------");
            System.out.println();
            return;
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("produtos.txt"))) {
            for(Produto produto: produtos){
                String linha = produto.getId() + ";" + produto.getNome() + ";" + produto.getPreco() + ";" + produto.getQuantidade();
                bw.write(linha);
                bw.newLine();
            }

            System.out.println("------------------------------------");
            System.out.println("    Produto removido com sucesso!");
            System.out.println("------------------------------------");
            System.out.println();

        }catch(IOException e){
            System.out.println("------------------------------------");
            System.out.println("    Erro ao remover: " + e.getMessage());
            System.out.println("------------------------------------");
            System.out.println();
        }
    }
}