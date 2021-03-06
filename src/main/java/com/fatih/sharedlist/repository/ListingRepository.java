package com.fatih.sharedlist.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fatih.sharedlist.entity.Listing;
import com.fatih.sharedlist.entity.User;


@Repository
@Qualifier("listingRepository")
public interface ListingRepository extends MongoRepository<Listing, String>{
	
	public List<Listing> findByUser(User user);

	public List<Listing> findByPrivateList(boolean privateList);
	
	public Listing findByListingName(String listingName);
}
