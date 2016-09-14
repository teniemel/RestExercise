package prizeservice;

import java.util.List;
import java.util.ArrayList;

public class PrizeService
{
    // Use mock for testing purpopses until we get real implementation
    private final EligibilityServiceMock eligibilityService = new EligibilityServiceMock();
    
    private static final String sportsPackage = "SPORTS";
    private static final String moviesPackage = "MOVIES";
    private static final String gossipPackage = "GOSSIP";
    private static final String kidsPackage = "KIDS";
    
    private static final String sportingEventPrize = "FreeSportingEventTicket";
    private static final String movieTicketPrize = "FreeMovieTicket";

    public List<String> getPrizeList(
            String accountNumber,
            List<String> channelPackages) throws InvalidAccountNumberException
    {
        List<String> prizeList = new ArrayList<String>();
        try
        {
            if(eligibilityService.isAccountEligible(accountNumber))
            {
               for(String p : channelPackages)
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
}
