import org.junit.Test;
import viewModels.ArabicToRomanConverterViewModel;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ArabicToRomanConverterViewModelTests {
    @Test
    public void byDefault_ConvertButtonIsDisabled() {
        ArabicToRomanConverterViewModel viewModel = new ArabicToRomanConverterViewModel();

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void whenEnterArabicNumber_ConvertButtonIsEnabled() {
        ArabicToRomanConverterViewModel viewModel = new ArabicToRomanConverterViewModel();

        viewModel.setArabicNumber("1");

        assertTrue(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void whenClearArabicNumber_ConvertButtonIsDisabled() {
        ArabicToRomanConverterViewModel viewModel = new ArabicToRomanConverterViewModel();

        viewModel.setArabicNumber("1");
        viewModel.setArabicNumber("");

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void whenConvert1_DisplayRomanNumberI() {
        ArabicToRomanConverterViewModel viewModel = new ArabicToRomanConverterViewModel();

        viewModel.setArabicNumber("1");
        viewModel.convert();

        assertEquals("I", viewModel.getRomanNumber());
    }

    @Test
    public void whenEnterInvalidArabicNumber_ConvertButtonIsDisabled() {
        ArabicToRomanConverterViewModel viewModel = new ArabicToRomanConverterViewModel();

        viewModel.setArabicNumber("a");

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void whenEnterInvalidArabicNumber_ShowErrorMessage() {
        ArabicToRomanConverterViewModel viewModel = new ArabicToRomanConverterViewModel();

        viewModel.setArabicNumber("a");

        assertEquals("Only digits please", viewModel.getErrorMessage());
    }

    @Test
    public void whenCorrectInvalidArabicNumber_HideErrorMessage() {
        ArabicToRomanConverterViewModel viewModel = new ArabicToRomanConverterViewModel();

        viewModel.setArabicNumber("a");
        viewModel.setArabicNumber("1");

        assertEquals("", viewModel.getErrorMessage());
    }

    @Test
    public void whenClearArabicNumber_HideErrorMessage() {
        ArabicToRomanConverterViewModel viewModel = new ArabicToRomanConverterViewModel();

        viewModel.setArabicNumber("a");
        viewModel.setArabicNumber("");

        assertEquals("", viewModel.getErrorMessage());
    }
}
