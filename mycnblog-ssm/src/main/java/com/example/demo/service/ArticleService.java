package com.example.demo.service;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章表服务层
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<ArticleInfo> getMyList(Integer uid) {
        return articleMapper.getMyList(uid);
    }

    public ArticleInfo getDetail(Integer aid) {
        return articleMapper.getDetail(aid);
    }

    public int update(Integer aid, Integer uid, String title, String content) {
        return articleMapper.update(aid, uid, title, content);
    }

    public List<ArticleInfo> getList(Integer psize, Integer offset) {
        return articleMapper.getList(psize, offset);
    }

    public int getTotalCount() {
        return articleMapper.getTotalCount();
    }

}
