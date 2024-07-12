package process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Contagem;
import model.Estoque;

public class Norma {
	
	private ArrayList<Estoque> estoque = new ArrayList<Estoque>();
	private ArrayList<Contagem> itens = new ArrayList<Contagem>();
	
	
	public void processarEstoque() {
		try {
			FileWriter fw = new FileWriter("list_contada.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Contagem item : itens) {
				bw.append(item.toString());
				
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carregaListaEstoque() {
		try {
			FileReader fr = new FileReader("list_estoque.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String parts[] = linha.split(",");
				String nome = parts[0];
				int quantidade = Integer.parseInt(parts[1]);
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
				int quantidade = Integer.parseInt(parts[1]);
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