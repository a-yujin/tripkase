package com.tripKase.kh.storage.service.logic;

import com.tripKase.kh.restaurant.store.RestaurantStore;
import com.tripKase.kh.storage.domain.Storage;
import com.tripKase.kh.storage.service.StorageService;
import com.tripKase.kh.storage.store.StorageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageStore stoStore;
    @Autowired
    private RestaurantStore resStore;
    

    public List<Storage> getStorageData(String memberId) {
        return stoStore.getStorageDatas(memberId);
    }

//	@Override
//	public int insertStorage(String contentsCode, String contentsId) {
//		contentsId
//		
//		return result;
//	}
}
