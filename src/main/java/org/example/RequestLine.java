package org.example;

public class RequestLine {

    private final String method;  // GET
    private final String urlPath;  // /calculate?operand1=11&operator=*&operand2=55

    //    GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];
        this.urlPath = tokens[1];
    }
}
