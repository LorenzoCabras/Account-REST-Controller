package it.bank.account.dto.fabrick;

import java.util.List;
import java.util.Objects;

public class FabrickResponse<T> {
    private String status;
    private List<FabrickError> errors;

    private T payload;

    public FabrickResponse(String status, List<FabrickError> errors, T payload) {
        this.status = status;
        this.errors = errors;
        this.payload = payload;
    }

    public FabrickResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FabrickError> getErrors() {
        return errors;
    }

    public void setErrors(List<FabrickError> errors) {
        this.errors = errors;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FabrickResponse<?> that = (FabrickResponse<?>) o;
        return Objects.equals(status, that.status) && Objects.equals(errors, that.errors) && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, errors, payload);
    }
}
