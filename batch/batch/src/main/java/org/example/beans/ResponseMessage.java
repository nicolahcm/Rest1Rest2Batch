package org.example.beans;

public class ResponseMessage {

    public String successOrFailure;
    public String cause;

    public long id;

    public ResponseMessage(String successOrFailure, String cause, long id) {
        this.successOrFailure = successOrFailure;
        this.cause = cause;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "successOrFailure='" + successOrFailure + '\'' +
                ", cause='" + cause + '\'' +
                ", id=" + id +
                '}';
    }

    public String getSuccessOrFailure() {
        return successOrFailure;
    }

    public void setSuccessOrFailure(String successOrFailure) {
        this.successOrFailure = successOrFailure;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

