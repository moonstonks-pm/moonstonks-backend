package hwr.oop;
//W6PWPCMUGT51Z4O1
class SharePriceData {  //maybe create object so i dont have to pass acronym all the time
    //ToDO pull from JSON files
    static double getSharePrice(String securityAcronym, String purchaseDate) {
        return 120.42;
    }

    static double getCurrentSharePrice(String securityAcronym) {
        //current Date is hardcoded because of the usage of JSON Files instead of a responsive API
        return 89.69;
    }
}
