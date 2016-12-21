package com.ctrip.common.data;

/**
 * Created by manjunath.pandava on 20/12/16.
 */
public enum ELeftMenu {
        FLIGHTS("flights"),
        HOTELS("hotels");

        private String value;

        ELeftMenu(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
}
