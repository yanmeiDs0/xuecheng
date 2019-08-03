package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PageService {
    @Autowired
    CmsPageRepository cmsPageRepository;



    /**
     * 分页查询
     * @param page 页码，从1开始计数
     * @param size 每页记录数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findAll( int page,int size, QueryPageRequest queryPageRequest){
        //分页参数
        if (page<=0){
            page=1;
        }
        page=page-1;//真正传给dao，dao要求页码从0开始，给页面是1
        if (size<=0){
            size=10;
        }
        Pageable pageable= PageRequest.of(page,size);
        Page<CmsPage> repositoryAll = cmsPageRepository.findAll(pageable);
        QueryResult queryResult = new QueryResult();//查询的数据结果集
        queryResult.setList(repositoryAll.getContent());//数据列表
        queryResult.setTotal(repositoryAll.getTotalElements());//数据总记录数
        QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;

    }
}
