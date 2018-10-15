package com.example.demo.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
	public List<Publisher> findAllById(int publisherId);
}
