package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.WatchList;

public interface WatchListRepository extends JpaRepository<WatchList, Long>{

	WatchList findByUserId(Long userId);
}
