package com.tripKase.kh.restaurant.service;

import java.util.List;

import com.tripKase.kh.restaurant.domain.Restaurant;

public interface RestaurantService {

	public int insertRestaurant(Restaurant restaurant);

	public int getRestaurantCount(String searchValue, String areaValue,String [] typeValue);

	public List<Restaurant> printRestaurantByValue(String searchValue, String areaValue, String [] typeValue, int currentPage, int boardLimit);

	public Restaurant printOneByRestaurantNo(Integer resNo);

	public int deleteRestaurant(Integer resNo);
	
	
}
