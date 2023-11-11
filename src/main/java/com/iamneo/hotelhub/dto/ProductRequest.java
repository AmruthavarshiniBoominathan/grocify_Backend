package com.iamneo.hotelhub.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
public class ProductRequest {
        @Setter
        private String department;

        @Setter
        private String name;

        @Setter
        private String price;

        @Setter
        private int stock;
    }
