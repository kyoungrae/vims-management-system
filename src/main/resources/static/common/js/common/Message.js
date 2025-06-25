const Message = {};
Message.Label = {};
Message.Label.Array = {};
/**
 * 기본 CRUD MESSAGE가 기준이 되며 페이지별 특정 문구를 작성하여 사용합니다.
 * COMPLETE : 문장 종결이 완료
 * FAIL : 행위에 대한 실패를 알릴때
 * CONFIRM : 문장의 종결 표현이 판정 의문문.
 * CHECK : 특정 값이 존재 하지 않아 요구 할때
 * INFO : 정보성 메세지
 * */
// 기본 CRUD MESSAGE


Message.Label.Array["CHECK.ID"] = "아이디를 입력해 주세요";
Message.Label.Array["CHECK.PWD"] = "비밀번호를 입력해 주세요";

Message.Label.Array["BUTTON.SEARCH"] = "조회";
Message.Label.Array["BUTTON.RESET"] = "초기화";

Message.Label.Array["COMPLETE.INSERT"] = "등록완료";
Message.Label.Array["COMPLETE.READ"] = "조회완료";
Message.Label.Array["COMPLETE.UPDATE"] = "수정완료";
Message.Label.Array["COMPLETE.DELETE"] = "삭제완료";
Message.Label.Array["COMPLETE.PERMIT"] = "승인완료";
Message.Label.Array["COMPLETE.RETURN"] = "반납완료";
Message.Label.Array["COMPLETE.RETURN_CANCEL"] = "반납 취소 완료";
Message.Label.Array["COMPLETE.CANCEL"] = "취소완료";
Message.Label.Array["COMPLETE.SAVE"] = "저장완료";
Message.Label.Array["COMPLETE.RESEND"] = "재발송완료";

Message.Label.Array["CONFIRM.INSERT"] = "등록하시겠습니까?";
Message.Label.Array["CONFIRM.PERMIT"] = "승인하시겠습니까?";
Message.Label.Array["CONFIRM.DELETE"] = "삭제하시겠습니까?";
Message.Label.Array["CONFIRM.UPDATE"] = "수정하시겠습니까?";
Message.Label.Array["CONFIRM.RESET"] = "초기화하시겠습니까?";
Message.Label.Array["CONFIRM.CANCEL"] = "취소하시겠습니까?";
Message.Label.Array["CONFIRM.RESEND"] = "재발송하시겠습니까?";

Message.Label.Array["FAIL.INSERT"] = "등록실패";
Message.Label.Array["FAIL.SELECT"] = "조회실패";
Message.Label.Array["FAIL.SELECT_NO_DATA"] = "데이터가 존재 하지 않습니다";
Message.Label.Array["FAIL.UPDATE"] = "수정실패";
Message.Label.Array["FAIL.DOWNLOAD"] = "다운로드실패";
Message.Label.Array["FAIL.DELETE"] = "삭제실패";
Message.Label.Array["FAIL.PERMIT"] = "승인실패";
Message.Label.Array["FAIL.RETURN"] = "반납실패";
Message.Label.Array["FAIL.RETURN_CANCEL"] = "반납 취소 실패";
Message.Label.Array["FAIL.LOGIN"] = "로그인실패";
Message.Label.Array["FAIL.IDPWD"] = "아이디 또는 비밀번호가 일치하지 않습니다";
Message.Label.Array["FAIL.REQUIRED"] = "필수 입력값을 입력해 주세요";
Message.Label.Array["FAIL.FUNCTION.POPUP"] = "팝업 호출 메소드가 없습니다";
Message.Label.Array["FAIL.NOT.EXIST.DISABLED"] = "data-gi-tag-disabled 태그가 설정되어 있지 않습니다";
Message.Label.Array["FAIL.SAME.PASSWORD"] = "새 비밀번호가 기존 비밀번호와 같습니다";
Message.Label.Array["FAIL.NOT.MATCHED.PASSWORD"] = "기존 비밀번호가 일치 하지 않습니다";
Message.Label.Array["FAIL.COMPARE.PASSWORD"] = "비밀번호가 일치하지 않습니다.";

Message.Label.Array["CHECK.FORMTYPE"] = "형식에 맞게 입력해 주세요";
Message.Label.Array["CHECK.DATA_ATTRIBUTE"] = "태그 속성을 다시 확인해 주세요";
Message.Label.Array["CHECK.MATCH.PASSWORD"] = "기존 비밀번호를 입력해주세요";

Message.Label.Array["CHECK.INPUT.PASSWORD"] = "비밀번호(을)를 입력해주세요";
Message.Label.Array["CHECK.INPUT.PASSWORD_CHECK"] = "비밀번호 확인(을)를 입력해주세요";

Message.Label.Array["ALREADY.USE.EXIST.EMAIL"] = "이미 사용중인 이메일 입니다";


Message.Label.Array["BEFORE_PASSWORD"] = "기존비밀번호";


Message.Label.Array["COMPLETE.AUDIT"] = "심사처리 완료";
Message.Label.Array["FAIL.AUDIT"] = "심사처리 과정중 오류가 발생 하였습니다";
Message.Label.Array["CONFIRM.AUDIT"] = "심사 접수 하시겠습니까?";

Message.Label.Array["COMPLETE.PAYMENT_WAIT"] = "비용납부대기 처리 완료";
Message.Label.Array["FAIL.PAYMENT_WAIT"] = "비용납부대기 처리 과정중 오류가 발생 하였습니다";
Message.Label.Array["CONFIRM.PAYMENT_WAIT"] = "비용납부대기 처리 하시겠습니까?";

Message.Label.Array["COMPLETE.PAYMENT_RECEIPT_APPROVAL"] = "납부승인 완료";
Message.Label.Array["FAIL.PAYMENT_RECEIPT_APPROVAL"] = "납부승인 과정중 오류가 발생 하였습니다";
Message.Label.Array["CONFIRM.PAYMENT_RECEIPT_APPROVAL"] = "납부승인 완료처리 하시겠습니까?";

Message.Label.Array["COMPLETE.AUDIT_APPROVAL"] = "심사승인완료";
Message.Label.Array["FAIL.AUDIT_APPROVAL"] = "심사승인 과정중 오류가 발생 하였습니다";
Message.Label.Array["CONFIRM.AUDIT_APPROVAL"] = "심사승인 완료처리 하시겠습니까?";
Message.Label.Array["CONFIRM.UPDATE_APPROVAL"] = "변경 심사승인 완료처리 하시겠습니까?";

Message.Label.Array["COMPLETE.REJECTION"] = "반려처리 완료";
Message.Label.Array["FAIL.REJECTION"] = "반려처리 과정중 오류가 발생 하였습니다";
Message.Label.Array["CONFIRM.REJECTION"] = "반려처리 하시겠습니까?";
Message.Label.Array["REASON.REJECTION"] = "반려처리 사유를 입력해 주세요";
Message.Label.Array["REASON"] = "반려사유";
Message.Label.Array["WAITING"] = "대기중";

Message.Label.Array["FEE_PAYMENT_YN"] = "납부하지 않은 수수료가 존재합니다<br>수수료 납부 후 진행해 주세요";

Message.Label.Array["REASON.DRIVING_SECTION"] = "운행구간을 입력해 주세요";
Message.Label.Array["DRIVING_SECTION"] = "운행구간";
Message.Label.Array["CONFIRM.RETURN"] = "임시운행 반납 하시겠습니까?";

Message.Label.Array["COMPLETE.UPDATE_APPROVAL"] = "변경등록 승인완료";
Message.Label.Array["FAIL.UPDATE_APPROVAL"] = "변경등록 과정중 오류가 발생 하였습니다";
Message.Label.Array["CONFIRM.UPDATE_APPROVAL"] = "변경등록 완료처리 하시겠습니까?";

Message.Label.Array["COMPLETE.REISSUE_APPROVAL"] = "재발급 승인완료";
Message.Label.Array["FAIL.REISSUE_APPROVAL"] = "재발급 과정중 오류가 발생 하였습니다";
Message.Label.Array["CONFIRM.REISSUE_APPROVAL"] = "재발급 완료처리 하시겠습니까?";

Message.Label.Array["FAIL.DELETE.REASON.EXIST_CHILD_DATA"] = "하위 데이터가 존재하기 때문에 삭제 실패 하였습니다";
Message.Label.Array["MAXIMUM.UPLOAD.SIZE.100MB"] = "파일 업로드 용량은 100 MB를 초과할 수 없습니다";

Message.Label.Array["ALERT.NO.FILE"] = "선택 된 파일이 없습니다";
Message.Label.Array["ALERT.NO.CHANGED.FILE"] = "변경 된 내용이 없습니다";
Message.Label.Array["CONFIRM.CLOSE_UNSAVED_CHANGES"] = "저장되지 않은 변경 사항이 있습니다. 창을 닫으시겠습니까?";

Message.Label.Array["REGISTER_BTN"] = "등록";
Message.Label.Array["MODIFY_BTN"] = "수정";
Message.Label.Array["DETAIL_BTN"] = "상세";
Message.Label.Array["SEARCH_BTN"] = "조회";
Message.Label.Array["RESET_BTN"] = "초기화";
Message.Label.Array["MORE_BTN"] = "더보기";
Message.Label.Array["BACK_BTN"] = "뒤로가기";
Message.Label.Array["START_DATE"] = "시작일";
Message.Label.Array["END_DATE"] = "종료일";
Message.Label.Array["FILE_DOWN_BTN"] = "첨부파일 다운로드";
Message.Label.Array["FILE_NAME"] = "첨부파일";
Message.Label.Array["FILE_REGISTER_BTN"] = "파일추가";