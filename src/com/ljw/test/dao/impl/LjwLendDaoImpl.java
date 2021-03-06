package com.ljw.test.dao.impl;

import com.ljw.test.dao.LjwLendDao;
import com.ljw.base.db.BaseDao;
import com.ljw.test.pojo.LjwLend;
import com.ljw.base.util.DateUtil;

import java.util.UUID;

/**
 * @Description:
 * @Author Created by junwei.liang on 2018/10/30 18:22
 */
public class LjwLendDaoImpl extends BaseDao implements LjwLendDao {
    @Override
    public int addLendDVD(Long id) {
        LjwLend lend = new LjwLend();
        lend.setId(Long.valueOf(UUID.randomUUID().toString().replace("-", "")));
        lend.setDvdId(id);
        lend.setLendDate(DateUtil.getNowDateStr());
        return insert("INSERT INTO t_lend VALUES(#id#,#dvdId#,#lendDate#,null,null)", lend);
    }

    @Override
    public int update(LjwLend lend) {
        return update("update t_lend set return_date = #returnDate#,money = #money# where id = #id#", lend);
    }

    @Override
    public LjwLend getLendByDvdId(Long dvdId) {
        return queryForObject("select * from t_lend where dvd_id=#dvdId# AND return_date=NULL ", LjwLend.class, dvdId);
    }
}
