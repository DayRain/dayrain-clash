package com.ph.remote.config;

import org.hibernate.dialect.MySQL57Dialect;

public class TableTypeConfig extends MySQL57Dialect {

    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
    }
}
