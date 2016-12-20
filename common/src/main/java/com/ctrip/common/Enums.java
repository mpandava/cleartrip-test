package com.ctrip.common;

/**
 * Created by manjunath.pandava on 20/12/16.
 */
public class Enums {
    public enum LeftMenu {
        FLIGHTS("flights"),
        HOTELS("hotels");

        private String value;

        LeftMenu(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
