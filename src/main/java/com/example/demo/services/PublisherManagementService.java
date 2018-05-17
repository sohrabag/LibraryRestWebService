package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.demo.dataaccess.PublisherRepository;
import com.example.demo.domain.Publisher;
import com.example.demo.jpa.exception.ResourceNotFoundException;
import com.example.demo.service.interfaces.IPublisherManagementService;

@Controller
public class PublisherManagementService implements IPublisherManagementService {

	@Autowired
	PublisherRepository publisherRep;
	
	@Override
	public Publisher create(Publisher publisher) {
		
		return publisherRep.save(publisher);
	}

	@Override
	public ResponseEntity<?> delete(int IdToDelete) {
		if(!publisherRep.existsById(IdToDelete))
		{
			throw new ResourceNotFoundException("IdToDelete" + IdToDelete + "not found");
		}
		
		return publisherRep.findById(IdToDelete).map(publisher -> {
			publisherRep.delete(publisher);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("IdToDelete" + IdToDelete + "not found"));
	}

	@Override
	public Publisher update(int publisherId, Publisher publisherRequest) {
		if(!publisherRep.existsById(publisherId)) {
			throw new ResourceNotFoundException("publisherId" + publisherId + "not found");
		}
		
		return publisherRep.findById(publisherId).map(publisher -> {
			publisher.setName(publisherRequest.getName());
			return publisherRep.save(publisher);
		}).orElseThrow(() -> new ResourceNotFoundException("publisherId" + publisherId + "not found"));

	}

	@Override
	public Publisher read(int publisherId) {
		if(!publisherRep.existsById(publisherId))
		{
			throw new ResourceNotFoundException("publisherId" + publisherId + "not found");
		}
		
		return publisherRep.findById(publisherId).get();

	}

	@Override
	public List<Publisher> search(int publisherId) {
		if(!publisherRep.existsById(publisherId))
		{
			throw new ResourceNotFoundException("publisherId" + publisherId + "not found");
		}
		
		return publisherRep.findAllById(publisherId);
		
	}

	@Override
	public List<Publisher> findAll() {
		
		return publisherRep.findAll();
	}

	@Override
	public Publisher updatePublisher(int publisherId, Publisher changedPublisher) {

		if(!publisherRep.existsById(publisherId))
		{
			throw new ResourceNotFoundException("publisherId" + publisherId + "not found");
		}
		
		return publisherRep.findById(publisherId).map(publisher -> {
			publisher.setName(changedPublisher.getName());
			
			return publisherRep.save(publisher);
		}).orElseThrow(() -> new ResourceNotFoundException("publisherId" + publisherId + "not found"));


	}

}
