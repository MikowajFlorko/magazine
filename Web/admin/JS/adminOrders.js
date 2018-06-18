function getOrders() {
    $.ajax({
        'url': 'http://localhost:8080/admin/allOrders',
        'type': "GET",
        'contentType': 'application/json',
        'headers': {
            //                       companyId: "asdsg",
            Token: localStorage.getItem('token')
        },
        'success': function (data) {
            for (var i = 0; i < data.length; i++) {
                var id = $('#id');
                var name = $('#FirstName');
                var email = $('#Email');
                var phone = $('#phone');
                var goodsMarka = $('#marka');
                var goodsModel = $('#model');
                var priceOne = $('#priceOne');
                var price = $('#price');
                var quantity = $('#quantity');
                var date = $('#Date');
                var Delete = $('#Delete');
                id.append('<ol>' + data[i].id + '</ol>');
                name.append('<ol>' + data[i].name + '</ol>');
                email.append('<ol>' + data[i].email + '</ol>');
                phone.append('<ol>' + data[i].phone + '</ol>');
                goodsMarka.append('<ol>' + data[i].goodsMarka + '</ol>');
                goodsModel.append('<ol>' + data[i].goodsModel + '</ol>');
                price.append('<ol>' + data[i].price + '</ol>');
                priceOne.append('<ol>' + data[i].price * data[i].quantity + '</ol>');
                quantity.append('<ol>' + data[i].quantity + '</ol>');
                //                            var date = new Date(data[i].date);
                date.append('<ol>' + new Date(data[i].date).getFullYear(date) + - +
                    (new Date(data[i].date).getMonth(date) + 1) + - +
                    new Date(data[i].date).getDate(date) + " " + new Date(data[i].date).getHours(date) + ":" + new Date(data[i].date).getMinutes(date) + ":" + new Date(data[i].date).getSeconds(date) + '</ol>');
                Delete.append('<font size="-1"><ol><button class="delete" value="' + data[i].id + '">Delete</button></ol></font>');
            }
            setClickOnDelete();

        }
    });
}

getOrders();

function setClickOnDelete() {
    $('.delete').click(function () {
        var deleteReq = {
            'id': this.value
        }
        $.ajax({
            'url': 'http://localhost:8080/admin/deleteOrders',
            'type': "DELETE",
            'contentType': 'application/json',
            'headers': {
                //                       companyId: "asdsg",
                Token: localStorage.getItem('token')
            },
            'dataType': 'json',
            'data': JSON.stringify(deleteReq),
            'success': function () {
                $('#numberPage').empty();
                location.reload();
            }
        });
    });
}

$('#btnExit').click(function () {
    localStorage.clear();
})