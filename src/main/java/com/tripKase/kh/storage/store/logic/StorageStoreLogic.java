package com.tripKase.kh.storage.store.logic;

import com.tripKase.kh.storage.domain.Storage;
import com.tripKase.kh.storage.store.StorageStore;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class StorageStoreLogic implements StorageStore {
	
    @Autowired
    private SqlSession session;

    public List<Storage> getStorageDatas(String memberId) {
        return session.selectList("StorageMapper.getStorageDatas", memberId);
    }

	@Override
	public int insertStorage(HashMap<String, Object> paramMap) {
		int result = session.insert("StorageMapper.insertStorage",paramMap);
		return result;
	}

	@Override
	public List<Storage> getResDataByMemberId(String memberId) {
		
		return session.selectList("StorageMapper.getResDataByMemberId", memberId);
	}

	@Override
	public List<Storage> getRoomDataByMemberId(String memberId) {
		
		return session.selectList("StorageMapper.getRoomDataByMemberId", memberId);
	}

	@Override
	public List<Storage> getAttrDataByMemberId(String memberId) {
		
		return session.selectList("StorageMapper.getAttrDataByMemberId", memberId);
	}

	@Override
	public int deleteStorage(int stoNo) {
		
		return session.delete("StorageMapper.deleteStorage", stoNo);
	}

    

	
}
