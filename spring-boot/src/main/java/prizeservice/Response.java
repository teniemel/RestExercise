package prizeservice;

import java.util.List;

// Response class which is used to create JSON response
public class Response
{
    private List<String> channelPackages;
    private List<String> prizeList;

    public Response(List<String> channelPackages)
    {
        this.channelPackages = channelPackages;
    }

    public void setPrizes(List<String> prizeList)
    {
        this.prizeList = prizeList;
    }

    // Following methods create content to JSON
    public List<String> getChannelPackages()
    {
        return this.channelPackages;
    }

    public List<String> getPrizes()
    {
        return this.prizeList;
    }
}
