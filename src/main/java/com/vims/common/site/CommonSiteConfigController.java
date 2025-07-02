package com.vims.common.site;

import com.system.common.base.AbstractCommonController;
import com.system.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cms/common/site/siteConfig")
@RequiredArgsConstructor
public class CommonSiteConfigController extends AbstractCommonController<CommonSiteConfig> {

    private final CommonSiteConfigService commonSiteConfigService;
    private final CommonSiteConfigRepository commonSiteConfigRepository;

    @PostMapping("/findPage")
    public Map<String, List<?>> findPage(@RequestBody CommonSiteConfig reqeust) throws Exception {
        return commonSiteConfigService.findPage(reqeust);
    }

    @PostMapping("/findGroupByConfigGroupIdPage")
    public Map<String, List<?>> findGroupPage(@RequestBody CommonSiteConfig reqeust) throws Exception {
        return commonSiteConfigService.findGroupByConfigGroupIdPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<CommonSiteConfig> findAll(@RequestBody CommonSiteConfig request) throws Exception {
        return commonSiteConfigRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<CommonSiteConfig> findImpl(@RequestBody CommonSiteConfig request) throws Exception {
        return commonSiteConfigService.findImpl(request);
    }

    @PostMapping("/findGroup")
    public String[] findGroup() throws Exception {
        return commonSiteConfigService.findGroup();
    }

    @PostMapping("/findValuesByKeys")
    protected Map<String, String> findValuesByKeys(@RequestBody List<String> request) throws Exception {
        return commonSiteConfigService.findValuesByKeys(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody CommonSiteConfig request) {
        return commonSiteConfigService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody CommonSiteConfig request) {
        return commonSiteConfigService.updateImpl(request);
    }

//    @PostMapping("/merge")
//    protected int merge(@RequestBody CommonSiteConfig request) {
//        return commonSiteConfigService.merge(request);
//    }

//    @PostMapping("/mergeList")
//    protected int mergeList(@RequestBody List<CommonSiteConfig> request) {
//        return commonSiteConfigService.merge(request);
//    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody CommonSiteConfig request) {
        return commonSiteConfigService.registerImpl(request);
    }

    @PostMapping("/registerWithConflictCheck")
    protected int registerWithConflictCheck(@RequestBody CommonSiteConfig request) {
        try {
            return commonSiteConfigService.registerImpl(request);
        } catch (DuplicateKeyException e) {
            throw new CustomException("IS_ALREADY_EXISTS");
        }
    }
}