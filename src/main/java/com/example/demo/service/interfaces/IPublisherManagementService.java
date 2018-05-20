package com.example.demo.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Publisher;

public interface IPublisherManagementService {
	Publisher create(Publisher publisher);
	ResponseEntity<?> delete(int IdToDelete);
	Publisher update(int publisherId, Publisher publisherRequest);
	Publisher read(int publisherId);
	List<Publisher> search(int publisherId);
	List<Publisher> findAll();
	Publisher updatePublisher(int publisherId, Publisher publisher);

}
