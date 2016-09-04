package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.IGoodsDao;
import com.po.Goods;

public class GoodsDao extends BaseDao implements IGoodsDao {

	@Override
	public List<Goods> findAllGoods() {
		List<Goods> glist = new ArrayList<Goods>();
		String strSql = "SELECT G_ID, G_NAME, G_PRICE, IMAGE, STOCK, G_MEMBER, "
												+ 	"G_DESCRIPTION, G_SCORE FROM GOODS";

		ResultSet rs = super.getResultSet(strSql, null);
		try {
			while(rs.next()){
				Goods gds = new Goods(rs.getInt(1), rs.getString(2), rs.getString(3), 
											rs.getString(4),rs.getInt(5),rs.getString(6),
											rs.getString(7),rs.getInt(8));
				glist.add(gds);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAllObject();
		}
		return glist;
	}

}
