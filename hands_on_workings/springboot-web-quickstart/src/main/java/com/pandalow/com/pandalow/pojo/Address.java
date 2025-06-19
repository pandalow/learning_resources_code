package com.pandalow.com.pandalow.pojo;

public class Address {
    private String address;
    private String province;

    public Address() {
    }

    public Address(String address, String province) {
        this.address = address;
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
