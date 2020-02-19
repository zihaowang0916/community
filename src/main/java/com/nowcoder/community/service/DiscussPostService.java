package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(userId, offset, limit);
        return list;
    }

    public int findDiscussPostRows(int userId){
        int rows = discussPostMapper.selectDiscussPostRows(userId);
        return rows;
    }
}
