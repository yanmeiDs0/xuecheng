package com.xuecheng.framework.model.response;

import lombok.Data;
import lombok.ToString;

/**
 * 操作返回的所有结果
 *
 */
@Data
@ToString
public class QueryResponseResult extends ResponseResult {

    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
