package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.response.BaseOrder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

@Controller
public class Order extends BaseOrder {

    @JsonProperty("payload")
    @Valid
    private List<Food> payload = null;

    public Order() {

    }

    public Order(BaseOrder base) {
        this.id(base.getId());
        this.complete(base.isComplete());
        this.status(base.getStatus());
        this.setPlacedBy(base.getPlacedBy());
        this.donationPriority(base.getDonationPriority());
        this.orderDate(base.getOrderDate());
    }

    public List<Food> getPayload() {
        return payload;
    }

    public void setPayload(List<Food> payload) {
        this.payload = payload;
    }
}

