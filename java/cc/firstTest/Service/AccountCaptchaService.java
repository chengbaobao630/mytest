package cc.firstTest.Service;

import java.util.List;

/**
 * Created by cheng on 2016/3/22 0022.
 */
public interface AccountCaptchaService {

    String generateCaptchaKey() throws  Exception;

    byte[] generateCaptchaImage(String captchaKey) throws  Exception;

    boolean vilidateCaptcha(String captchaKey,String captchaValue) throws  Exception;

    List<String> getPreDefinedText();

    void setPreDefinedText(List<String> preDefinedTexts);
}
