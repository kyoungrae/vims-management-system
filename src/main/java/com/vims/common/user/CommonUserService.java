/**
 *  ++ giens Product ++
 */
package com.vims.common.user;

import com.system.auth.authuser.AuthUser;
import com.system.common.base.AbstractCommonService;
import com.system.common.exception.CustomException;
import com.system.common.util.passwordvalidation.PasswordPolicy;
import com.system.common.util.passwordvalidation.PasswordValidationUtil;
import com.system.common.util.validation.ValidationService;
import com.vims.common.siteconfig.CommonSiteConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonUserService extends AbstractCommonService<CommonUser> {
    private final CommonUserMapper commonUserMapper;
    private final CommonUserRepository commonUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final MessageSource messageSource;
    private final CommonSiteConfigService commonSiteConfigService;

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }
    @Override
    protected List<CommonUser> selectPage(CommonUser request) throws Exception {
        try{
            return commonUserMapper.SELECT_PAGE(request);
        }catch (Exception e){
            throw new CustomException(getMessage(""));
        }
    }

    @Override
    protected int selectPagingTotalNumber(CommonUser request) throws Exception {
        try{
          return commonUserMapper.SELECT_PAGING_TOTAL_NUMBER(request);
        }catch (Exception e){
            throw new CustomException(getMessage(""));
        }
    }
    @Override
    protected List<CommonUser> findImpl(CommonUser request) throws Exception {
        try{
            return commonUserMapper.SELECT(request);
        }catch (Exception e){
            throw new CustomException(getMessage(""));
        }

    }

    @Override
    protected int removeImpl(CommonUser request) {
        try{
            return commonUserMapper.DELETE(request);
        }catch (Exception e){
            throw new CustomException(getMessage(""));
        }
    }

    @Transactional(rollbackFor = Exception.class)
    protected int removeToken(AuthUser request) throws Exception {
        int rtn = 0;
        try {
            rtn = commonUserMapper.DELETE_TOKEN(request);
        } catch (Exception e) {
            throw new Exception(e + ": Fail to Remove Token");
        }
        return rtn;
    }

    @Transactional(rollbackFor = Exception.class)
    protected int removeUser(CommonUser request) throws Exception {
        int rtn = 0;
        try {
            rtn = commonUserMapper.DELETE(request);
        } catch (Exception e) {
            throw new Exception(e + ": Fail to Remove User");
        }
        return rtn;
    }

    @Override
    protected int updateImpl(CommonUser request) {
        ValidationService validationService = new ValidationService();
        boolean flag = validationService.checkEmptyValue(request.getPassword());
        if(flag){
            List<String> failReasons = validatePasswordPolicy(request.getPassword());
            if (failReasons.size() > 0) {
                throw new CustomException(failReasons.get(0));
            }
            request.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        return commonUserMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(CommonUser request) {
        List<String> failReasons = validatePasswordPolicy(request.getPassword());
        if (failReasons.size() > 0) {
            throw new CustomException(failReasons.get(0));
        }

        return commonUserMapper.INSERT(request);
    }

//    public boolean matchToPassword(CommonUser request){
//        var commonUser = CommonUser.builder()
//                .id(request.getId())
//                .build();
//        List<CommonUser> userList = commonUserMapper.SELECT(commonUser);
//        String before_password_encoded = userList.get(0).getPassword();
//        return passwordEncoder.matches(request.getBefore_password(),before_password_encoded);
//    }
//
//    public String getUserImageUrlByUserEmail(String email) {
//        // TODO 이미지 호출 방식이 변경되면 여기도 바껴야 함
//        String fileName = commonUserMapper.GET_USER_IMAGE_FILE_NAME_BY_EMAIL(email);
//        if(fileName == null || fileName.isEmpty()){
//            return ""; // return null을 하면 에러나서 빈값 리턴
//        }
//        String imagePath = ApplicationResource.get("application.properties").get("imgPath").toString();
//        String filePath = ApplicationResource.get("application.properties").get("filePath").toString();
//        return imagePath + "?fileId=" + fileName + "&basePath=" + filePath + "/userImgFolder";
//    }

    public int changePassword(CommonUser request) {
        var commonUser = CommonUser.builder().email(request.getEmail()).build();
        List<CommonUser> users = commonUserMapper.SELECT(commonUser);

        if (users == null || users.isEmpty() || users.size() != 1) {
            throw new UsernameNotFoundException("NO_USER");
        }

        List<String> failReasons = validatePasswordPolicy(request.getPassword());
        if (failReasons.size() > 0) {
            throw new CustomException(failReasons.get(0));
        }

        if (!passwordEncoder.matches(request.getBefore_password(), users.get(0).getPassword())) {
            throw new CustomException(getMessage("EXCEPTION.PASSWORD.NOT.MATCH"));
        }

        var commonUserBean = CommonUser.builder()
                .id(users.get(0).getId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        return commonUserMapper.UPDATE(commonUserBean);
    }

    public List<String> validatePasswordPolicy(String newPassword) {
        PasswordPolicy policy = commonSiteConfigService.getPasswordPolicy();
        PasswordValidationUtil passwordValidationUtil = new PasswordValidationUtil();
        return passwordValidationUtil.validatePassword(newPassword, policy);
    }

//    public int initializePassword(CommonUser request) {
//        var commonUser = CommonUser.builder().email(request.getEmail()).build();
//        List<CommonUser> users = commonUserMapper.SELECT(commonUser);
//
//        if (users == null || users.isEmpty() || users.size() != 1) {
//            throw new UsernameNotFoundException("NO_USER");
//        }
//
//        List<String> failReasons = validatePasswordPolicy(request.getPassword());
//        if (failReasons.size() > 0) {
//            throw new CustomException(failReasons.get(0));
//        }
//
//        var commonUserBean = CommonUser.builder().id(users.get(0).getId())
//                .password(passwordEncoder.encode(request.get_password())).build();
//        return commonUserMapper.UPDATE(commonUserBean);
//    }
}