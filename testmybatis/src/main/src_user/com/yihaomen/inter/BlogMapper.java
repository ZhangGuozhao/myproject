package com.yihaomen.inter;

import com.yihaomen.model.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by ZhangGuozhao on 2017/10/23.
 */
public interface BlogMapper {

    Blog dynamicIfTest(Blog blog);

    Blog dynamicChooseTest(Blog blog);

    Blog dynamicTrimTest(Blog blog);

    Blog dynamicWhereTest(Blog blog);

    void dynamicSetTest(Blog blog);

    List<Blog> dynamicForeachTest(List<Integer> ids);

    List<Blog> dynamicForeach2Test(int[] ids);

    List<Blog> dynamicForeach3Test(Map<String, Object> map);

    List<Blog> dynamicForeach4Test(Map<String, Object> map);


}
