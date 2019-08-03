package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void findAllTest(){
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);

    }
    @Test
    public void findPageTest(){
        int page=1;
        int size=10;
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);

    }

    //修改
    @Test
    public void testUpdate() {
        //jdk1.8推出Optional
        //查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5a754adf6abb500ad05688d9");
        if (optional.isPresent()){
            //设置要修改的值
            CmsPage cmsPage = optional.get();
            cmsPage.setPageAliase("首页1");
            //修改
            cmsPageRepository.save(cmsPage);

        }
    }
    //根据页面名称查询
    @Test
    public void find(){
        CmsPage pageName = cmsPageRepository.findByPageName("index_category.html");
        System.out.println(pageName);

    }


}
