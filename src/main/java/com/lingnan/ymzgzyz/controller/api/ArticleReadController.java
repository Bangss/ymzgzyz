package com.lingnan.ymzgzyz.controller.api;



import com.lingnan.ymzgzyz.annotation.LoginToken;
import com.lingnan.ymzgzyz.model.R;
import com.lingnan.ymzgzyz.model.entity.ActiveSign;
import com.lingnan.ymzgzyz.model.entity.ArticleRead;
import com.lingnan.ymzgzyz.service.IArticleReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
@RestController
@RequestMapping("/ymzgzyz/article-read")
public class ArticleReadController {

    @Autowired
    IArticleReadService iArticleReadService;

    //查询全部，返回list
    @PostMapping("/list")
    @LoginToken
    public List<ArticleRead> getArticleReadFList () {
        List<ArticleRead> list = new ArrayList<>();
        list = iArticleReadService.list();
        return list;
    }

    //根据id查询，返回ArticleRead对象
    @PostMapping("/get-one")
    @LoginToken
    public ArticleRead getArticleReadById ( @RequestBody ArticleRead articleRead) {
        Integer id = articleRead.getId();
        return iArticleReadService.getById(id);
    }

    //更新，返回boolean值
    @PostMapping("/update")
    @LoginToken
    public boolean updateArticleRead (@RequestBody ArticleRead articleRead) {
        return iArticleReadService.updateById(articleRead);
    }

    //插入，返回boolean值
    @PostMapping("/insert")
    @LoginToken
    public boolean insertArticleRead (@RequestBody ArticleRead articleRead) {
        return iArticleReadService.save(articleRead);
    }

    //删除，返回boolean值（逻辑删除，修改flag值）
    @PostMapping("/delete")
    @LoginToken
    public boolean deleteArticleRead ( @RequestBody ArticleRead articleRead) {
        Integer id = articleRead.getId();
        return iArticleReadService.removeById(id);
    }

    /**
     * 其他条件查询
     */

    // articleId
    @PostMapping("/getByArticleId")
    @LoginToken
    public List<ArticleRead> getByArticleId (@RequestBody ArticleRead articleRead) {
        return iArticleReadService.getByArticleId(articleRead.getArticleId());
    }

    //userId
    @PostMapping("/getByUserId")
    @LoginToken
    public List<ArticleRead> getByUserId (@RequestBody ArticleRead articleRead) {
        return iArticleReadService.getByUserId(articleRead.getUserId());
    }

    //userRole
    @PostMapping("/getByUserRole")
    @LoginToken
    public List<ArticleRead> getByUserRole (@RequestBody ArticleRead articleRead) {
        return iArticleReadService.getByUserRole(articleRead.getUserRole());
    }


    //readTime
    @PostMapping("/getByReadTime")
    @LoginToken
    public List<ArticleRead> getByReadTime (String time) {
        return iArticleReadService.getByReadTime(time);
    }

    //批量删除
    @PostMapping("/listDelete")
    @LoginToken
    public R listDelete (@RequestBody List<Integer> idList ) {
        if (iArticleReadService.removeByIds(idList)) {
            return R.success(true);
        }
        return R.failed();
    }

    //批量插入
    @PostMapping("/listInsert")
    @LoginToken
    public R listInsert (@RequestBody List<ArticleRead> list ) {
        if (iArticleReadService.saveBatch(list)) {
            return R.success(true);
        }
        return R.failed();
    }
}
