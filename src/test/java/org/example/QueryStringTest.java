package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {

    // operand1=11&operator=*&operand2=55
    // QueryString은 key, value를 하나만 가지는 객체
    // List<QueryString> 여러 개의 객체를 위함
    @Test
    void createTest() {
        QueryString queryString = new QueryString("operand1", "11");

        assertThat(queryString).isNotNull();
    }
}
