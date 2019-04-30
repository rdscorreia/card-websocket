var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#cards").html("");
}

function connect() {
    var socket = new SockJS('/card-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/withdraw/response', function (Transaction) {
            showTransaction(JSON.parse(Transaction.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/withdraw", {}, JSON.stringify({'action' : 'withdraw', 'cardnumber': $("#cardnumber").val(), 'amount' : $("#amount").val()}));
}

function showTransaction(message) {
    $("#cards").append("<tr><td>Action: " + message.action + "</td> <td>Code: " + message.code + "</td> <td>Autorization Code: " + message.authorizationCode + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

