/**
 *  ++ giens Product ++
 */
package com.vims.common.menu;

import com.system.common.base.AbstractCommonService;
import com.system.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonMenuService extends AbstractCommonService<CommonMenu> {
    private final CommonMenuMapper commonMenuMapper;
    private final CommonMenuRepository commonMenuRepository;
    private final MessageSource messageSource;

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }
    public List<CommonMenu> findHierarchy(CommonMenu request) throws Exception {
        return commonMenuMapper.SELECT_HIERARCHY(request);
//        return commonMenuMapper.SELECT_HIERARCHY_WITH_ACCESS_RIGHT_GROUP(request);
    }
    @Override
    protected List<CommonMenu> selectPage(CommonMenu request) throws Exception {
        return commonMenuMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(CommonMenu request) throws Exception {
        return commonMenuMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<CommonMenu> findImpl(CommonMenu request) throws Exception {
        return commonMenuMapper.SELECT(request);
    }
    public int removeMenuCode(CommonMenu request) throws Exception{
        var containTopMenuCode = CommonMenu.builder()
                .top_menu_code(request.getMenu_code())
                .build();
        var containMenuCode = CommonMenu.builder()
                .menu_code(request.getMenu_code())
                .menu_sequence(request.getMenu_sequence())
                .build();
        List<CommonMenu> list = commonMenuMapper.SELECT(containTopMenuCode);
        boolean childNodeExist = !list.isEmpty();
        try {
            if (childNodeExist) {
                throw new CustomException(getMessage("EXCEPTION.DELETE.EXIST.SBU_DATA"));
            } else {
                return commonMenuMapper.DELETE(containMenuCode);
            }
        }catch (CustomException ce){
            throw ce;
        }catch (Exception e){
            throw new Exception("FAIL TO REMOVE MENU",e);
        }
    }

    @Override
    protected int removeImpl(CommonMenu request) {
        try{
            return commonMenuMapper.DELETE(request);
        }catch (Exception e){
            throw new CustomException(getMessage("EXCEPTION.PK.EXIST.USER"));
        }
    }

    @Override
    protected int updateImpl(CommonMenu request) {
        try{
            return commonMenuMapper.UPDATE(request);
        }catch (Exception e){
            throw new CustomException(getMessage(""));
        }
    }

    @Override
    protected int registerImpl(CommonMenu request){
         try{
            return commonMenuMapper.INSERT(request);
         }catch (Exception e){
             throw new CustomException(getMessage("EXCEPTION.PK.EXIST"));
         }
    }
}