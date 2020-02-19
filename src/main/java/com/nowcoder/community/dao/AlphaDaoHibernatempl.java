package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaoHibernatempl implements AlphaDao{

    @Override
    public String select() {
        return "Hibernate";
    }
}
