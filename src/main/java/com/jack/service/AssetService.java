package com.jack.service;

import java.util.List;

import com.jack.model.Asset;
import com.jack.model.Coin;
import com.jack.model.User;

public interface AssetService {
	
	Asset createAsset(User user, Coin coin, double quantity);
	
	Asset getAssetById(Long assetId) throws Exception;
	
	Asset getAssetByUserIdAndId(Long userId, Long assetId);
	
	List<Asset>getUsersAssets(Long userId);
	
	Asset updateAsset(Long assetId,double quantity) throws Exception;
	
	Asset findAssetByUserIdAndCoinId(Long userId, String coinId);
	
	void deleteAsset(Long assetId);

}
