package com.vicentetfreitas.springbootangular.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vicentetfreitas.springbootangular.model.Pessoa;
import com.vicentetfreitas.springbootangular.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;

	// READ
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	// CREATED

	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(pessoaSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(pessoaSalva);
	}

	/* RETONAR CATEGORIA CRIADA */
	@GetMapping("/{codigo}")
	public Optional<Pessoa> buscarPessoaPeloCodigo(@PathVariable Long codigo) {
		return pessoaRepository.findById(codigo);
	}

}