package com.lingnan.ymzgzyz.controller.api;



import com.lingnan.ymzgzyz.model.entity.ArticleInf;
import com.lingnan.ymzgzyz.service.IArticleInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     * 其他条件查询
     */

    //userRole
    @PostMapping("/getByUserRole")
    public List<ArticleInf> getByUserRole(@RequestBody ArticleInf articleInf) {
        return iArticleInfService.getByUserRole(articleInf.getUserRole());
    }

    //userId
    @PostMapping("/getByUserId")
    public List<ArticleInf> getByUserId(@RequestBody ArticleInf articleInf) {
        return iArticleInfService.getByUserId(articleInf.getUserId());
    }

    //role
    @PostMapping("/getByRole")
    public List<ArticleInf> getByRole(@RequestBody ArticleInf articleInf) {
        return iArticleInfService.getByRole(articleInf.getRole());
    }

    //states
    @PostMapping("/getByStates")
    public List<ArticleInf> getByStates(@RequestBody ArticleInf articleInf) {
        return iArticleInfService.getByStates(articleInf.getStates());
    }

    //startTime

    /**
     * 没实现前都想着要转换统一格式才能模糊查询，其实不需要
     * @param time 前端返回String类型的日期就可以了，什么格式都行，模糊查询
     * @return list
     */
    @PostMapping("/getByStartTime")
    public List<ArticleInf> getByStartTime( String time ) {
        System.out.println(time);
        return iArticleInfService.getByStartTime(time);
    }

    //title 模糊查询
    @PostMapping("/getByTitle")
    public List<ArticleInf> getByTitle(@RequestParam String str) {
        return iArticleInfService.getByTitle(str);
    }

    //content 模糊查询
    @PostMapping("/getContent")
    public List<ArticleInf> getByContent(@RequestParam String str) {
        return iArticleInfService.getByContent(str);
    }
}
