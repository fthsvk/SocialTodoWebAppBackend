package com.fatih.sharedlist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatih.sharedlist.entity.Listing;
import com.fatih.sharedlist.entity.User;
import com.fatih.sharedlist.repository.ListingRepository;
import com.fatih.sharedlist.repository.UserRepository;
import com.fatih.sharedlist.service.ListingService;

@Service
public class ListingServiceImpl implements ListingService{
	
	
	private ListingRepository listingRepository;
	private UserRepository userRepository;
	
	
	@Autowired
	public ListingServiceImpl(ListingRepository listingRepository , UserRepository userRepository) {
		this.listingRepository=listingRepository;
		this.userRepository=userRepository;
	}


	@Override
	public Listing createListing() {
		Listing listing=new Listing();
		return listing;
	}


	@Override
	public void saveListing(Listing listing) {
		listingRepository.save(listing);
		
	}


	@Override
	public List<Listing> findByUserName(String userName) {
		
		User user=userRepository.findByUserName(userName);
		
		
		List<Listing>  listings=listingRepository.findByUser(user);
		
		return listings;
	}


	@Override
	public List<Listing> findByPrivateList(boolean privateList) {
		
		 
		
		 List<Listing> listings=listingRepository.findByPrivateList(privateList);
		
		return listings;
	}


	@Override
	public Listing findByListingId(String listingId) {
		

		 Listing listing=listingRepository.findOne(listingId);
		
		return listing;
	}


	@Override
	public Listing findByListingName(String listingName) {
		
		return listingRepository.findByListingName(listingName);
	}


	@Override
	public void deleteList(Listing listing) {
		listingRepository.delete(listing);
		
	}


	






}
