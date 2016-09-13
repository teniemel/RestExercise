// This is EligibilityServiceMock used for testing PrizeService.

var technicalFailureError = "TechnicalFailure";
var invalidAccountNumberError = "InvalidAccountNumber";

// Public API

module.exports.errors =
{
    TechnicalFailure : technicalFailureError,
    InvalidAccountNumber : invalidAccountNumberError
}

module.exports.isCustomerEligible = function(accountNumber)
{
    // Hardcoded return value for testing purposes
    switch(String(accountNumber))
    {
    case "1111":
        return true;
    case "2222":
        throw technicalFailureError;
    case "3333":
        throw invalidAccountNumberError;
    default:
        return false;
    }
}

// Private functions
