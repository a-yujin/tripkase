package com.tripKase.kh.restaurant.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.tripKase.kh.restaurant.domain.ResImg;
import com.tripKase.kh.restaurant.domain.Restaurant;

public interface RestaurantStore {

	public int insertRestaurant(SqlSession session, Restaurant restaurant);

	public int getRestaurantCount(SqlSession session, String searchValue, String areaValue, String [] typeValue);

	public List<Restaurant> printRestaurantByValue(SqlSession session, String searchValue, String areaValue, String [] typeValue, int currentPage, int boardlimit);

	public Restaurant printOneByRestaurantNo(SqlSession session, Integer resNo);

	public int deleteRestaurant(SqlSession session, Integer resNo);

	public int insertRestaurantImg(SqlSessionTemplate session, ResImg resImg);

	

}
