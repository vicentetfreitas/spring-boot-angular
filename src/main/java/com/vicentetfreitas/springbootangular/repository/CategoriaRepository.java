package com.vicentetfreitas.springbootangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicentetfreitas.springbootangular.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
