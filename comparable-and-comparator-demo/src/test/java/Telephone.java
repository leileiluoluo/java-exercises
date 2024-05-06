public class Telephone implements Comparable<Telephone> {

    private final int countryCode;
    private final String areaCode;
    private final int number;

    public Telephone(int countryCode, String areaCode, int number) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
    }

    @Override
    public int compareTo(Telephone o) {
        int result = Integer.compare(countryCode, o.countryCode);
        if (0 == result) {
            result = String.CASE_INSENSITIVE_ORDER.compare(areaCode, o.areaCode);
            if (0 == result) {
                result = Integer.compare(number, o.number);
            }
        }
        return result;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "countryCode=" + countryCode +
                ", areaCode=" + areaCode +
                ", number=" + number +
                '}';
    }
}
