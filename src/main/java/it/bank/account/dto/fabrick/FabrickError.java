package it.bank.account.dto.fabrick;

import java.util.Objects;

public class FabrickError {
    private String code;
    private String description;
    private String params;

    public FabrickError(String code, String description, String params) {
        this.code = code;
        this.description = description;
        this.params = params;
    }

    public FabrickError() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FabrickError that = (FabrickError) o;
        return Objects.equals(code, that.code) && Objects.equals(description, that.description) && Objects.equals(params, that.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description, params);
    }

    @Override
    public String toString() {
        return "FabrickError{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", params='" + params + '\'' +
                '}';
    }
}
