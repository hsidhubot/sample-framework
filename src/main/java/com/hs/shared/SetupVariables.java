package com.hs.shared;

import lombok.Data;

import java.util.List;

@Data
public class SetupVariables {

    public String email;
    public String name;
    public String password;
    public String firstName;
    public String lastName;
    public String searchPostcode;
    public String mobileLocator;
    public String dayTimePhoneLocator;
    public String eveningPhoneLocator;
    public String appointmentTime;
    public String appointmentMonth;
    public String appointmentDate;
    public List<String> newHomes = null;
    public List<String> newHomesSearchResult = null;
    public List<String> newHomesDevelopment = null;
    public List<String> newHomesPlots = null;
    public List<String> registerInterestProposedDevelopments = null;

    public final String test = "hello";

    private static volatile SetupVariables instance = null;

    private SetupVariables() {
    }

    public static SetupVariables getInstance() {
        if (instance == null) {
            synchronized (SetupVariables.class) {
                if (instance == null) {
                    instance = new SetupVariables();
                }
            }
        }
        return instance;
    }

}




