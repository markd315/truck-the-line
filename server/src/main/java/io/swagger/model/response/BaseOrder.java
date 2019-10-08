package io.swagger.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;
import java.util.UUID;

public class BaseOrder {
    @JsonProperty("id")
    private UUID id = null;

    @JsonProperty("placedBy")
    private String placedBy = null;

    @JsonProperty("donationPriority")
    private Long donationPriority = null;

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
        public static io.swagger.model.Order.StatusEnum fromValue(String text) {
            for (io.swagger.model.Order.StatusEnum b : io.swagger.model.Order.StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("status")
    private io.swagger.model.Order.StatusEnum status = null;

    @JsonProperty("complete")
    private Boolean complete = false;

    public BaseOrder id(UUID id) {
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

    public BaseOrder donationPriority(Long donationPriority) {
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

    /**
     * Get payload
     *
     * @return payload
     **/
    @ApiModelProperty(value = "")


    public BaseOrder orderDate(OffsetDateTime orderDate) {
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

    public String getPlacedBy() {
        return placedBy;
    }

    public void setPlacedBy(String placedBy) {
        this.placedBy = placedBy;
    }

    public BaseOrder status(io.swagger.model.Order.StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Order Status
     *
     * @return status
     **/
    @ApiModelProperty(value = "Order Status")


    public io.swagger.model.Order.StatusEnum getStatus() {
        return status;
    }

    public void setStatus(io.swagger.model.Order.StatusEnum status) {
        this.status = status;
    }

    public BaseOrder complete(Boolean complete) {
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
        BaseOrder order = (BaseOrder) o;
        return Objects.equals(this.id, order.id) &&
                Objects.equals(this.donationPriority, order.donationPriority) &&
                Objects.equals(this.orderDate, order.orderDate) &&
                Objects.equals(this.status, order.status) &&
                Objects.equals(this.placedBy, order.placedBy) &&
                Objects.equals(this.complete, order.complete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, donationPriority, orderDate, status, complete, placedBy);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Order {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    donationPriority: ").append(toIndentedString(donationPriority)).append("\n");
        sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    placedBy: ").append(toIndentedString(placedBy)).append("\n");
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