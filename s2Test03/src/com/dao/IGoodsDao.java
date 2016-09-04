package com.dao;

import java.util.List;

import com.po.Goods;

public interface IGoodsDao {
	public List<Goods> findAllGoods();
}
