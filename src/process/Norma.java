package process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Contagem;
import model.Estoque;

public class Norma {
	
	private ArrayList<Estoque> estoque = new ArrayList<Estoque>();
	private ArrayList<Contagem> itens = new ArrayList<Contagem>();
	
	
    public void processarEstoque() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("list_contada.txt"))) {
            for (Contagem item : itens) {
                Estoque estoqueAtual = encontrarEstoque(item.getNome());
                if (estoqueAtual != null) {
                    int quantidadeInicial = estoqueAtual.getQuantidade();
                    int quantidadeContada = item.getQuantidade();
                    if (quantidadeContada <= quantidadeInicial) {
                        int quantidadeAdicional = quantidadeContada - quantidadeInicial;
                        estoqueAtual.setQuantidade(quantidadeInicial + quantidadeAdicional);
                    	int quantidadeRetirada = quantidadeContada - quantidadeInicial;
                        bw.write(item.getNome() + "," + quantidadeContada + " - Estoque retirado: " + quantidadeRetirada + " - novo estoque: " + estoqueAtual.getQuantidade());
                        bw.newLine();
                    } else {
                        int quantidadeAdicional = quantidadeContada - quantidadeInicial;
                        estoqueAtual.setQuantidade(quantidadeInicial + quantidadeAdicional);
                        bw.write(item.getNome() + "," + quantidadeContada + " - Quantidade adicionada: " + quantidadeAdicional + ". Novo estoque: " + estoqueAtual.getQuantidade());
                        bw.newLine();
                    }
                } else {
                    bw.write("Produto não encontrado no estoque: " + item.getNome());
                    bw.newLine();
                }
            }
            System.out.println("Processamento do arquivo 'list_contada.txt' concluído.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo 'list_contada.txt': " + e.getMessage());
        }
    }
	
	private Estoque encontrarEstoque(String nome) {
	    for (Estoque estoque : estoque) {
	        if (estoque.getNome().equalsIgnoreCase(nome)) {
	            return estoque;
	        }
	    }
	    return null;
	}

	
	public void carregaListaEstoque() {
		try {
			FileReader fr = new FileReader("list_estoque.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String parts[] = linha.split(",");
				String nome = parts[0];
				int quantidade = Integer.parseInt(parts[1].trim());
				estoque.add(new Estoque(nome, quantidade));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void carregaListaContagem() {
		try {
			FileReader fr = new FileReader("list_contagem.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String parts[] = linha.split(",");
				String nome = parts[0];
				int quantidade = Integer.parseInt(parts[1].trim());
				itens.add(new Contagem(nome, quantidade));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList<Estoque> getEstoque() {
		return estoque;
	}

	public void setProdutos(ArrayList<Estoque> estoque) {
		this.estoque = estoque;
	}

	public ArrayList<Contagem> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Contagem> itens) {
		this.itens = itens;
	}
	
	

}