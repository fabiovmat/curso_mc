package com.fabiomatos.cursomc;

import java.text.SimpleDateFormat;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiomatos.cursomc.domain.Categoria;
import com.fabiomatos.cursomc.domain.Cidade;
import com.fabiomatos.cursomc.domain.Cliente;
import com.fabiomatos.cursomc.domain.Endereco;
import com.fabiomatos.cursomc.domain.Estado;
import com.fabiomatos.cursomc.domain.Pagamento;
import com.fabiomatos.cursomc.domain.PagamentoComBoleto;
import com.fabiomatos.cursomc.domain.PagamentoComCartao;
import com.fabiomatos.cursomc.domain.Pedido;
import com.fabiomatos.cursomc.domain.Produto;
import com.fabiomatos.cursomc.domain.enums.EstadoPagamento;
import com.fabiomatos.cursomc.domain.enums.TipoCliente;
import com.fabiomatos.cursomc.repositories.CategoriaRepository;
import com.fabiomatos.cursomc.repositories.CidadeRepository;
import com.fabiomatos.cursomc.repositories.ClienteRepository;
import com.fabiomatos.cursomc.repositories.EnderecoRepository;
import com.fabiomatos.cursomc.repositories.EstadoRepository;
import com.fabiomatos.cursomc.repositories.PagamentoRepository;
import com.fabiomatos.cursomc.repositories.PedidoRepository;
import com.fabiomatos.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	
	
	public void run(String...args)throws Exception{
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"Impressora", 800.00);
		Produto p3 = new Produto(null,"Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade (null,"Uberlândia", est1 );
		Cidade c2 = new Cidade (null,"São Paulo", est2);
		Cidade c3 = new Cidade (null,"Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com","356564564564",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("456456456456","8989897789798"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300","apto 303","Jardim","38080034",cli1,c1);
		Endereco e2 = new Endereco(null,"Avenida Matt","78","apto 450","Centro","38777012",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2020 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2020 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2020 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
	}
}
