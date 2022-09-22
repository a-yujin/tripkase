package com.tripKase.kh.storage.store;

import com.tripKase.kh.storage.domain.Storage;

import java.util.HashMap;
import java.util.List;

public interface StorageStore {
    List<Storage> getStorageDatas(String memberId);

	int insertStorage(HashMap<String, Object> paramMap);

}