var cart = {};
$('document').ready(function () {
    allGoods();
    findAllCategory();
    checkCart();
    showMiniCart();

});
//повертає ВСі товариa

function allGoods() {
    $.ajax({
        'url': 'http://localhost:8080/goods/allGoods',
        'type': "GET",
        'contentType': 'application/json',
        'success': function (data) {
            var out = '';
            for (var key in data) {
                out += '<div class="single-goods">';
                out += '<button class="later" data-id="' + data[key]['id'] + '">' + "&hearts;" + '</button>';
                out += '<img id="image" src="' + data[key]['image'] + '">';
                out += '<h3>' + data[key]['marka'] + '</h3>';
                out += '<h4>' + data[key]['model'] + '</h4>';
                out += '<p>' + "Ціна:" + "  " + data[key]['price'] + " " + " грн. " + '</p>';
                out += '<button class="add-to-cart" data-id="' + data[key]['id'] + '">' + "Купити" + '</button>';
                out += '</div>'
            }
            $('#goods').html(out);
            $('button.add-to-cart').on('click', addToCart);
            $('button.later').on('click', addToLater);

        }
    });
}
// Завантажуємо всі категорії
function findAllCategory() {
    $.ajax({
        'url': 'http://localhost:8080/goods/findAllCategory',
        'type': "GET",
        'contentType': 'application/json',
        'success': function (data) {
            console.log(data);
            var category = '<select>';
            category += '<option data-id="0">' + "---Категорія---" + '</option>';
            for (var id in data) {
                category += '<option data-id ="' + data[id].id + '">' + data[id].name + '</option>';
            }
            category += '</select>';
            $('.navCategory').html(category);
        }

    })
}

//Завантажуємо товар, по обраній категорії

$('.navCategory').click(function findCategory() {

    var id = $('.navCategory select option:selected').attr('data-id');
    if (id != 0) {
        var category = {
            'id': id
        }

        $.ajax({
            'url': 'http://localhost:8080/goods/findGoodsByCategory',
            'type': "POST",
            'contentType': 'application/json',
            'dataType': 'json',
            'data': JSON.stringify(category),
            'success': function (data) {
                var out = '';
                //                console.log(data);
                for (var key in data) {
                    out += '<div class="single-goods">';
                    out += '<button class="later" data-id="' + data[key]['id'] + '">' + "&hearts;" + '</button>';
                    out += '<img id="image" src="' + data[key]['image'] + '">';
                    out += '<h3>' + data[key]['marka'] + '</h3>';
                    out += '<h4>' + data[key]['model'] + '</h4>';
                    out += '<p>' + "Ціна:" + "  " + data[key]['price'] + " " + " грн. " + '</p>';
                    out += '<button class="add-to-cart" data-id="' + data[key]['id'] + '">' + "Купити" + '</button>';
                    out += '</div>'
                }
                $('#goods').html(out);
                $('button.add-to-cart').on('click', addToCart);
                $('button.later').on('click', addToLater);
            }
        });

    } else {
        allGoods();
    }
$('.navCategory').click(function () {

    var id = $('.navCategory select option:selected').attr('data-id');
    if (id != 0) {
        var category = {
            'id': id
        }
        $.ajax({
            'url': 'http://localhost:8080/goods/findMarkaByCategory',
            'type': "POST",
            'contentType': 'application/json',
            'dataType': 'json',
            'data': JSON.stringify(category),
            'success': function (data) {
                console.log(data);
                var marka = '<select>';
                marka += '<option data-id="0">' + "---Категорія---" + '</option>';
                for (var id in data) {
                    marka += '<option data-id ="' + data[id].id + '">' + data[id].name + '</option>';
                }
                marka += '</select>';
                $('.navMarka').html(marka);
            }
        })
    } else {
        }
    $('.navMarka').click(function () {
    var idMarka = $('.navMarka select option:selected').attr('data-id');
    if (idMarka != 0) {
        var marka = {
            'idMarka': idMarka
        }

        $.ajax({
            'url': 'http://localhost:8080/goods/findGoodsByMarka',
            'type': "POST",
            'contentType': 'application/json',
            'dataType': 'json',
            'data': JSON.stringify(marka),
            'success': function (data) {
                var out = '';
                //                console.log(data);
                for (var key in data) {
                    out += '<div class="single-goods">';
                    out += '<button class="later" data-id="' + data[key]['id'] + '">' + "&hearts;" + '</button>';
                    out += '<img id="image" src="' + data[key]['image'] + '">';
                    out += '<h3>' + data[key]['marka'] + '</h3>';
                    out += '<h4>' + data[key]['model'] + '</h4>';
                    out += '<p>' + "Ціна:" + "  " + data[key]['price'] + " " + " грн. " + '</p>';
                    out += '<button class="add-to-cart" data-id="' + data[key]['id'] + '">' + "Купити" + '</button>';
                    out += '</div>'
                }
                $('#goods').html(out);
                $('button.add-to-cart').on('click', addToCart);
                $('button.later').on('click', addToLater);
            }
        });
    
    } else {
        findCategory();
           }
})
})
})



// кнопка бажання
function addToLater() {
    var later = {};
    if (localStorage.getItem('later')) {
        later = JSON.parse(localStorage.getItem('later'));
    }
    alert('Додано в бажання');
    var id = $(this).attr('data-id');
    later[id] = 1;
    localStorage.setItem('later', JSON.stringify(later));
}
//додати товар в корзину
function addToCart() {
    var article = $(this).attr('data-id');
    if (cart[article] != undefined) {
        cart[article]++;
    } else {
        cart[article] = 1;
    }
    localStorage.setItem('cart', JSON.stringify(cart));
    console.log(cart);
    showMiniCart();
}
//перевіряємо корзину
function checkCart() {
    if (localStorage.getItem('cart') != null) {
        cart = JSON.parse(localStorage.getItem('cart'));
    }
}
//показуємо міні Корзину
function showMiniCart() {
    //показати вміст корзини
    var out = '';
    for (var w in cart) {
        out += w + '---------' + cart[w] + '</br>'
    }
    $('#mini-cart').html(out);
}