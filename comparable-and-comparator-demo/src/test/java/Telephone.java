public class Telephone {

    private final int countryCode;
    private final String areaCode;
    private final int number;

    public Telephone(int countryCode, String areaCode, int number) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
    }

//    @Override
//    public int compareTo(Telephone o) {
//        int result = Integer.compare(countryCode, o.countryCode);
//        if (0 == result) {
//            result = String.CASE_INSENSITIVE_ORDER.compare(areaCode, o.areaCode);
//            if (0 == result) {
//                result = Integer.compare(number, o.number);
//            }
//        }
//        return result;
//    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "countryCode=" + countryCode +
                ", areaCode=" + areaCode +
                ", number=" + number +
                '}';
    }
}
