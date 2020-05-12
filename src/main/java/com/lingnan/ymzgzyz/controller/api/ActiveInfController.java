package com.lingnan.ymzgzyz.controller.api;


import com.lingnan.ymzgzyz.model.R;
import com.lingnan.ymzgzyz.model.entity.ActiveInf;
import com.lingnan.ymzgzyz.service.IActiveInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 * 活动信息 前端控制器
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
@RestController
@RequestMapping("/ymzgzyz/active-inf")
public class ActiveInfController {
    @Autowired
    IActiveInfService iActiveInfService;

    @PostMapping("/test")
    public String test(){
        return "test";
    }

    //    返回全部活动详细信息
    @PostMapping("/list")
    public List<ActiveInf> getActiveInfList(){
        List<ActiveInf> list = new ArrayList<>();
        list = iActiveInfService.list();
        return list;
    }

    //    根据id查询，返回ActiveInf对象
    @PostMapping("/get-one")
    public ActiveInf getActiveInfById( @RequestBody ActiveInf activeInf )
    {
        Integer id = activeInf.getId();
        return iActiveInfService.getById(id);
    }

    //    根据id更新,返回boolean值
    @PostMapping("/update")
    public boolean updateActiveInfById(@RequestBody ActiveInf activeInf)
    {
        return iActiveInfService.saveOrUpdate(activeInf);
    }

    //    插入记录
    @PostMapping("/insert")
    public boolean insertActiveInf(@RequestBody ActiveInf activeInf)
    {
        return iActiveInfService.save(activeInf);
    }

    //    删除记录
    @PostMapping("/delete")
    public boolean deleteActiveInf(@RequestBody ActiveInf activeInf)
    {
        Integer id = activeInf.getId();
        return iActiveInfService.removeById(id);
    }

    /**
     * 其他条件查询
     */

    //userRole
    @PostMapping("/getByUserRole")
    public List<ActiveInf> getByUserRole (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByUserRole(activeInf.getUserRole());
    }

    //userId
    @PostMapping("/getByUserId")
    public List<ActiveInf> getByUserId (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByUserId(activeInf.getUserId());
    }

    //company
    @PostMapping("/getByCompany")
    public List<ActiveInf> getByCompany (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByCompany(activeInf.getCompany());
    }

    //boss
    @PostMapping("/getByBoss")
    public List<ActiveInf> getByBoss (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByBoss(activeInf.getBoss());
    }

    //states
    @PostMapping("/getByStates")
    public List<ActiveInf> getByStates (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByStates(activeInf.getStates());
    }

    //查询在某个时间发布的活动
    @PostMapping("/getByAttendTime")
    public List<ActiveInf> getByAttendTime (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByAttendTime(activeInf.getAttendTime());
    }


    //查询某个时间截止报名的活动
    @PostMapping("/getByCloseTime")
    public List<ActiveInf> getByCloseTime (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByCloseTime(activeInf.getCloseTime());
    }

    //查询未截止报名的活动

    /**
     * 判断获得的时间是否在attendTime和closeTime区间中
     * @param nowDate 前端不能返回Date类型的数据，所以用String代替，然后转格式
     * @return R
     * @throws ParseException
     */
    @PostMapping("/getByNotClose")
    public R getByNotClose ( String nowDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(nowDate);
        //获得所有数据，把数据其中的attendTime存在list中
        List<Date> aList = new ArrayList<>();
        aList = iActiveInfService.list().stream().map(ActiveInf::getAttendTime).distinct().collect(Collectors.toList());
        //存closeTime
        List<Date> cList = new ArrayList<>();
        cList = iActiveInfService.list().stream().map(ActiveInf::getCloseTime).distinct().collect(Collectors.toList());
        //new一个用来存储id的list
        List<Integer> list = new ArrayList<>();
        //遍历aList
        for (Date attendDate: aList) {
            //判断获得时间是否在attendTime之后
            if (date.after(attendDate) || date.equals(attendDate)) {
                //遍历cList
                for (Date closeDate: cList) {
                    //判断获得时间是否在closeTime之前
                    if (date.before(closeDate) || date.equals(closeDate))
                    {
                        //通过符合条件的closeTime获得id，存入list，每次遍历的list合并
                        list.addAll(iActiveInfService.getByCloseTime(closeDate).stream().map(ActiveInf::getId).collect(Collectors.toList()));
                    }
                }
            }
        }
        System.out.println(list);
        if (list.isEmpty())
        {
            return R.message("无查询结果");
        }
        return R.success(iActiveInfService.listByIds(list));
    }

    //查询已截止报名的活动
    @PostMapping("/getByClosed")
    public List<ActiveInf> getByClosed (String nowDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(nowDate);
        List<ActiveInf> list = new ArrayList<>();
        list = iActiveInfService.getByAfterCloseTime(date);
        return list;
    }

    //查询已截止的活动
    @PostMapping("/getByEnd")
    public List<ActiveInf> getByEnd (String nowDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(nowDate);
        return iActiveInfService.getByAfterEndTime(date);
    }

    //查询未截止的活动
    @PostMapping("/getByNotEnd")
    public R getByNotEnd ( String nowDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(nowDate);
        List<Date> sList = new ArrayList<>();
        sList = iActiveInfService.list().stream().map(ActiveInf::getStartTime).distinct().collect(Collectors.toList());
        List<Date> eList = new ArrayList<>();
        eList = iActiveInfService.list().stream().map(ActiveInf::getEndTime).distinct().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        for (Date startDate: sList) {
            if (date.after(startDate) || date.equals(startDate)) {
                for (Date endDate: eList) {
                    if (date.before(endDate) || date.equals(endDate))
                    {
                        list.addAll(iActiveInfService.getByEndTime(endDate).stream().map(ActiveInf::getId).distinct().collect(Collectors.toList()));
                    }
                }
            }
        }
        System.out.println(list.toString());
        if (list.isEmpty())
        {
            return R.message("无查询结果");
        }
        return R.success(iActiveInfService.listByIds(list));
    }

    //根据标题模糊查询
    @PostMapping("/getByTitle")
    public List<ActiveInf> getByTitle (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByTitle(activeInf.getTitle());
    }

    //content 模糊查询
    @PostMapping("/getByContent")
    public List<ActiveInf> getByContent (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByContent(activeInf.getContent());
    }

    //peopleNum
    @PostMapping("/getByPN")
    public List<ActiveInf> getByPN (@RequestBody ActiveInf activeInf) {
        return iActiveInfService.getByPN(activeInf.getPeopleNum());
    }

    //peopleNum < num
    @PostMapping("/getByGreaterThanPN")
    public List<ActiveInf> getByGreaterThanPN ( Integer num) {
        return iActiveInfService.getByGreaterThanPN(num);
    }

    //peopleNum > num
    @PostMapping("/getByLessThanPN")
    public List<ActiveInf> getByLessThanPN ( Integer num) {
        return iActiveInfService.getByLessThanPN(num);
    }

    //peopleNum in [num1 , num2]
    @PostMapping("/getByExtent")
    public List<ActiveInf> getByExtent (Integer num1 , Integer num2) {
        return iActiveInfService.getByExtent(num1 , num2);
    }

}
