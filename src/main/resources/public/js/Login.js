Login = (function () {

    function send() {
        var datalog = {
            "name": $("#name").val(),
            "pwd":$("#pwd").val()
        } 
        var promise = $.post({
            url: "/logged",
            data: JSON.stringify(datalog),
            contentType: "application/json"
        });
        promise.then(function(data){
            if(data=="true"){
                alert("Log-in Succesfully");
                // getResult(data);
                window.location.href = "https://ec2-100-25-38-119.compute-1.amazonaws.com:5001/"
            }else{
                alert("Username or pasword is incorrect");
                window.location.reload();
            }
        }, function(error) {
            alert("Try again")
        });
    }



    return{
        send:send
    }
})();