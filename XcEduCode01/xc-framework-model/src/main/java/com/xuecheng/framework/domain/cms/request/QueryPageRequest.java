package com.xuecheng.framework.domain.cms.request;

import com.xuecheng.framework.model.request.RequestData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//模型对象
@Data
public class QueryPageRequest extends RequestData {
    //接收页面查询的查询条件
    //站点ID
    @ApiModelProperty("站点id")
    private String siteId;
    //页面ID
    @ApiModelProperty("页面ID")
    private String pageId;
    //模板ID
    @ApiModelProperty("模版id")
    private String templateId;
    //别名
    @ApiModelProperty("页面别名")
    private String pageAliase;
    //页面名称
    @ApiModelProperty("页面名称")
    private String pageName;
}
