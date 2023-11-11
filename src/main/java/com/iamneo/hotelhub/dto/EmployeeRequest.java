package com.iamneo.hotelhub.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class EmployeeRequest {
    @Setter
    private String name;
    @Setter
    private String position;
    @Setter
    private String shift;
    @Setter
    private int salary;
}
