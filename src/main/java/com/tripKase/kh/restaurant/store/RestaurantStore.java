package com.tripKase.kh.restaurant.store;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.restaurant.domain.Restaurant;

public interface RestaurantStore {

	public int insertRestaurant(SqlSession session, Restaurant restaurant);

}
