package it.generali.r2.beans;

public class ResponseMessage {

    public String successOrFailure;
    public String cause;
    public int id;

    public ResponseMessage(String successOrFailure, String cause, int id) {
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
}