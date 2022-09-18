package com.tripKase.kh.restaurant.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.restaurant.domain.Restaurant;
import com.tripKase.kh.restaurant.service.RestaurantService;
import com.tripKase.kh.restaurant.store.RestaurantStore;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private RestaurantStore resStore;

	
	@Override
	public int insertRestaurant(Restaurant restaurant) {
		int result = resStore.insertRestaurant(session, restaurant);
		return result;
	}

}
