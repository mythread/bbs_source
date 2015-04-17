/*
 * Copyright (C), 2014-2014, 上海澍勋电子商务有限公司
 * FileName: PictureTopicServiceImpl.java
 * Author:   jie.xu
 * Date:     2014年12月18日 下午2:05:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.core.GenericMapper;
import com.bbs.core.GenericServiceImpl;
import com.bbs.mapper.PictureTopicMapper;
import com.bbs.model.PictureTopic;
import com.bbs.model.PictureTopicExample;
import com.bbs.service.PictureTopicService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author jie.xu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("pictureTopicService")
public class PictureTopicServiceImpl extends GenericServiceImpl<PictureTopic, PictureTopicExample, Integer> implements
        PictureTopicService {

    @Autowired
    private PictureTopicMapper mapper;

    @Override
    protected GenericMapper<PictureTopic, PictureTopicExample, Integer> getGenericMapper() {
        return mapper;
    }

}
