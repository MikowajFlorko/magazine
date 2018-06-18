function init() {
    var hash = window.location.hash.substring(1);
    console.log(hash);
    var findOne = {
        "id": hash
    }
    $.ajax({
        'url': 'http://localhost:8080/admin/findOne',
        'type': "POST",
        'contentType': 'application/json',
        'dataType': 'json',
        'data': JSON.stringify(findOne),
        'success': function (data) {
            console.log(data);
            var out = '';
              out += '<div class="single-goods">';
                out += '<button class="later" data-id="' + data.id + '">' + "&hearts;" + '</button>';
                out += '<p>' + data.marka + '</p>';
                out += '<p>' + data.model + '</p>';
                out += '<p>' + "Ціна:" + " " + data.price +" "+"грн. "+ '</p>';
                out += '<button class="add-to-cart" data-id="' + data.id + '">' + "Купити" + '</button>';
                out += '</div>'
            $('#goods').html(out); 
        }

    });
//    getGoods();
}
//
//function getGoods() {
//    $.ajax({
//        'url': 'http://localhost:8080/admin/allGoods',
//        'type': "GET",
//        'contentType': 'application/json',
//        'success': function (data) {
//            console.log(data)
//            var out = '';
//                
//                out += '<div class="single-goods">';
//                out += '<button class="later" data-id="' + data.id + '">' + "&hearts;" + '</button>';
//                out += '<p>' + data.name + '</p>';
//                out += '<p>' + data.price + '</p>';
//                out += '<button class="add-to-cart" data-id="' + data.id + '">' + "Купити" + '</button>';
//                out += '</div>'
//            $('#goods').html(out);
////                            $('button.add-to-cart').on('click', addToCart);
////                            $('button.later').on('click', addToLater);
//        }
//    });
//
//}
$(document).ready(function () {
    init();
})