package org.alanmontes.videogamereviewsite.repositories;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	Review findById(int id);
	List<Review> findAll();
	List<Review> findByScore(int score);
}
