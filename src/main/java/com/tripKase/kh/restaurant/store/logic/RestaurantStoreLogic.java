package com.tripKase.kh.restaurant.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
	public int getRestaurantCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int count = session.selectOne("RestaurantMapper.getRestaurantCount", paramMap);
		return count;
	}

	@Override
	public List<Restaurant> printRestaurantByValue(SqlSession session, String searchCondition,
			String searchValue, int currentPage, int boardlimit) {
		int offset = (currentPage-1)*boardlimit;
		RowBounds rowBounds = new RowBounds(offset, boardlimit);
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		List<Restaurant> resList = session.selectList("RestaurantMapper.printRestaurantByValue", paramMap, rowBounds);
		return resList;
	}

	@Override
	public Restaurant printOneByRestaurantNo(SqlSession session, Integer resNo) {
		Restaurant restaurant = session.selectOne("RestaurantMapper.printOneByRestaurantNo", resNo);
		return restaurant;
	}

}
