package com.lojaKolossal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lojaKolossal.domain.Categoria;
import com.lojaKolossal.domain.Cidade;
import com.lojaKolossal.domain.Estado;
import com.lojaKolossal.domain.Produto;
import com.lojaKolossal.repositories.CategoriaRepository;
import com.lojaKolossal.repositories.CidadeRepository;
import com.lojaKolossal.repositories.EstadoRepository;
import com.lojaKolossal.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaKolossalApplication implements CommandLineRunner{
	
	@Autowired
	ProdutoRepository produtoRep;
	
	@Autowired
	CategoriaRepository categoriaRep;
	
	@Autowired
	EstadoRepository estadoRep;
	
	@Autowired
	CidadeRepository cidadeRep;
	
	

	public static void main(String[] args) {
		SpringApplication.run(LojaKolossalApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlândia", est1);
		Cidade cidade2 = new Cidade(null, "São Paulo", est2);
		Cidade cidade3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cidade1));
		est2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRep.saveAll(Arrays.asList(cat1, cat2));
		produtoRep.saveAll(Arrays.asList(p1, p2, p3));
		
		estadoRep.saveAll(Arrays.asList(est1, est2));
		
		cidadeRep.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		
	}

}

