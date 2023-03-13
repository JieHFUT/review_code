package com.example.demo.controller;

import com.example.demo.common.AjaxResult;
import com.example.demo.common.SessionUtil;
import com.example.demo.model.ArticleInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文章控制器
 */
@RestController
@RequestMapping("/art")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/mylist")
    public List<ArticleInfo> myList(HttpServletRequest request) {
        UserInfo userInfo = SessionUtil.getLoginUser(request);
        if (userInfo != null) {
            return articleService.getMyList(userInfo.getId());
        }
        return null;
    }

    @RequestMapping("/list")
    public List<ArticleInfo> getList(Integer pindex, Integer psize) {
        if (pindex == null || psize == null) {
            return null;
        }
        // 分页公式，计算偏移量
        int offset = (pindex - 1) * psize;
        return articleService.getList(psize, offset);
    }

    @RequestMapping("/detail")
    public Object getDetil(Integer aid) {
        if (aid != null && aid > 0) {
            return AjaxResult.success(articleService.getDetail(aid));
        }
        return AjaxResult.fail(-1, "查询失败");
    }

    @RequestMapping("/detailbyid")
    public Object getDetilById(HttpServletRequest request, Integer aid) {
        if (aid != null && aid > 0) {
            // 根据文章查询文章的详情
            ArticleInfo articleInfo = articleService.getDetail(aid);
            // 文章的归属人验证
            UserInfo userInfo = SessionUtil.getLoginUser(request);
            if (userInfo != null && articleInfo != null &&
                    userInfo.getId() == articleInfo.getUid()) { // 文章归属人是正确的
                return AjaxResult.success(articleInfo);
            }
        }
        return AjaxResult.fail(-1, "查询失败");
    }

    @RequestMapping("/update")
    public int update(HttpServletRequest request, Integer aid, String title, String content) {
        // todo:非空效验
        UserInfo userInfo = SessionUtil.getLoginUser(request);
        if (userInfo != null && userInfo.getId() > 0) {
            return articleService.update(aid, userInfo.getId(), title, content);
        }
        return 0;
    }

    @RequestMapping("/totalpage")
    public Integer totalPage(Integer psize) {
        if (psize != null) {
            // 参数有效
            int totalCount = articleService.getTotalCount();
            // 总页数
            int totalPage = (int) Math.ceil(totalCount * 1.0 / psize);
            return totalPage;
        }
        return null;
    }
}
