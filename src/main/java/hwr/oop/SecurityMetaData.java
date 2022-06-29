package hwr.oop;

class SecurityMetaData {

    private final String[] sector;
    private final String[] industry;
    private final String[] region;
    private final String[] country;
    private final String securityAcronym;
    private final String securityType;

    SecurityMetaData(String securityAcronym) {
        this.securityAcronym = securityAcronym;
        this.industry= new String[]{"Software"}; //  ToDo get constructor information from JSON-File API
        this.sector = new String[]{"IT"};
        this.country = new String[]{"Germany"};
        this.region = new String[]{"Europe"};
        this.securityType = "Stock";
    }

    String getSecurityAcronym() {
        return this.securityAcronym;
    }
    String[] getSector() {
        return this.sector;
    }

    String[] getIndustry(){
        return this.industry;
    }

    String[] getRegion() {
        return this.region;
    }

    String[] getCountry(){
        return this.country;
    }

    String getSecurityType() {
        return this.securityType;
    }
}
