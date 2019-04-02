var baseURL = "http://localhost:8080";
function grantUserAuthority() {
    var userURL = "/users";

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var request = new XMLHttpRequest();
    var requestURL = baseURL+userURL+"/"+username;
    request.open('GET', requestURL, true, username, password);

    request.onload = function () {
        console.log(request);
        var response = this.response;
        if (response == "") {
            alert("Bad credentials");
        }
        else {
            console.log("Here is the response: "+response);
            var sessionID = response.sessionId;
        }
    }
    request.send();

    // var requestURL = baseURL+userURL+"/"+username;
    // var headers = new Headers();
    // headers.set('Authorization', 'Basic ' + window.btoa(username + ":" + password));
    // fetch(requestURL, {method:'GET',
    //     headers: headers,
    //     //credentials: 'user:passwd'
    // })
    //     .then(function(response) {
    //         if (!response.ok) {
    //             throw Error(response.statusText);
    //         }
    //         return response;
    //     })
    //     .then(response => response.json())
    //     .then(json => console.log(json));
}