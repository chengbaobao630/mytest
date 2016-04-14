package cc.firstTest.Service.Impl;

import cc.firstTest.Service.AccountCaptchaService;
import cc.firstTest.Service.RandomGenerator;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by cheng on 2016/3/22 0022.
 */
@Service
public class AccountCaptchaServiceImpl implements AccountCaptchaService,InitializingBean {

    private DefaultKaptcha producer;

    private Map<String,String> captchaMap=new HashMap<>();

    private int textCount=0;

    private List<String> preDefinedTexts;
    @Override
    public String generateCaptchaKey() throws Exception {
        String key= RandomGenerator.getRandomString();
        String value=getCaptchaText();
        captchaMap.put(key,value);
        return key;
    }

    private String getCaptchaText() {
        if(preDefinedTexts!=null&&!preDefinedTexts.isEmpty()){
            String text=preDefinedTexts.get(textCount);
            textCount=(textCount+1)%preDefinedTexts.size();
            return  text;
        }else{
            return producer.createText();
        }
    }

    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws Exception {
        String text=captchaMap.get(captchaKey);
        if(text==null){
            throw new Exception("Captcha key "+captchaKey+"not found");
        }
        BufferedImage image=producer.createImage(text);

        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try{
            ImageIO.write(image,"jpg",out);
        }catch (IOException e){
            throw new Exception("fail to draw captcha stream",e);
        }
        return out.toByteArray();
    }

    @Override
    public boolean vilidateCaptcha(String captchaKey, String captchaValue) throws Exception {

        String text=captchaMap.get(captchaKey);
        if (text==null){
            throw  new Exception("Captcha key "+captchaKey+"not found");
        }
        if(text.equals(captchaValue)){
            captchaMap.remove(captchaKey);
            return true;
        }
        return false;
    }

    @Override
    public List<String> getPreDefinedText() {
        return this.preDefinedTexts;
    }

    @Override
    public void setPreDefinedText(List<String> preDefinedTexts) {
        this.preDefinedTexts=preDefinedTexts;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        producer=new DefaultKaptcha();

        producer.setConfig(new Config(new Properties()));
    }
}
