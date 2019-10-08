package io.swagger.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.List;

public class OrderDTO extends BaseOrder {

    @JsonProperty("payload")
    @Valid
    private List<String> payload = null;

    public List<String> getPayload() {
        return payload;
    }

    public void setPayload(List<String> payload) {
        this.payload = payload;
    }
}
