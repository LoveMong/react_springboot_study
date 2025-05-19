package com.jy.study.utill;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


/**
 * Utility class for handling message retrieval from resource bundles using MessageSource.
 */

@Component
public class MessagesUtil {

    private final MessageSource messageSource;

    // 생성자를 통해 의존성을 전달하는 방식(불변성 유지, 필요한 의존성 확인이 명확, 테스트 시 mock 객체 쉽게 주입 등)
    public MessagesUtil(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String key, Locale locale) {
        if(locale == null) {
            locale = Locale.KOREAN; // Null인 경우 기본값으로 한국어 로케일 설정
        }
        return messageSource.getMessage(key, null, locale);
    }

}
