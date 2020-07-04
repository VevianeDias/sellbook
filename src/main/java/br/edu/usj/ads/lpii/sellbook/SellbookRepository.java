package br.edu.usj.ads.lpii.sellbook;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SellbookRepository extends CrudRepository<Livros, Long> {
    List<Livros> findAll();
}