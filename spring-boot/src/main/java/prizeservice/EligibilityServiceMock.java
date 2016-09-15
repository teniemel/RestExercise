package prizeservice;

/**
 * EligibilityServiceMock is used for testing purposes until
 * real service is available
 */
public class EligibilityServiceMock
{
    /**
     * Checks wether account is eligible for prize
     * @param accountNumber Account number to check
     * @return True if eligible else False
     */
    public boolean isAccountEligible(String accountNumber) throws InvalidAccountNumberException, TechnicalFailureException
    {
        // TODO: Replace this part with real actual communication with EligibilityService when it's available

        if(accountNumber.equals("1111"))
        {
            // Eligible user
            System.out.println("Eligible user");
            return true;
        }
        else if(accountNumber.equals("2222"))
        {
            // We get TechicalFailure exception
            throw new TechnicalFailureException();
        }
        else if(accountNumber.equals("3333"))
        {
            // Non eligible user
            System.out.println("Non eligible user");
            return false;
        }
        else
        {
            // Rest account numbers cause InvalidAccountNumber exception
            throw new InvalidAccountNumberException();
        }
    }
}
