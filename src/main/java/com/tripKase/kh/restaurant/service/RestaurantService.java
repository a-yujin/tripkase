package com.tripKase.kh.restaurant.service;

import java.util.List;

import com.tripKase.kh.restaurant.domain.ResImg;
import com.tripKase.kh.restaurant.domain.Restaurant;

public interface RestaurantService {

	public int insertRestaurant(Restaurant restaurant);
	
	public int insertRestaurantImg(ResImg resImg);

	public int getRestaurantCount(String searchValue, String areaValue,String [] typeValue);

	public List<Restaurant> printRestaurantByValue(String searchValue, String areaValue, String [] typeValue, int currentPage, int boardLimit);

	public Restaurant printOneByRestaurantNo(Integer resNo);

	public int deleteRestaurant(Integer resNo);

	public int updateRestaurant(Restaurant restaurant);

	public int updateRestaurantImg(ResImg resImg);

	public List<ResImg> selectResImgByNo(Integer resNo);

	
	
}
