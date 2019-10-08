package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Vendor
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

public class Vendor {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("donationPriority")
  private Long donationPriority = null;

  @JsonProperty("menu")
  @Valid
  private List<Food> menu = null;

  /**
   * Vendor Status
   */
  public enum StatusEnum {
    SHORT_WAIT("Short wait"),

    BUSY("Busy"),

    VERY_BUSY("Very Busy"),

    INACTIVE("Inactive");

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

  public Vendor id(UUID id) {
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

  public Vendor donationPriority(Long donationPriority) {
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

  public Vendor menu(List<Food> menu) {
    this.menu = menu;
    return this;
  }

  public Vendor addMenuItem(Food menuItem) {
    if (this.menu == null) {
      this.menu = new ArrayList<Food>();
    }
    this.menu.add(menuItem);
    return this;
  }

  /**
   * Get menu
   *
   * @return menu
   **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Food> getMenu() {
    return menu;
  }

  public void setMenu(List<Food> menu) {
    this.menu = menu;
  }

  public Vendor status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Vendor Status
   *
   * @return status
   **/
  @ApiModelProperty(value = "Vendor Status")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Vendor complete(Boolean complete) {
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
    Vendor vendor = (Vendor) o;
    return Objects.equals(this.id, vendor.id) &&
            Objects.equals(this.donationPriority, vendor.donationPriority) &&
            Objects.equals(this.menu, vendor.menu) &&
            Objects.equals(this.status, vendor.status) &&
            Objects.equals(this.complete, vendor.complete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, donationPriority, menu, status, complete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vendor {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    donationPriority: ").append(toIndentedString(donationPriority)).append("\n");
    sb.append("    menu: ").append(toIndentedString(menu)).append("\n");
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

