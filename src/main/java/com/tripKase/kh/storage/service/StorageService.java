package com.tripKase.kh.storage.service;

import com.tripKase.kh.storage.domain.Storage;

import java.util.HashMap;
import java.util.List;

public interface StorageService {

    List<Storage> getStorageData(String memberId);

	int insertStorage(HashMap<String, Object> paramMap);

	
}