package com.example.demo.deletesoon;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/7 18:01
 */
public class ToSuccess {

    @Test
    public void index() {
        ArrayList<TestIndexVo> testIndexVos = new ArrayList<TestIndexVo>();
    }

    @Test
    public void title() {
        ArrayList<TestTitleVo> testTitleVos = new ArrayList<TestTitleVo>();

        final HashMap<String, List> project = new HashMap<>();
        for (TestTitleVo testTitleVo : testTitleVos) {
            final String projectName = testTitleVo.getProjectName();
            final HashMap<String, String> index = new HashMap<>();
            index.put("titleId", testTitleVo.getReportTitleId());
            index.put("titleName", testTitleVo.getTitleName());
            index.put("titleUnit", testTitleVo.getTitleUnit());
            if (project.containsKey(projectName)) {
                project.get(projectName).add(index);
            } else {
                project.put(testTitleVo.getProjectName(),new ArrayList(Collections.singletonList(index)));
            }
        }
        final ArrayList<Object> titles = new ArrayList<>();
        for (Map.Entry<String,List> entry : project.entrySet()){
            final String key = entry.getKey();
            final HashMap<String, Object> re = new HashMap<>();
            re.put("label",key);
            re.put("list",entry.getValue());
            titles.add(re);
        }

    }
    @Test

    public void test1(){



        final HashMap<String, List> project = new HashMap<>();
        project.put("a",new ArrayList(Arrays.asList("222q")));
        System.err.println(project);

        project.get("a").add("aaaa");
        System.err.println(project);
    }

    public static void main(String[] args) {
    }
}
