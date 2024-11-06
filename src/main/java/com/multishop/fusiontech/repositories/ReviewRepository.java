package com.multishop.fusiontech.repositories;

import com.multishop.fusiontech.models.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId);

    List<Review> findByProductId(Long productId, Pageable pageable);
}
