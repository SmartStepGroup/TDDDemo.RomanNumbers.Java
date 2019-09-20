package viewModels;

import backup.ArabicToRomanNumberConverter;

public class ArabicToRomanViewModel {
    private boolean isConvertButtonEnabled = false;
    private String arabicNumberText = "";
    private String romanNumberText = "";
    private ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();
    private String errorMessage = "";

    public boolean isConvertButtonEnabled() {
        return isConvertButtonEnabled;
    }

    public void setArabicNumberText(String arabicNumberText) {
        if (arabicNumberText.equals("")) {
            errorMessage = "";
            isConvertButtonEnabled = false;
            return;
        }
        if (!arabicNumberText.matches("\\d+")) {
            isConvertButtonEnabled = false;
            errorMessage = "Only digits, please";
            return;
        }
        if (Integer.parseInt(arabicNumberText) >= 4000) {
            isConvertButtonEnabled = false;
            return;
        }

        this.arabicNumberText = arabicNumberText;
        errorMessage = "";
        isConvertButtonEnabled = true;
    }

    public void convert() {
        romanNumberText = converter.Convert(Integer.parseInt(arabicNumberText));
    }

    public String getRomanNumberText() {
        return romanNumberText;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
