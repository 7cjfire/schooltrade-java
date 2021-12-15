package com.yu.st.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * conditions
 *
 * @author
 */
@Data
@Component
public class Condition implements Serializable {
    private static final long serialVersionUID = 1L;
    //    @JSONField(name = "value")
    @JsonProperty(value = "value")
    private Integer id;
    /**
     * 新旧程度
     */
    private String name;
}