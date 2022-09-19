package com.tripKase.kh.restaurant.service;

import java.util.List;

import com.tripKase.kh.restaurant.domain.Restaurant;

public interface RestaurantService {

	public int insertRestaurant(Restaurant restaurant);

	public int getRestaurantCount(String searchCondition, String searchValue);

	public List<Restaurant> printRestaurantByValue(String searchCondition, String searchValue, int currentPage,
			int boardLimit);

	public Restaurant printOneByRestaurantNo(Integer resNo);
	
	
}
