package com.tripKase.kh.restaurant.store.logic;

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

}
