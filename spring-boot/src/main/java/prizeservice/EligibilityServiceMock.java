package prizeservice;

// This Mock is used for testing purposes

public class EligibilityServiceMock
{
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
