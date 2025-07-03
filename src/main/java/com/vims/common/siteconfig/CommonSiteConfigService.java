/**
 * ++ giens Product ++
 */
package com.vims.common.siteconfig;

import com.system.common.base.AbstractCommonService;
import com.system.common.util.passwordvalidation.PasswordPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CommonSiteConfigService extends AbstractCommonService<CommonSiteConfig> {
    private final CommonSiteConfigMapper commonSiteConfigMapper;
    private final CommonSiteConfigRepository commonSiteConfigRepository;
    private final MessageSource messageSource;

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<CommonSiteConfig> selectPage(CommonSiteConfig request) throws Exception {
        return commonSiteConfigMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(CommonSiteConfig request) throws Exception {
        return commonSiteConfigMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }

    public String[] findGroup() throws Exception {
        return commonSiteConfigMapper.SELECT_GROUP();
    }

    @Override
    protected List<CommonSiteConfig> findImpl(CommonSiteConfig request) throws Exception {
        return commonSiteConfigMapper.SELECT(request);
    }

    public Map<String, String> findValuesByKeys(List<String> request) throws Exception {
        return commonSiteConfigMapper.SELECT_VALUES_BY_KEYS(request);
    }

    @Override
    protected int removeImpl(CommonSiteConfig request) {
        return commonSiteConfigMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(CommonSiteConfig request) {
        return commonSiteConfigMapper.UPDATE(request);
    }
    @Override
    protected int registerImpl(CommonSiteConfig request) {
        return commonSiteConfigMapper.INSERT(request);
    }

    public int merge(CommonSiteConfig request) {
        return commonSiteConfigMapper.MERGE(request);
    }

    @Transactional(rollbackFor = Exception.class)
    public int merge(List<CommonSiteConfig> request) {
        int result = 0;

        for (CommonSiteConfig commonSiteConfig : request) {
            result += commonSiteConfigMapper.MERGE(commonSiteConfig);
        }

        return result;
    }



    public PasswordPolicy getPasswordPolicy() {
        return commonSiteConfigMapper.SELECT_PASSWORD_POLICY();
    }
}