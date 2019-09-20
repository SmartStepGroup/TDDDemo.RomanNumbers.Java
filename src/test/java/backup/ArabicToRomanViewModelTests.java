package backup;

import org.junit.Ignore;
import org.junit.Test;
import viewModels.ArabicToRomanViewModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Ignore
public class ArabicToRomanViewModelTests {

    @Test
    public void byDefault_ConvertButtonIsDisabled() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void byDefault_ErrorMessageIsEmpty() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        assertEquals("", viewModel.getErrorMessage());
    }

    @Test
    public void afterEnteringFirstDigit_ConvertButtonIsEnabled() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("1");

        assertTrue(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void afterClearingArabicNumberText_ConvertButtonIsDisabled() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("");

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void afterEnteringNonDigitToArabicNumberText_ConvertButtonIsDisabled() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("a");

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void afterEnteringNonDigitToArabicNumberText_ErrorMessageIsShown() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("a");

        assertEquals("Only digits, please", viewModel.getErrorMessage());
    }

    @Test
    public void afterEnteringNonDigitThenDigitToArabicNumberText_ErrorMessageIsHidden() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("a");
        viewModel.setArabicNumberText("1");

        assertEquals("", viewModel.getErrorMessage());
    }

    @Test
    public void afterEnteringNonDigitThenClearingToArabicNumberText_ErrorMessageIsHidden() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("a");
        viewModel.setArabicNumberText("");

        assertEquals("", viewModel.getErrorMessage());
    }

    @Test
    public void afterEnteringNonDigitThenClearingToArabicNumberText_ConvertButtonIsEnabled() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("a");
        viewModel.setArabicNumberText("");

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void afterEnteringLargeArabicNumber_ConvertButtonIsDisabled() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("4000");

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void afterEnteringValidArabicNumber_ConvertButtonIsEnabled() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("1");

        assertTrue(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void afterConvertingArabicNumberToRoman_RomanNumberIsDisplayed() {
        ArabicToRomanViewModel viewModel = new ArabicToRomanViewModel();

        viewModel.setArabicNumberText("1");
        viewModel.convert();

        assertEquals("I", viewModel.getRomanNumberText());
    }
}

