package com.tripKase.kh.storage.service.logic;

import com.tripKase.kh.storage.domain.Storage;
import com.tripKase.kh.storage.service.StorageService;
import com.tripKase.kh.storage.store.StorageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageStore stoStore;
    
    public List<Storage> getStorageData(String memberId) {
        return stoStore.getStorageDatas(memberId);
    }


	@Override
	public int insertStorage(HashMap<String, Object> paramMap) {
		int result = stoStore.insertStorage(paramMap);
		return result;
	}


	@Override
	public List<Storage> getResDataByMemberId(String memberId) {
		
		return stoStore.getResDataByMemberId(memberId);
	}


	@Override
	public List<Storage> getRoomDataByMemberId(String memberId) {
		
		return stoStore.getRoomDataByMemberId(memberId);
	}


	@Override
	public List<Storage> getAttrDataByMemberId(String memberId) {
		
		return stoStore.getAttrDataByMemberId(memberId);
	}


	@Override
	public int deleteStorage(int stoNo) {
		
		return stoStore.deleteStorage(stoNo);
	}

    




}
