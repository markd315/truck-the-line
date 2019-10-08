package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

public class Order {
    @JsonProperty("id")
    private UUID id = null;

    @JsonProperty("donationPriority")
    private Long donationPriority = null;

    @JsonProperty("payload")
    @Valid
    private List<String> payload = null;

    @JsonProperty("orderDate")
    private OffsetDateTime orderDate = null;

    /**
     * Order Status
     */
    public enum StatusEnum {
        SENDING_ORDER("Sending order"),

        WAITING_FOR_TRUCK("Waiting for truck"),

        READY_FOR_PICKUP("Ready for pickup");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("status")
    private StatusEnum status = null;

    @JsonProperty("complete")
    private Boolean complete = false;

    public Order id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Order donationPriority(Long donationPriority) {
        this.donationPriority = donationPriority;
        return this;
    }

    /**
     * Get donationPriority
     *
     * @return donationPriority
     **/
    @ApiModelProperty(value = "")


    public Long getDonationPriority() {
        return donationPriority;
    }

    public void setDonationPriority(Long donationPriority) {
        this.donationPriority = donationPriority;
    }

    public Order payload(List<String> payload) {
        this.payload = payload;
        return this;
    }

    public Order addPayloadItem(String payloadItem) {
        if (this.payload == null) {
            this.payload = new ArrayList<String>();
        }
        this.payload.add(payloadItem);
        return this;
    }

    /**
     * Get payload
     *
     * @return payload
     **/
    @ApiModelProperty(value = "")


    public List<String> getPayload() {
        return payload;
    }

    public void setPayload(List<String> payload) {
        this.payload = payload;
    }

    public Order orderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    /**
     * Get orderDate
     *
     * @return orderDate
     **/
    @ApiModelProperty(value = "")

    @Valid

    public OffsetDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Order status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Order Status
     *
     * @return status
     **/
    @ApiModelProperty(value = "Order Status")


    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Order complete(Boolean complete) {
        this.complete = complete;
        return this;
    }

    /**
     * Get complete
     *
     * @return complete
     **/
    @ApiModelProperty(value = "")


    public Boolean isComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(this.id, order.id) &&
                Objects.equals(this.donationPriority, order.donationPriority) &&
                Objects.equals(this.payload, order.payload) &&
                Objects.equals(this.orderDate, order.orderDate) &&
                Objects.equals(this.status, order.status) &&
                Objects.equals(this.complete, order.complete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, donationPriority, payload, orderDate, status, complete);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Order {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    donationPriority: ").append(toIndentedString(donationPriority)).append("\n");
        sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
        sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

