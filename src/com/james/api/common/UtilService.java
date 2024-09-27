package com.james.api.common;

public interface UtilService {
    int createRandomInteger(int start, int gapBetweenStartAndEnd);
    double createRandomDouble(double start, double gapBetweenStartAndEnd);
    public String createRandomJob();
    String createRandomName();
    String createRandomContent();
    String createRandomTitle();
    String createRandomCompany();
    String createRandomUsername();
}
