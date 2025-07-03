package com.vims.common.siteconfig;

import com.system.common.base.CommonMapper;
import com.system.common.util.passwordvalidation.PasswordPolicy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommonSiteConfigMapper extends CommonMapper<CommonSiteConfig> {
    Map<String, String> SELECT_VALUES_BY_KEYS(List<String> config_keys);

    int MERGE(CommonSiteConfig commonSiteConfig);

    String[] SELECT_GROUP();

    PasswordPolicy SELECT_PASSWORD_POLICY();
}