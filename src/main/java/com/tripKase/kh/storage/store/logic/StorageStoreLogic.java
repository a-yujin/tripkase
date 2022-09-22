package com.tripKase.kh.storage.store.logic;

import com.tripKase.kh.storage.domain.Storage;
import com.tripKase.kh.storage.store.StorageStore;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StorageStoreLogic implements StorageStore {
	
    @Autowired
    private SqlSession session;

    public List<Storage> getStorageDatas(String memberId) {
        return session.selectList("StorageMapper.getStorageDatas", memberId);
    }

//	@Override
//	public int insertStorage(String contentsCode, String contentsId) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
