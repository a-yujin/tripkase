package com.tripKase.kh.restaurant.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.restaurant.domain.ResImg;
import com.tripKase.kh.restaurant.domain.Restaurant;
import com.tripKase.kh.restaurant.store.RestaurantStore;

@Repository
public class RestaurantStoreLogic implements RestaurantStore{

	@Override
	public int insertRestaurant(SqlSession session, Restaurant restaurant) {
		int result = session.insert("RestaurantMapper.insertRestaurant", restaurant);
		return result;
	}
	
	@Override
	public int insertRestaurantImg(SqlSessionTemplate session, ResImg resImg) {
		int result = session.insert("RestaurantMapper.insertResImg", resImg);
		return result;
	}

	@Override
	public int getRestaurantCount(SqlSession session, String searchValue, String areaValue, String [] typeValue) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();		// 해쉬 맵 스트링 스트링일 경우 리스트를 못받아와서 해쉬맵 스트링 오브젝트
		paramMap.put("searchValue", searchValue);		// 가게명 검색값을 해쉬맵에 넣어줌
		paramMap.put("areaValue", areaValue);			// 지역값 해쉬맵에 넣어줌
		paramMap.put("typeValue", typeValue);			// 맛집 종류값 해쉬맵에 넣어줌 ( 리스트 )
		
		return session.selectOne("RestaurantMapper.getRestaurantCount", paramMap);
	}

	@Override
	public List<Restaurant> printRestaurantByValue(SqlSession session, String searchValue, String areaValue, String [] typeValue, int currentPage, int boardlimit) {
		int offset = (currentPage-1)*boardlimit;
		RowBounds rowBounds = new RowBounds(offset, boardlimit);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchValue", searchValue);
		paramMap.put("areaValue", areaValue);
		paramMap.put("typeValue", typeValue);
		List<Restaurant> resList = session.selectList("RestaurantMapper.printRestaurantByValue", paramMap, rowBounds);
		return resList;
	}

	@Override
	public Restaurant printOneByRestaurantNo(SqlSession session, Integer resNo) {
		Restaurant restaurant = session.selectOne("RestaurantMapper.printOneByRestaurantNo", resNo);
		return restaurant;
	}

	@Override
	public int deleteRestaurant(SqlSession session, Integer resNo) {
		int result = session.update("RestaurantMapper.deleteRestaurant", resNo);
		return result;
	}

	

}
