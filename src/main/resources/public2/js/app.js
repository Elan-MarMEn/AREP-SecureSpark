app = (function () {

    function send() {
        var num = $("#number").val()
        var promise = $.post({
            url: "/add",
            data: num,
            contentType: "application/json"
        });
        promise.then(function(data){
        }, function(error) {
            alert("Try again")
        });
    }

    function getList(){
        var promise = $.get({
            url: "/dataset",
            contentType: "application/json"
        });
        promise.then(function(data){
            console.log(data);
            var temp = JSON.parse(data)
            showData(temp.Dataset)
        }, function(error) {
            alert("Failed");
        });
    }

    function showData(data){
        $(".sub_setNumber").remove();
        for (let i = 0; i < data.length; i++) {
            var setNumber = "<tr class='sub_setNumber'><th>"+ data[i].Data +"</th></tr>"
            $('#setNumber').append(setNumber);
        }
    }

    return{
        send:send,
        getList:getList
    }
})();