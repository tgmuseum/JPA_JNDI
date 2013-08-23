package com.springapp.mvc;

import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: LSK
 * Date: 13. 8. 16
 * Time: 오후 4:02
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "ComnRes")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComnRes extends BaseWrapper {

    /** 응답 결과 코드 */
    String result = "0";

    /** 응답 메시지 */
    String message = "SUCCESS";


    /**
     * Gets result.
     *
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
