// Replace with actual implementation when available
var eligibilityService = require('./EligibilityServiceMock.js');

var movieTicketPrize = "MovieTicket";
var sportingEventPrize = "SportingEventTicket";

var sportPackage = "SPORTS";
var moviesPackage = "MOVIES";
var kidsPackage = "KIDS";
var gossipPackage = "GOSSIP";

// Public API

module.exports.prizes =
{
    MovieTicketPrize : movieTicketPrize,
    SportingEventPrize : sportingEventPrize
}

module.exports.getPrizes = function(accountNumber, channelPackages)
{
    var json = {};
    try
    {
        if(eligibilityService.isCustomerEligible(accountNumber) === true)
        {
            json = getPrizeList(channelPackages);
            json.ChannelPackages = channelPackages
        }
    }
    catch(err)
    {
        console.log("Error: " + err)
        // If InvalidAccount error send forward
        if(err === eligibilityService.errors.InvalidAccountNumber)
        {
            throw eligibilityService.errors.InvalidAccountNumber;
        }
    }

    return json;
}

// Private functions


function getPrizeList(channelPackages)
{
    var sportPrize = false;
    var moviePrize = false;
    for(var i = 0; i < channelPackages.length; i++)
    {
        if(channelPackages[i] === sportPackage)
        {
            sportPrize = true;
        }
        else if(channelPackages[i] === moviesPackage ||
                channelPackages[i] === gossipPackage)
        {
            moviePrize = true;
        }
    }

    var json = {};
    json.Prizes = [];
    if(sportPrize)
    {
        json.Prizes.push(sportingEventPrize);
    }
    if(moviePrize)
    {
        json.Prizes.push(movieTicketPrize);
    }

    return json
}
