package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleInfoMapper {
    // 添加方法
    public int add(@Param("articleInfo") ArticleInfo articleInfo);

    // 添加方法（得到自增主键的id）
    public int addGetId(@Param("articleInfo") ArticleInfo articleInfo);

    // 删除单条数据
    public int delById(@Param("id") Integer id);

    // 修改标题
    public int updateTitle(@Param("id") Integer id, @Param("title") String title);

    public List<ArticleInfo> getAll();

}
