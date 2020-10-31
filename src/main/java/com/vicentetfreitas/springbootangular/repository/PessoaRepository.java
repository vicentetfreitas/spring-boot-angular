package com.vicentetfreitas.springbootangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicentetfreitas.springbootangular.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{


}
