package com.jack.service;

import com.jack.model.Coin;
import com.jack.model.User;
import com.jack.model.WatchList;

public interface WatchListService {
	
	WatchList findUserWatchList(Long userId) throws Exception;
	
	WatchList createWatchList(User user);

	WatchList findById(Long id) throws Exception;
	
	Coin addItemToWatchList(Coin coin, User user) throws Exception;
	
	
}
