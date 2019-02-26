import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumbers {

    private List<String> phoneNumbers;

    public PhoneNumbers(List<String> phoneNumberList) {
        phoneNumbers = getPhoneNumbers(phoneNumberList);
    }

    private List<String> getPhoneNumbers(List<String> phoneNumberList) {
        List<String> pn = phoneNumberList.stream().map(phNum -> phNum.split(",", 2))
                .map(arrOfStr -> arrOfStr[1].replaceAll("-", "").replaceAll(" ", ""))
                .sorted(Comparator.comparingInt(s -> s.length())).collect(Collectors.toList());

        return pn;
    }

    public String checkNumbers() {

        if(phoneNumbers.stream().anyMatch(ph ->
            phoneNumbers.stream().filter(pnNumber -> pnNumber.length() >= ph.length()).filter(pnNumber -> !ph.equals(pnNumber))
                .map(s -> s.substring(0,ph.length())).collect(Collectors.toList())
                    .contains(ph))){
            return "Inconsistent";
        }

        return "Consistent";
    }
}
