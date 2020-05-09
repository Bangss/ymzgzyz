package com.lingnan.ymzgzyz.controller.api;



import com.lingnan.ymzgzyz.model.entity.ArticleInf;
import com.lingnan.ymzgzyz.service.IArticleInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 推文信息表 前端控制器
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
@RestController
@RequestMapping("/ymzgzyz/article-inf")
public class ArticleInfController {

    @Autowired
    IArticleInfService iArticleInfService;

    //查询全部，返回list
    @PostMapping("/list")
    public List<ArticleInf> getArticleInfList () {
        List<ArticleInf> list = new ArrayList<>();
        list = iArticleInfService.list();
        return list;
    }

    //根据id查询，返回ArticleInf对象
    @PostMapping("/get-one")
    public ArticleInf getArticleInfById ( @RequestBody ArticleInf articleInf) {
        Integer id = articleInf.getId();
        return iArticleInfService.getById(id);
    }

    //更新，返回boolean值
    @PostMapping("/update")
    public boolean updateArticleInf (@RequestBody ArticleInf articleInf) {
        return iArticleInfService.updateById(articleInf);
    }

    //插入，返回boolean值
    @PostMapping("/insert")
    public boolean insertArticleInf (@RequestBody ArticleInf articleInf) {
        return iArticleInfService.save(articleInf);
    }

    //删除，返回boolean值（逻辑删除，修改flag值）
    @PostMapping("/delete")
    public boolean deleteArticleInf ( @RequestBody ArticleInf articleInf) {
        Integer id = articleInf.getId();
        return iArticleInfService.removeById(id);
    }
}
