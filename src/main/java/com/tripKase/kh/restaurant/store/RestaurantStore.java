package com.tripKase.kh.restaurant.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.restaurant.domain.Restaurant;

public interface RestaurantStore {

	public int insertRestaurant(SqlSession session, Restaurant restaurant);

	public int getRestaurantCount(SqlSession session, String searchCondition, String searchValue);

	public List<Restaurant> printRestaurantByValue(SqlSession session, String searchCondition,
			String searchValue, int currentPage, int boardlimit);

	public Restaurant printOneByRestaurantNo(SqlSession session, Integer resNo);

	
}
