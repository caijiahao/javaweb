package com.service.impl;

import java.util.List;

import com.dao.IGoodsDao;
import com.dao.impl.GoodsDao;
import com.po.Goods;
import com.service.IGoodsService;

public class GoodsService implements IGoodsService {
	IGoodsDao dao = new GoodsDao();
	@Override
	public List<Goods> getAllGoods() {
		return dao.findAllGoods();
	}

}
