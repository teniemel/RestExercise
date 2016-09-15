package prizeservice;

import java.util.List;
import org.springframework.util.MultiValueMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/get_prizes")
public class PrizeServiceController
{
    private final PrizeService prizeService = new PrizeService();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Response getPrizes(
        @RequestParam MultiValueMap<String, String> params) throws InvalidAccountNumberException
    {
        String accountNumber = params.getFirst("accountNumber");
        List<String> channelPackages = params.get("channelPackage");

        System.out.println("getPrizes: accountNumber: "
                           + accountNumber +
                           " channelPackages: " + channelPackages);

        Response response = new Response(channelPackages);

        List<String> prizes = prizeService.getPrizeList(accountNumber, channelPackages);
        response.setPrizes(prizes);
        return response;
    }
}
