package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

public class User {
    @JsonProperty("firstName")
    private String firstName = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("minAuthCode")
    private String minAuthCode = null;

    @JsonProperty("userStatus")
    private Integer userStatus = null;


    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")


    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     *
     * @return firstName
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User minAuthCode(String minAuthCode) {
        this.minAuthCode = minAuthCode;
        return this;
    }

    /**
     * Get minAuthCode
     *
     * @return minAuthCode
     **/
    @ApiModelProperty(value = "")


    public String getMinAuthCode() {
        return minAuthCode;
    }

    public void setMinAuthCode(String minAuthCode) {
        this.minAuthCode = minAuthCode;
    }

    public User userStatus(Integer userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    /**
     * User Status
     *
     * @return userStatus
     **/
    @ApiModelProperty(value = "User Status")


    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.firstName, user.firstName) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.minAuthCode, user.minAuthCode) &&
                Objects.equals(this.userStatus, user.userStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, email, minAuthCode, userStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    minAuthCode: ").append(toIndentedString(minAuthCode)).append("\n");
        sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
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

