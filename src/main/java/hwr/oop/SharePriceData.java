package hwr.oop;

class SharePriceData {  //maybe create object so i dont have to pass acronym all the time
    //ToDO pull from JSON files
    static double getShareCurrentPrice(String securityAcronym, String purchaseDate) {
        return 120.42;
    }

    static double getShareCurrentPrice(String securityAcronym) {
        return 89.69;
    }
}
