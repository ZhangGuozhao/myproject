package com.yihaomen.controller;

import com.yihaomen.dao.UserDAO;
import com.yihaomen.inter.UserMapper;
import com.yihaomen.model.Article;

import com.yihaomen.model.User;
import com.yihaomen.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ZhangGuozhao on 2017/10/19.
 */
@Controller
@RequestMapping("/article")
public class UserController {
//想要自动注入成功需要在spring中配制bean
    @Autowired
    private UserDAO userDAO;
//
    @Autowired
    private UserMapper userMapper;

   @RequestMapping("/list")
    public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("张伟");
        List<Article> articles = userMapper.getUserArticles2(1);
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("articles", articles);
        return mav;
    }

    @RequestMapping("/pagelist")
    public ModelAndView pageList(HttpServletRequest request,HttpServletResponse response){
        int currentPage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
        int pageSize = 3;
        if (currentPage<=0){
            currentPage =1;
        }
        int currentResult = (currentPage-1) * pageSize;

        System.out.println(request.getRequestURI());
        System.out.println(request.getQueryString());

        PageInfo page = new PageInfo();
        page.setShowCount(pageSize);
        page.setCurrentResult(currentResult);
        List<Article> articles= userMapper.selectArticleListPage(page,1);

        System.out.println(page);


        int totalCount = page.getTotalResult();

        int lastPage=0;
        if (totalCount % pageSize==0){
            lastPage = totalCount % pageSize;
        }
        else{
            lastPage =1+ totalCount / pageSize;
        }

        if (currentPage>=lastPage){
            currentPage =lastPage;
        }

        String pageStr = "";

        pageStr=String.format("<a href=\"%s\">上一页</a>    <a href=\"%s\">下一页</a>",
                request.getRequestURI()+"?page="+(currentPage-1),request.getRequestURI()+"?page="+(currentPage+1) );


        //制定视图，也就是list.jsp
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("articles",articles);
        mav.addObject("pageStr",pageStr);
        return mav;
    }
    @RequestMapping("/search")
    public ModelAndView search(HttpServletRequest request,HttpServletResponse response){

//        List<Article> articles=userMapper.getUserArticles1(user.getId());
        //制定视图，也就是list.jsp

        ModelAndView mav = new ModelAndView("search");
//        mav.addObject("articles", articles);
        return mav;
    }
    @RequestMapping("/searchResult")
    public ModelAndView search(HttpServletRequest request,HttpServletResponse response,User user){

        List<Article> articles= userMapper.getUserArticles1(user.getId());
        //制定视图，也就是list.jsp
        System.out.println(user.getId());
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("articles", articles);
        return mav;
    }

    @RequestMapping("/daolist")
    public ModelAndView listalldao(HttpServletRequest request,HttpServletResponse response){
        List<Article> articles=userDAO.getUserArticles(1);
        //制定视图，也就是list.jsp
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("articles",articles);
        return mav;
    }

}
