package com.tripKase.kh.storage.service;

import com.tripKase.kh.attraction.domain.Attraction;
import com.tripKase.kh.restaurant.domain.Restaurant;
import com.tripKase.kh.room.domain.Room;
import com.tripKase.kh.storage.domain.Storage;

import java.util.HashMap;
import java.util.List;

public interface StorageService {

    List<Storage> getStorageData(String memberId);

	int insertStorage(HashMap<String, Object> paramMap);

	List<Storage> getResDataByMemberId(String memberId);

	List<Storage> getRoomDataByMemberId(String memberId);

	List<Storage> getAttrDataByMemberId(String memberId);

	
}