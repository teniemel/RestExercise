package prizeservice;

import java.util.List;
import java.util.ArrayList;

public class PrizeService
{
    private String accountNumber;
    private List<String> channelPackages;
    // Use mock for testing purpopses until we get real implementation
    private final EligibilityServiceMock eligibilityService = new EligibilityServiceMock();
    
    private static final String sportsPackage = "SPORTS";
    private static final String moviesPackage = "MOVIES";
    private static final String gossipPackage = "GOSSIP";
    private static final String kidsPackage = "KIDS";
    
    private static final String sportingEventPrize = "FreeSportingEventTicket";
    private static final String movieTicketPrize = "FreeMovieTicket";
    
    // Set account information
    public void setAccountInformation(String accountNumber, List<String> channelPackages)
    {
        this.accountNumber = accountNumber;
        this.channelPackages = channelPackages;
    }

    // Returns list of channel packages
    public List<String> getChannelPackages() 
    {
        return channelPackages;
    }
    
    // Returns list of prizes
    public List<String> getPrizes() throws InvalidAccountNumberException
    {
        List<String> prizeList = getPrizeList();
        reset();
        return prizeList;
    }
    
    private String getPrize(String channelPackage)
    {
        if(channelPackage.equals(this.sportsPackage))
        {
            return sportingEventPrize;
        }
        else if(channelPackage.equals(this.moviesPackage) ||
                channelPackage.equals(this.gossipPackage))
        {
            return movieTicketPrize;
        }
        
        return "";
    }
    
    private List<String> getPrizeList() throws InvalidAccountNumberException
    {
        if(this.accountNumber.isEmpty())
        {
            // Throw exception
            //throw new InvalidAccountNumberException();
        }
    
        List<String> prizeList = new ArrayList<String>();
        try
        {
            if(eligibilityService.isAccountEligible(this.accountNumber))
            {
               for(String p : this.channelPackages)
               {
                    String prize = getPrize(p);
                    // Add only is not already existing and not empty
                    if(!prize.isEmpty() && !prizeList.contains(prize))
                    {
                        prizeList.add(prize);
                    }             
               }
            }
        }
        catch(InvalidAccountNumberException exc)
        {
            System.out.println("Exception: " + exc);
            // Propagate
            throw exc;
        }
        catch(TechnicalFailureException exc)
        {
            System.out.println("Exception: " + exc);
        }
        
        return prizeList;
    }
    
    private void reset()
    {
        this.accountNumber = new String();
        this.channelPackages.clear();
    }
}
