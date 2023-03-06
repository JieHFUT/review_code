package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleInfoMapperTest {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Test
    void add() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setTitle("111");
        articleInfo.setContent("很高兴认识你~");
        articleInfo.setUid(1);
        int result = articleInfoMapper.add(articleInfo);
        System.out.println("添加结果：" + result);
    }

    @Test
    void addGetId() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setTitle("mybaits添加并返回自增id");
        articleInfo.setContent("设置xml中的useGeneratedKeys=\"true\" keyProperty=\"id\"");
        articleInfo.setUid(1);
        int result = articleInfoMapper.addGetId(articleInfo); // 返回受影响的行数
        System.out.println("添加结果：" + result +
                " |自增id：" + articleInfo.getId());
    }

    @Test
    void delById() {
        int result = articleInfoMapper.delById(3);
        System.out.println("删除结果：" + result);
    }

    @Test
    void updateTitle() {
        int result = articleInfoMapper.updateTitle(1, "你好世界");
        System.out.println("修改结果：" + result);
    }

    @Test
    void getAll() {
        List<ArticleInfo> list = articleInfoMapper.getAll();
        for (ArticleInfo item : list) {
            System.out.println(item);
        }
    }
}