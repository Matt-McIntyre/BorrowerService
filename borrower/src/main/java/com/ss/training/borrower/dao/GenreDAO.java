package com.ss.training.borrower.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.training.borrower.entity.Genre;

@Repository
public interface GenreDAO extends JpaRepository<Genre, Long>{

}
