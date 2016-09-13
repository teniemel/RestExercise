var http = require('http');
var prizeService = require('./PrizeService.js');
var bodyParser = require('body-parser');
var express = require('express');
var app = express();

// Could be given as parameter
var listenPort = 8080;

// Error handling for unknown requests
function errorHandler(err, request, response, next)
{
    response.status(400).send("Bad Request!!!");
}
app.use(errorHandler);
app.use(bodyParser.urlencoded({ extended: true }));

// Rest handling
app.post('/getPrizes', function(request, response)
{
    var accountNumber = request.body.accountNumber;
    var channelPackages = [];
    if(Array.isArray(request.body.channelPackage))
    {
        channelPackages = request.body.channelPackage;
    }
    else
    {
        channelPackages.push(request.body.channelPackage)
    }

    console.log("getPrizes for account: " + accountNumber +
                " packages: " + channelPackages);

    var respJson = {};
    try
    {
        respJson = prizeService.getPrizes(accountNumber, channelPackages);
    }
    catch(err)
    {
        console.log("Error in Prize service: " + err);
    }

    response.send(JSON.stringify(respJson, undefined, 4));
});

// Create server
server = http.createServer(app).listen(listenPort);

console.log("Server up and running...");
