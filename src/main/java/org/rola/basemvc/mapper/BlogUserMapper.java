package org.rola.basemvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.rola.basemvc.bean.BlogUser;

/**
 * @author D
 * @date 2022/7/11
 * @Class UserMapper
 * @description TODO
 */
@Mapper
public interface BlogUserMapper {
    int addBlogUser();

    BlogUser getAllUser();
}
